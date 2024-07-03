import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rundp(board);
    }

    private static void rundp(int[][] board) {
        long[][] dp = new long[board.length][board[0].length];


        dp[0][0] = 0;
        if (!isOutOfBound(board[0][0], board, 0)) {
            dp[0][board[0][0]] = 1;
        }
        if (!isOutOfBound(board[0][0], board, 0)) {
            dp[board[0][0]][0] = 1;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (board[i][j] == 0) {
                    continue;
                }

                int currMove = board[i][j];
                if (!isOutOfBound(currMove, board, i)) {
                    dp[i+currMove][j] += dp[i][j];
                }
                if (!isOutOfBound(currMove, board, j)) {
                    dp[i][j+currMove] += dp[i][j];
                }

            }
        }
        System.out.println(dp[board.length-1][board.length-1]);
    }
    private static boolean isOutOfBound(int move, int[][] board, int index) {
        int next = index + move;
        if (next < 0 || next >= board.length) {
            return true;
        }
        return false;
    }
}
