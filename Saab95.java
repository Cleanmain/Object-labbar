import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn; // Encapsulate because there is no direct access from outside

    public Saab95(Color color, int nrDoors, double enginePower, String modelName){
        super(color,nrDoors,enginePower,modelName);
        this.turboOn = false;
    }


    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    @Override
    public void incrementSpeed(double amount) {
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;
        setCurrentSpeed(Math.min(newSpeed, getEnginePower())); // Ensure speed ≤ enginePower
    }

    @Override
    public void decrementSpeed(double amount) {
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        setCurrentSpeed(Math.max(newSpeed, 0)); // Ensure speed ≥ 0
    }
}