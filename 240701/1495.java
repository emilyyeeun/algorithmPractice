import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numSongs = Integer.parseInt(st.nextToken());
        int startVolume = Integer.parseInt(st.nextToken());
        int maxVolume = Integer.parseInt(st.nextToken());

        int[] capacity = new int[numSongs];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numSongs; i++) {
            capacity[i] = Integer.parseInt(st.nextToken());
        }
        printMaxVolume(capacity, startVolume, maxVolume);
    }

    private static void printMaxVolume(int[] capacity, int startVolume, int maxVolume) {
        int[][] dp = new int[capacity.length + 1][maxVolume + 1];
        for (int i = 0; i < capacity.length + 1; i++) {
            for (int j = 0; j < maxVolume + 1; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][startVolume] = 1;
        for (int i = 1; i < capacity.length + 1; i++) {
            for (int j = 0; j < maxVolume + 1; j++) {
                if (dp[i-1][j] == 1) {
                    int add = j + capacity[i-1];
                    int subtract = j - capacity[i-1];
                    if (isWithinRange(add, maxVolume)) {
                        dp[i][add] = 1;
                    }
                    if (isWithinRange(subtract, maxVolume)) {
                        dp[i][subtract] = 1;
                    }
                }
            }
        }
        int max = -1;
        for (int i = 0; i <= maxVolume; i++) {
            if (dp[capacity.length][i] == 1) {
                if (max < i) {
                    max = i;
                }
            }
        }
        System.out.println(max);
    }

    private static boolean isWithinRange(int volume, int max) {
        return (volume >= 0 && volume <= max);
    }
}
