import java.util.List;

public class VehicleTracker {
    private List<MotorVehicle> vehicles;



    public VehicleTracker(List<MotorVehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void updatePositions() {
        for (MotorVehicle car : vehicles) {
            car.move();
            keepInWindow(car);
            volvoInShop(car);
        }
    }

    private void keepInWindow(MotorVehicle car) {
        if (car.x > 700 || car.y > 490 || car.x < 0 || car.y < 0) {
            car.turnLeft();
            car.turnLeft();
            car.move();
        }
    }

    private void volvoInShop(MotorVehicle car) {
        if (car instanceof Volvo240 && car.x > 250 && car.x < 350 && car.y > 250 && car.y < 350) {
            car.setLoaded();
        }
    }


    // ✅ Getter for DrawPanel
    public List<MotorVehicle> getVehicles() {
        return vehicles;
    }
}
