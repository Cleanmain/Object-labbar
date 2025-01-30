import org.junit.jupiter.api.Test;
import java.awt.Color;
import java.net.NoRouteToHostException;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void resonableSpeed(){
        Saab95 saab = new Saab95(Color.red, 2, 125, "Saab95");
        assertTrue(saab.getCurrentSpeed() < 200);
    }

    @Test
    void Compass(){
        Saab95 saab = new Saab95(Color.red, 2, 125,"Saab95");

        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        saab.turnLeft();
        assertTrue(saab.getDirection() == Car.Direction.North);
    }

    @Test
    void moveInRightDirection(){
        Saab95 saab = new Saab95(Color.red, 4, 135, "Saab95");
        saab.setCurrentSpeed(150);
        saab.move();
        assertEquals("(0.0, 150.0)", saab.getPosition());
    }

}