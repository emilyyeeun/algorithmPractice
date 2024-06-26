import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCards = Integer.parseInt(br.readLine());
        Integer[] cards = new Integer[numCards];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCards; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(maxGold(numCards, cards));
    }

    private static int maxGold(int card, Integer[] cardArr) {
        Arrays.sort(cardArr, Collections.reverseOrder());
        int gold = 0;
        int currLevel = cardArr[0];
        for (int i = 0; i < card - 1; i++) {
            gold += currLevel + cardArr[i + 1];
        }
        return gold;
    }
