import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int people;
    static int[] times;
    public static void main(String[] args) throws IOException {
        readInputs();
        System.out.println(minSumTimeNeeded());
    }

    private static void readInputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        people = Integer.parseInt(br.readLine());
        times = new int[people];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < people; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int minSumTimeNeeded() {
        Arrays.sort(times);
        int currSum = 0;
        int[] timeNeeded = new int[people];
        for (int i = 0; i < people; i++) {
            timeNeeded[i] = currSum + times[i];
            currSum += times[i];
        }
        return Arrays.stream(timeNeeded).sum();
    }
}
