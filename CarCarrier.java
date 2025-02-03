import java.awt.*;
import java.util.Stack;

public class CarCarrier extends TruckBase{

    public final static double length = 24.90;
    private boolean rampUp;
    private Stack<Vehicle> vehicleStack = new Stack<>();

    CarCarrier(Color color, int nrDoors, double enginePower, String modelName){
        super(color,nrDoors,enginePower,modelName);
        this.rampUp = true;
    }

    public void setRampUp(){
        rampUp = true;
    }

    public void setRampDown(){
        if (this.getCurrentSpeed() == 0){
            rampUp = false;
        }
    }

    public boolean loadVehicle(Vehicle carToLoad){
        if (carToLoad.getLength() > 6 && !rampUp ){
            System.out.println("Vehicle cant be loaded");
            return false;
        }
        vehicleStack.push(carToLoad);
        return true;
    }

    public boolean unloadVehicle(){
        vehicleStack.pop();
        return true;
    }

    public double getLength(){
        return length;
    }


    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

}
