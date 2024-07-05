import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] testCases = new int[n];
        for (int i = 0; i < n; i++) {
            testCases[i] = Integer.parseInt(br.readLine());

            printNumofSum(testCases[i]);
        }
    }

    private static void printNumofSum(int num) {
        int[][] dp = new int[10001][4];
        dp[1][1] = 1;

        dp[2][1] = 1;
        dp[2][2] = 1;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= num; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        System.out.println(dp[num][1] + dp[num][2] + dp[num][3]);
    }
}
