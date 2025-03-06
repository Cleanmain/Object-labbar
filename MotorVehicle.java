import java.awt.*;

public abstract class MotorVehicle extends MovableVehicle implements Motor{
    private  boolean engineOn;

    public MotorVehicle(Color color, int nrDoors, double enginePower, String modelName){
        super(color,nrDoors,enginePower,modelName);
        stopEngine();
        this.engineOn = false;
    }

    protected boolean getEngineOn(){
        return this.engineOn;}
    public void stopEngine(){
        this.engineOn = false;
    }
    public void startEngine(){
        this.engineOn = true;
    }


    @Override
    public void gas(double amount) {
        if (!getIsLoaded() && engineOn) {
            if (amount < 0 || amount > 1) {
                System.out.println("Can only take values in the interval 0,1");
            }
            incrementSpeed(amount);
        }
    }
    @Override
    public void brake(double amount) {
        if (amount < 0 || amount > 1) {
            System.out.println("Can only take values in the interval 0,1");
        }
        decrementSpeed(amount);
    }
    public abstract double speedFactor();
    public abstract double getLength();



}
