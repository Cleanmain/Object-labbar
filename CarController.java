import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities  to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController implements ICarController{
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    ArrayList<MotorVehicle> cars = new ArrayList<>();
    VehicleTracker tracker;





    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        cc.tracker = new VehicleTracker(cc.cars);



        //cc.cars.add(new Volvo240(Color.red,4,125,"Volvo240"));
        //cc.cars.add(new Saab95(Color.red,3,120,"saabtest"));
        //cc.cars.add(new Scania(Color.BLACK,4,100,"Scania"));
        cc.cars.add(AddingCar.CreateCar("volvo"));
        cc.cars.add(AddingCar.CreateCar("Saab"));
        cc.cars.add(AddingCar.CreateCar("scania"));

        int startX = 0;
        for (MotorVehicle car : cc.cars) {
            car.x = startX;  // ✅ Assign each car a unique X position in memory
            car.y = 0;       // Keep Y the same
            startX += 100;   // Move the next car 100 pixels to the right
        }

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc,cc.getVehicleTracker());


        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            tracker.updatePositions();
            frame.drawPanel.repaint();

        }
    }

    public VehicleTracker getVehicleTracker() {
        return this.tracker; // Assuming you have a `tracker` field in `CarController`
    }


    @Override
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (MotorVehicle car : cars) car.gas(gas);
    }

    @Override
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (MotorVehicle car : cars) car.brake(brake);
    }

    @Override
    public void startEngine() {
        for (MotorVehicle car : cars) car.startEngine();
    }

    @Override
    public void stopEngine() {
        for (MotorVehicle car : cars) car.stopEngine();
    }

    @Override
    public void turnLeft() {
        for (MotorVehicle car : cars) car.turnLeft();
    }

    @Override
    public void turnRight() {
        for (MotorVehicle car : cars) car.turnRight();
    }

    @Override
    public void turboOn() {
        for (MotorVehicle car : cars) {
            if (car instanceof Saab95) ((Saab95) car).setTurboOn();
        }
    }

    @Override
    public void turboOff() {
        for (MotorVehicle car : cars) {
            if (car instanceof Saab95) ((Saab95) car).setTurboOff();
        }
    }

    @Override
    public void increaseAngle() {
        for (MotorVehicle car : cars) {
            if (car instanceof Scania) ((Scania) car).increaseFlakAngle();
        }
    }

    @Override
    public void decreaseAngle() {
        for (MotorVehicle car : cars) {
            if (car instanceof Scania) ((Scania) car).decreaseFlakAngle();
        }
    }
    @Override
    public void addCar() {
        cc.cars.add(AddingCar.CreateCar(AddingCar.chooseRandomCar()));
    }@Override
    public void removeCar() {
        for (MotorVehicle car : cars) {

        }
    }
}