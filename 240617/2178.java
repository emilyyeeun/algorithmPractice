import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] maze;
    static int[][] distance;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for (int j = 0; j < m; j++) {
                maze[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }
        bfs();
        if (distance[n-1][m-1] != 0) {
            System.out.println(distance[n-1][m-1]);
        }
    }

    private static void bfs() {
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        distance[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (isOutOfBound(nextX, nextY)) {
                    continue;
                }
                if(!visited[nextX][nextY] && maze[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY});
                    distance[nextX][nextY] = distance[currX][currY] + 1;
                }
            }
        }
    }

    private static boolean isOutOfBound(int x, int y) {
        return (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length);
    }
}
