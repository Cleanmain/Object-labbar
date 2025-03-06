import javax.swing.text.Position;
import java.awt.*;

public abstract class Vehicle{

    private Color color;
    private int nrDoors;
    private double enginePower;
    private String modelName;


    public Vehicle(Color color, int nrDoors, double enginePower, String modelName) {
        this.color = color;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;


    }

    public void loadedMsg(){System.out.println("Vehicle is load");}



    public Color getColor() {
        return this.color;
    }
    public int getNrDoors(){
        return this.nrDoors;
    }
    public double getEnginePower(){
        return this.enginePower;
    }
    public String getModelName(){
        return this.modelName;
    }


    public void setColor(Color clr){
        color = clr;
    }

    //public abstract double getLength();
















}