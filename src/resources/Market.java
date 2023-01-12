package resources;

import java.util.ArrayList;

public class Market {
    private int capacity;
    private ArrayList<String> vegetablesAvailable = new ArrayList<String>();

    public Market(int marketCapacity) {
        this.capacity = marketCapacity;
    }

    synchronized public void addVegetable(String farmerName, String newVegetable) throws InterruptedException {
        while (this.vegetablesAvailable.size() >= this.capacity) {
            wait();
        }
        this.vegetablesAvailable.add(newVegetable);
        System.out.println(farmerName + " ha producido " + newVegetable);
        notifyAll();
    }

    synchronized public String consumeVegetable(String clientName) throws InterruptedException {
        while (this.vegetablesAvailable.size() == 0) {
            wait();
        }
        String vegetableToConsume = this.vegetablesAvailable.remove(0);
        notifyAll();
        return vegetableToConsume;
    }
}
