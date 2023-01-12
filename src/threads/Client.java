package threads;

import resources.Market;

public class Client extends Thread {

    private String name;
    private Market market;
    private int maxToConsume;
    private final long CONSUMING_TIME;

    public Client(String clientName, int maxToConsume, int consumingTimeInSeconds, Market market) {
        this.name = clientName;
        this.maxToConsume = maxToConsume;
        this.market = market;
        this.CONSUMING_TIME = consumingTimeInSeconds * 1000;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.maxToConsume; i++) {
            try {
                String vegetableToConsume = this.market.consumeVegetable(this.name);
                Thread.sleep(this.CONSUMING_TIME);
                System.out.println(this.name + " ha consumido " + vegetableToConsume);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
