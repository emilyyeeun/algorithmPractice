import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
         printSolution();
//        int[] testArray = {555, 324, 178};
//        int k = 3;
//        int n = 100;
//        System.out.println(maxCableLength(k, n, testArray, 400));
    }

    public static void printSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputs = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(inputs);
        int cablesOwned = Integer.parseInt(stringTokenizer.nextToken());
        int cablesNeeded = Integer.parseInt(stringTokenizer.nextToken());

        int[] cableArr = new int[cablesOwned];
        long maxCableLength = -1;
        for (int i = 0; i < cablesOwned; i++) {
            cableArr[i] = Integer.parseInt(br.readLine());
            maxCableLength = Math.max(maxCableLength, cableArr[i]);
        }
        bw.write(String.valueOf(maxCableLength(cablesOwned, cablesNeeded, cableArr, maxCableLength)));

        bw.flush();
        bw.close();
    }

    private static long maxCableLength(int cablesOwned, int cablesNeeded, int[] arr, long max) {
        long low = 1;
        long high = max;

        while (low <= high) {
            long mid = (low + high) / 2;
            long numCables = 0;
            for (int cable: arr) {
                numCables += cable / mid;
            }
            if (numCables < cablesNeeded) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
