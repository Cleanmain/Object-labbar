import java.util.ArrayList;

class Workshop <T extends MotorVehicle>{
    private final ArrayList<T> inventory;
    private final int capacity;
    private boolean isFixed;

    public Workshop(int capacity){
        this.capacity = capacity;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<T>getInventory(){
        return inventory;
    }

    public boolean addVehicle(T MotorVehicle){
        if (inventory.size() < capacity){
            inventory.add(MotorVehicle);
            MotorVehicle.stopEngine();
            MotorVehicle.setLoaded();

            return true;
        }
        return false;
    }

    public boolean removeVehicle(T MotorVehicle){
        if (inventory.contains(MotorVehicle)) {
            inventory.remove(MotorVehicle);
            return true;
        }
        System.out.println("Vehicle is not in inventory");
        return false;
    }

    public int getCapacity(){
        return capacity;
    }

}