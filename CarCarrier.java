import java.awt.*;
import java.util.Stack;

public class CarCarrier extends TruckBase{

    public final static double length = 24.90;
    private boolean rampUp;
    private Stack<MotorVehicle> vehicleStack = new Stack<>();

    CarCarrier(Color color, int nrDoors, double enginePower, String modelName){
        super(color,nrDoors,enginePower,modelName);
        this.rampUp = true;
    }

    public void setRampUp(){
        rampUp = true;
    }

    public void setRampDown(){
        if (canAdjustPlatform()){
            rampUp = false;
        }
    }

    public boolean carInRange(MotorVehicle carToLoad){
        double deltaX = (carToLoad.x - this.x);
        double deltaY = (carToLoad.y - this.y);

        return  (deltaX * deltaX + deltaY * deltaY) < 100;// Ska vara innom 10 units

    }


    public boolean loadVehicle(MotorVehicle carToLoad){
        if (carToLoad.getLength() < 6 && !rampUp && vehicleStack.size() < 6 && carInRange(carToLoad) && !getIsLoaded()){
            vehicleStack.push(carToLoad);
            carToLoad.setLoaded();
            return true;
        }
        System.out.println("Vehicle cant be loaded");
        return false;
    }// Skall max kunna hålla 6 bilar i taget

    public boolean unloadVehicle(){
        if (!rampUp) {
            vehicleStack.pop();

            return true;
        }
        System.out.println("Could not unload, Ramp needs to be down");
        return false;
    }

    public Stack<MotorVehicle> getVehicleStack() {
        return vehicleStack;
    }

    public double getLength(){
        return length;
    }


    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

    @Override
    public void move(){
        if (rampUp){
            super.move();
            for (MotorVehicle car : vehicleStack) {
                car.x = this.x;
                car.y = this.y;
            }
        }
        System.out.println("Must have ramp up to drive!");

    }

}