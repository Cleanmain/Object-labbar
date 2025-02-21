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

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(Color.red,4,125,"Volvo240"));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();
                if (car.x > 700 || car.y > 490 || car.x < 0 || car.y < 0) { //ifall går utanför rutan
                    car.turnLeft();
                    car.turnLeft();
                    car.move();
                }
                int x = (int) Math.round(car.x);
                int y = (int) Math.round(car.y);
                frame.drawPanel.moveit(car, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }void startEngine(){
        for (Vehicle car : cars){
            car.startEngine();
        }
    }void stopEngine(){
        for (Vehicle car : cars){
            car.stopEngine();
        }
    }
    void stopCars(){
        for (Vehicle car : cars){
            car.setCurrentSpeed(0);
        }
    }void turnLeft(){
        for (Vehicle car : cars){
            car.turnLeft();
        }
    }void turnRight(){
        for (Vehicle car : cars){
            car.turnRight();
        }
    }void turboOn() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }void turboOff() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95)car).setTurboOff();
            }
        }
    }void increaseAngle(){
        for (Vehicle car : cars){
            if (car instanceof  Scania){
                ((Scania)car).increaseFlakAngle();
            }
        }
    }void decreaseAngle(){
        for (Vehicle car : cars){
            if (car instanceof Scania){
                ((Scania)car).decreaseFlakAngle();
            }
        }
    }
}