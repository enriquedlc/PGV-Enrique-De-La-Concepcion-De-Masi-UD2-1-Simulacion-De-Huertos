import resources.Market;
import threads.Client;
import threads.Farmer;

public class Main {
    public static void main(String[] args) {
        Market market = new Market(5);

        Farmer farmer = new Farmer("Francisco", 10, 5, market);
        Client adrian = new Client("Adrian", 5, 5, market);
        Client juan = new Client("Juan", 2, 5, market);

        farmer.start();
        adrian.start();
        juan.start();
    }
}
