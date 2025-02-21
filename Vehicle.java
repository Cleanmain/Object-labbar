import javax.swing.text.Position;
import java.awt.*;

public abstract class Vehicle implements Movable{

    private Color color;
    private int nrDoors;
    private double currentSpeed;
    private double enginePower;
    private String modelName;
    public double x;
    public double y;
    private Direction direction;

    public enum Direction{     //"Låser" ner vad vi kan skriva som direction
        North, East, South, West;
    }
    private boolean isLoaded;
    private  boolean engineOn;

    public Vehicle(Color color, int nrDoors, double enginePower, String modelName) {
        this.color = color;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
        this.x = 0;
        this.y = 0;
        this.direction = Direction.North;    //Börjar mot norr
        this.isLoaded = false;
        this.engineOn = false;

    }
    public void setLoaded(){this.isLoaded=true;}
    public void setNotLoaded(){this.isLoaded=false;}
    public boolean getIsLoaded(){return this.isLoaded;}
    public void loadedMsg(){System.out.println("Vehicle is load");}

    protected boolean getEngineOn(){
        return this.engineOn;}

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
        this.engineOn = false;
    }
    public void startEngine(){
        this.engineOn = true;
    }
    public void setColor(Color clr){
        color = clr;
    }
    public void setCurrentSpeed(double currentSpeed){
        if(!isLoaded && engineOn) {
            this.currentSpeed = currentSpeed;
        }
    }
    public abstract double speedFactor();
    public abstract double getLength();


    public void incrementSpeed(double amount) {
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;
        setCurrentSpeed(Math.min(newSpeed, getEnginePower()));
    }

    public void decrementSpeed(double amount) {
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        setCurrentSpeed(Math.max(newSpeed, 0));
    }


    @Override
    public void move() {
        if(!isLoaded) {
            if (direction == Direction.North) {
                y += currentSpeed;
            } else if (direction == Direction.South) {
                y -= currentSpeed;
            } else if (direction == Direction.East) {
                x += currentSpeed;
            } else if (direction == Direction.West) {
                x -= currentSpeed;
            }
        }else{
            loadedMsg();
        }
    }

    public void turnLeft() {
        if(!isLoaded) {
            if (direction == Direction.North) {
                direction = Direction.West;
            } else if (direction == Direction.West) {
                direction = Direction.South;
            } else if (direction == Direction.South) {
                direction = Direction.East;
            } else {
                direction = Direction.North;
            }
        }else{
            loadedMsg();
        }
    }

    @Override
    public void turnRight() {
        if (!isLoaded) {
            if (direction == Direction.North) {
                direction = Direction.East;
            } else if (direction == Direction.East) {
                direction = Direction.South;
            } else if (direction == Direction.South) {
                direction = Direction.West;
            } else {
                direction = Direction.North;
            }
        }else{
            loadedMsg();
        }
    }

    public String getPositionString() {
        return "(" + x + ", " + y + ")";
    }


    public Direction getDirection(){ // For Tests
        return direction;
    }

    @Override
    public void gas(double amount) {
        if (!isLoaded && engineOn) {
            if (amount < 0 || amount > 1) {
                System.out.println("Can only take values in the interval 0,1");
            }
            incrementSpeed(amount);
        }else{
            loadedMsg();
        }
    }

    @Override
    public void brake(double amount) {
        if (amount < 0 || amount > 1) {
            System.out.println("Can only take values in the interval 0,1");
        }
        decrementSpeed(amount);
    }

}