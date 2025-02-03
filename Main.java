import java.awt.*;

public class Main {
    public static void main(String[] args){

        Saab95 saab = new Saab95(Color.red,2,200,"Saab95");
        Volvo240 volvo = new Volvo240(Color.black,4,100,"Volvo240");


        System.out.println("Initial speed: " + saab.getCurrentSpeed());

        saab.gas(0.5);
        System.out.println("After gas: " + saab.getCurrentSpeed());

        saab.brake(0.3);
        System.out.println("After brake: " + saab.getCurrentSpeed());

        saab.brake(1);
        System.out.println("After brake: " + saab.getCurrentSpeed());

        saab.setCurrentSpeed(198);
        saab.gas(1);
        saab.gas(1);
        saab.gas(1);
        System.out.println("After excessive gas: " + saab.getCurrentSpeed());
        saab.gas(1.6);






    }
}