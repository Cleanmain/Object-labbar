import java.util.ArrayList;

class Workshop <T extends Vehicle>{
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

    public boolean addVehicle(T Vehicle){
        if (inventory.size() < capacity){
            inventory.add(Vehicle);
            return true;
        }
        return false;
    }

    public boolean removeVehicle(T Vehicle){
        if (inventory.contains(Vehicle)) {
            inventory.remove(Vehicle);
            return true;
        }
        System.out.println("Vehicle is not in inventory");
        return false;
    }

    public int getCapacity(){
        return capacity;
    }

}