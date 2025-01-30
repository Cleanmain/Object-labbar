import java.awt.*;

public class Main {
    public static void main(String[] args){

        Saab95 saab = new Saab95(Color.red,2,200,"Saab95");
        Volvo240 volvo = new Volvo240(Color.black,4,100,"Volvo240");


        System.out.println("Initial speed: " + saab.getCurrentSpeed());

        saab.gas(0.5);
        System.out.println("After gas(0.5): " + saab.getCurrentSpeed());

        saab.brake(0.3);
        System.out.println("After brake(0.3): " + saab.getCurrentSpeed());

        // Try braking too much
        saab.brake(1);
        System.out.println("After brake(1): " + saab.getCurrentSpeed());

        // Try exceeding max speed
        saab.setCurrentSpeed(198);
        saab.gas(1);
        saab.gas(1);
        saab.gas(1);
        System.out.println("After excessive gas: " + saab.getCurrentSpeed());
        saab.gas(1);
        saab.gas(1);
        saab.gas(1);




    }
}