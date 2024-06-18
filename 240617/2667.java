import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class DayTwo {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] visited;
    static int[][] arr;
    static int currApt = 0;

    public static void main(String[] args) throws IOException {
        printSolution();
    }
    private static void printSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        int counter = 0;
        LinkedList<Integer> answer = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && visited[i][j] == 0) {
                    int curr = bfs(i, j);
                    counter++;
                    currApt = 0;
                    answer.add(curr);
                }
            }
        }
        System.out.println(counter);
        Collections.sort(answer);
        for (int a : answer) {
            System.out.println(a);
        }

    }

    private static int bfs(int i, int j) {
        currApt++;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = 1;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            for (int k = 0; k < 4; k++) {
                int nextX = currX + dx[k];
                int nextY = currY + dy[k];
                if (outOfBound(nextX, nextY, arr)) {
                    continue;
                }
                if (visited[nextX][nextY] == 0 && arr[nextX][nextY] == 1) {
                    currApt++;
                    visited[nextX][nextY] = 1;
                    queue.add(new int[] {nextX, nextY});
                }
            }

        }
        return currApt;
    }

    private static boolean outOfBound(int x, int y, int[][] matrix) {
        return x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length;
    }
    
}
