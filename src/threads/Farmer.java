package threads;

import resources.Market;

public class Farmer extends Thread{
    private String name;
    private int maxProduction;
    private int maxGrowTimeInSec;
    private Market market;

    public Farmer(String farmerName, int farmerProduction, int maxGrowTime, Market market) {
        this.name = farmerName;
        this.maxProduction = farmerProduction;
        this.maxGrowTimeInSec = maxGrowTime;
        this.market = market;
    }

    private String getRandomVegetable() {
        String[] vegetables = {"lettuce",  "cabbage", "onion", "spinach", "potato", "celery", "asparagus", "radish", "broccoli", "artichoke", "tomato", "cucumber", "eggplant", "carrot", "green bean"};
        return vegetables[(int) (Math.random() * (vegetables.length - 1))];
    }

    private long getRandomGrowTime() {
        return (long) (Math.random() * (this.maxGrowTimeInSec - 1)) + 1;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.maxProduction; i++) {
            try {
                String vegetableToProduce = this.getRandomVegetable();
                long growTime = this.getRandomGrowTime();
                Thread.sleep(growTime * 1000);
                this.market.addVegetable(this.name, vegetableToProduce);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
