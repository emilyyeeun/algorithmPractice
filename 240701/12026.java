import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // read inputs
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] arr = new char[n];
        String letters = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = letters.charAt(i);
        }

        // dp 선언
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 초기값 선언
        dp[0] = 0;
        char order = arr[0]; // 'B'

        // 점프 하는 시작 위치
        int before = 0;
        int i = 0;

        while (i < n - 1) {
            int curr = i + 1;
            while (curr < n) {
                if (next(order) == arr[curr]) {
                    if (dp[curr] == -1) {
                        dp[curr] = dp[before] + (curr - before) * (curr - before);
                    } else {
                        dp[curr] = Math.min(dp[curr], dp[before] + (curr - before) * (curr - before));
                    }
                } else {
                    // 점프할 수 없는 보도블록
                    dp[curr] = -1;
                }
                curr++;
            }

            int j = i + 1;
            while(j < n - 1) {
                if (arr[j] == next(order)) {
                    break;
                } else {
                    j++;
                }
            }
            i = j;
            before = j;
            order = arr[j];

            if (j == n - 2 && arr[j + 1] == next(order)) {
                if (dp[j + 1] == -1) {
                    dp[j + 1] = dp[before] + (j + 1 - before) * (j + 1 - before);
                } else {
                    dp[j + 1] = Math.min(dp[j + 1], dp[before] + (j + 1 - before) * (j + 1 - before));
                }
            }

        }
        
        // 링크의 집은 n번째 있음
        System.out.println(dp[n-1]);
    }

    private static char next(char order) {
        if (order == 'B') {
            return 'O';
        } else if (order == 'O') {
            return 'J';
        } else {
            return 'B';
        }
    }

}
