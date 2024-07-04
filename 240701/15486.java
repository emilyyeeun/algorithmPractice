import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] consulting = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            consulting[i][0] = Integer.parseInt(st.nextToken());
            consulting[i][1] = Integer.parseInt(st.nextToken());
        }

        getMaxProfit(n, consulting);
    }

    private static void getMaxProfit(int quit, int[][] consulting) {
        int max = 0;
        for (int i = 1; i <= quit; i++) {
            int endingTime = i + consulting[i][0];
            if (endingTime > max) {
                max = endingTime;
            }
        }

        int[] dp = new int[max + 1];

        for (int j = 1; j <= quit; j++) {
            if (dp[j] < dp[j-1]) {
                dp[j] = dp[j-1];
            }
            int newTime = j - 1 + (consulting[j][0]);
            dp[newTime] = Math.max(dp[j-1] + consulting[j][1],
                    dp[newTime]);
        }

        int maxProfit = 0;
        for (int i = 1; i <= quit; i++) {
            if (maxProfit < dp[i]) {
                maxProfit = dp[i];
            }
        }
        System.out.println(maxProfit);
    }
}
