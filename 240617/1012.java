import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DayThree {
    static int[][] field;
    static boolean[][] visited;
    static int length = 0;
    static int width = 0;
    static int numCabbages = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        getWorms();
    }
    private static void getWorms() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {

            st = new StringTokenizer(br.readLine());
            length = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            numCabbages = Integer.parseInt(st.nextToken());

            field = new int[length][width];
            visited = new boolean[length][width];

            for (int j = 0; j < numCabbages; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            int counter = 0;
            for (int a = 0; a < length; a++) {
                for (int b = 0; b < width; b++) {
                    if (field[a][b] == 1 && !visited[a][b]) {
                        bfs(a, b);
                        counter++;
                    }
                }
            }
            bw.write(String.valueOf(counter));
            if (i <= t - 1) {
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (outOfBound(nextX, nextY, field)) {
                    continue;
                }

                if (!visited[nextX][nextY] && field[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    private static boolean outOfBound(int x, int y, int[][] matrix) {
        return x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length;
    }
}
