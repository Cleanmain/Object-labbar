import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddingCar {
    public static MotorVehicle CreateCar(String type){
        return switch (type.toLowerCase()){
            case "volvo" -> new Volvo240(Color.black,4,120,"volvo");
            case "saab" -> new Saab95(Color.red,3,100,"Saab");
            case "scania" -> new Scania(Color.blue, 9,110,"Scania");
            default -> throw new IllegalArgumentException("Unknown Vehicle type");
        };
    }

    public static String chooseRandomCar(){
        ArrayList<String> stringcar = new ArrayList<>();
        stringcar.add("volvo");
        stringcar.add("saab");
        stringcar.add("scania");

        Random rand = new Random();
        int pointer = rand.nextInt(2);

        return stringcar.get(pointer);

    }
}
