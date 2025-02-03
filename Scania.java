import java.awt.*;

public class Scania extends Car {

    double flakAngle;

    public Scania(Color color, int nrDoors, double enginePower, String modelName) {
        super(color, nrDoors, enginePower, modelName);
        this.flakAngle = 0.0;
    }

    public boolean canMove() {
        if (this.flakAngle == 0) {
            return true;
        }
        return false;
    }

    public boolean canMoveFlakAngle() {
        if (this.getCurrentSpeed() == 0) {
            return true;
        }
        return false;
    }

    public double getFlakAngle() {
        return this.flakAngle;
    }

    public void setFlakAngle(double angleAmount) {
        this.flakAngle = angleAmount;
    }

    public void increaseFlakAngle() {
        if (canMoveFlakAngle() && this.flakAngle <= 70) {
            this.flakAngle += 5;
            setFlakAngle(Math.min(70, this.flakAngle));
        }

    }
    public void decreaseFlakAngle(){
        if (canMoveFlakAngle() && this.flakAngle >= 0){
            this.flakAngle -=5;
            setFlakAngle(Math.max(0, this.flakAngle));
        }
    }


    @Override
    public void gas(double amount) {
        double oldSpeed = getCurrentSpeed();
        if (0 <= amount && 1 >= amount) {
            if (canMove()) {
                incrementSpeed(oldSpeed);
            }
        }
    }
}