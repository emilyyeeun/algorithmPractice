import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] numbers;
    static int[] output;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        visited = new boolean[n];
        output = new int[n];
        set = new LinkedHashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        permutation(0, n, m);
        List<String> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        for (String str: sorted) {
            System.out.println(str);
        }
    }

    private static void permutation(int depth, int n, int r) {
        if (depth == r) {
            set.add(printOutput(output, r));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = numbers[i];
                permutation(depth + 1, n, r);
                visited[i] = false;
            }
        }

    }
    private static String printOutput(int[] arr, int r) {
        StringBuilder result = new StringBuilder();
        for (int j : arr) {
            if (j != 0) {
                result.append(j).append(' ');
            }
        }
        return result.toString();
    }
}
