// 틀린 답
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] matrices = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrices[i][1] = Integer.parseInt(st.nextToken());
            matrices[i][2] = Integer.parseInt(st.nextToken());
        }
        if (n == 1) {
            System.out.println("0");
            return;
        }

        if (n == 2) {
            int sum = matrices[0][1] * matrices[1][1] * matrices[1][2];
            System.out.println(sum);
            return;
        }

        printNumOperation(matrices);
    }

    private static void printNumOperation(int[][] matrices) {
        int[][] dp = new int[matrices.length][3];

        dp[2][1] = matrices[0][1] * matrices[0][2] * matrices[1][2]
        + matrices[0][1] * matrices[1][1] * matrices[1][2]; // ab
        dp[2][2] = matrices[1][1] * matrices[1][2] * matrices[1][2]
        + matrices[0][0] * matrices[1][1] * matrices[1][2]; // bc

        if (matrices.length == 3) {
            System.out.println(Math.min(dp[2][1], dp[2][2]));
            return;
        }
        
        for (int i = 3; i < matrices.length; i++) {
            dp[i][1] = dp[i-1][1] + matrices[0][1] * matrices[i][1] * matrices[i][2]; // (ab)cd;
            dp[i][2] = dp[i-1][2] + matrices[0][1] * matrices[i][1] * matrices[i][2];// a(bc)d;
        }

        int min = 0;
        for (int i = 0; i < dp.length; i++) {
            min += Math.min(dp[i][1], dp[i][2]);
        }
        System.out.println(min);
    }
}
