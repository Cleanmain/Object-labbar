import java.awt.*;

public class Main {
    public static void main(String[] args){

        Saab95 saab = new Saab95(Color.red,2,125,"Saab95");
        Volvo240 volvo = new Volvo240(Color.black,4,100,"Volvo240");


        saab.setTurboOn();
        System.out.println(saab.speedFactor());
        saab.setTurboOff();
        System.out.println(saab.speedFactor());




    }
}
