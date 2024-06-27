import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int coinTypes = Integer.parseInt(inputs[0]);
        int target = Integer.parseInt(inputs[1]);

        int[] coins = new int[coinTypes];
        for (int i = 0; i < coinTypes; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int coinNeeded = 0;
        int curr = target;
        for (int i = coinTypes - 1; i >= 0; i--) {
            int currCoins = curr / coins[i];
            coinNeeded += currCoins;
            curr -= currCoins * coins[i];
        }
        System.out.println(coinNeeded);
    }
}
