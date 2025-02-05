import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        Saab95 saab = new Saab95(Color.red,2,200,"Saab95");
        Saab95 testsaab = new Saab95(Color.red,4,125,"Saab95");
        Volvo240 volvo = new Volvo240(Color.black,4,100,"Volvo240");
        CarCarrier carcarry = new CarCarrier(Color.black,2,130,"Beast");
        Workshop volvoWork = new Workshop(Arrays.asList(CarModel.Volvo240),3);



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

        System.out.println("Tester Under");


        carcarry.setRampDown();
        carcarry.loadVehicle(saab);
        carcarry.loadVehicle(volvo);
        carcarry.setCurrentSpeed(120);
        carcarry.move();
        carcarry.move();
        carcarry.turnRight();
        carcarry.incrementSpeed(1);
        carcarry.move();
        System.out.println(saab.getPositionString());
        System.out.println(volvo.getPositionString());
        System.out.println(carcarry.getPositionString());
        System.out.println(testsaab.getPositionString());
        carcarry.unloadVehicle();

        volvoWork.addCar(CarModel.Volvo240);
        volvoWork.addCar(CarModel.Saab95);











    }
}