import java.awt.*;

public abstract class Car {

    private Color color;
    private int nrDoors;
    private double currentSpeed;
    private double enginePower;
    private String modelName;

    public Car(Color color, int nrDoors, double enginePower, String modelName) {
        this.color = color;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();

    }

    public Color getColor() {
        return this.color;
    }
    public int getNrDoors(){
        return this.nrDoors;
    }
    public double getCurrentSpeed(){
        return this.currentSpeed;
    }
    public double getEnginePower(){
        return this.enginePower;
    }
    public String getModelName(){
        return this.modelName;
    }

    public void stopEngine(){
        this.currentSpeed = 0;
    }
    public void startEngine(){
        this.currentSpeed = 0.1;
    }
    public void setColor(Color clr){
        color = clr;
    }
    protected void setCurrentSpeed(double currentSpeed){
        this.currentSpeed = currentSpeed;
    }

    public abstract double speedFactor();
    public abstract void incrementSpeed(double amount);
    public abstract void decrementSpeed(double amount);


}
// Båda bilar Saab och volvo är tydligt "relaterade" med Bilar som innebär att ärv är perfect
// Om interface hade vi behövt implementera delad logic, Behöver inte duplicera kod Och det var ett krav med labben
//Alltså ärv är det rätta valet.

//När det kommer till synlighet så Behöver Car classen vara abstract, Man ska inte kunna göra ett object av Car, bara med
//Hjälp av classen,


