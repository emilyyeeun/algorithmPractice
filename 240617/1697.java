import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();

        visited = new boolean[100001];
        time = new int[100001];
        bfs(n, k);
        System.out.println(time[k]);
    }

    private static void bfs(int start, int end) {
        Queue<Integer> stack = new LinkedList<>();
        visited[start] = true;
        time[start] = 0;
        stack.add(start);

        while(!stack.isEmpty()) {
            int curr = stack.poll();
            if (curr == end) {
                break;
            }
            for (int i = 0; i < 3; i++) {
                int next = curr;
                if (i == 0) {
                    next = curr - 1;
                } else if (i == 1) {
                    next = curr + 1;
                } else {
                    next = curr * 2;
                }
                if (next < 0 || next > 100000) {
                    continue;
                }
                if (!visited[next]) {
                    visited[next] = true;
                    time[next] = time[curr] + 1;
                    stack.add(next);
                }
            }
        }
    }
}
