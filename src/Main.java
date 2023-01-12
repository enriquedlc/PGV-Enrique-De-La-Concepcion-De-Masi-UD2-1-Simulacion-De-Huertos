import resources.Market;
import threads.Client;
import threads.Farmer;

public class Main {
    public static void main(String[] args) {
        Market market = new Market(5);

        Farmer farmer = new Farmer("Farmer", 3, 2, market);
        Client client = new Client("Client", 3, 7, market);

        farmer.start();
        client.start();
    }
}
