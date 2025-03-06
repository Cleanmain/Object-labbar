import java.awt.*;

public abstract class MovableVehicle extends Vehicle implements Movable{
    private double currentSpeed;
    public double x;
    public double y;
    private Direction direction;
    public enum Direction{     //"Låser" ner vad vi kan skriva som direction
        North, East, South, West;
    }
    private boolean isLoaded;

    public MovableVehicle(Color color, int nrDoors, double enginePower, String modelName){
        super(color,nrDoors,enginePower,modelName);
        this.x = 0;
        this.y = 0;
        this.direction = Direction.North;    //Börjar mot norr
        this.isLoaded = false;
    }

    public void setLoaded(){this.isLoaded=true;}
    public void setNotLoaded(){this.isLoaded=false;}
    public boolean getIsLoaded(){return this.isLoaded;}
    public double getCurrentSpeed(){
        return this.currentSpeed;
    }
    public void setCurrentSpeed(double currentSpeed){
        this.currentSpeed = currentSpeed;

    }
    public void incrementSpeed(double amount) {
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;
        setCurrentSpeed(Math.min(newSpeed, getEnginePower()));
    }

    public void decrementSpeed(double amount) {
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        setCurrentSpeed(Math.max(newSpeed, 0));
    }
    public Direction getDirection(){ // For Tests
        return direction;
    }
    public String getPositionString() {
        return "(" + x + ", " + y + ")";
    }



    //@Override
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
        }
    }

    //@Override
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
        }
    }

    //@Override
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
        }
    }
    //public abstract double getLength();
    public abstract double speedFactor();



}
