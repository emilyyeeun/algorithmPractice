import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DayFive {
    public static void main(String[] args) throws IOException {
        printSolution();
    }

    public static void printSolution() throws IOException {
        // input 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] treesToCut = new int[n];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            treesToCut[i] = Integer.parseInt(tokenizer.nextToken());
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(returnTrees(n, m, treesToCut)));
        bw.flush();
        bw.close();
    }

    public static int returnTrees(int n, int m, int[] trees) {
        Arrays.sort(trees);

        int low = 0;
        int high = trees[n- 1];

        while (low <= high) {
            int mid = (low + high) / 2;
            long remainder = 0;

            for (int tree: trees) {
                remainder += (tree >= mid) ? tree - mid : 0;
            }

            if (remainder < m) {
                high = mid - 1;
            } else if (remainder > m){
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return high;
    }
}
