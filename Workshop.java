import java.util.ArrayList;
import java.util.List;

enum CarModel {
    Saab95, Volvo240, Scania, Carcarrier
}

class Workshop {
    private final List<CarModel> acceptedModels;
    private final int capacity;
    private final List<CarModel> cars;
    private boolean isFixed;

    public Workshop(List<CarModel> acceptedModels, int capacity) {
        this.acceptedModels = new ArrayList<>(acceptedModels); // Ensure immutability
        this.capacity = capacity;
        this.cars = new ArrayList<>();
    }

    public boolean addCar(CarModel car) {
        if (cars.size() >= capacity) {
            System.out.println("Workshop is full!");
            return false;
        }
        if (!acceptedModels.contains(car)) {
            System.out.println("This workshop does not accept " + car);
            return false;
        }
        cars.add(car);
        System.out.println("Car added: " + car);
        return true;
    }

    public void fixCar(CarModel car){

    }

    public void showCars() {
        System.out.println("Workshop (Capacity: " + capacity + ") Cars: " + cars);
    }
}
