import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        int movedNum = Integer.parseInt(br.readLine());
        count = 0;
        printOperation(movedNum, 1, 2, 3);
        System.out.println(count);
        System.out.print(sb);
    }

    private static void printOperation(int num, int start, int mid, int end) {
        if (num == 1) {
            count++;
            sb.append(start + " " + end).append("\n");
            return;
        }
        printOperation(num - 1, start, end, mid);
        sb.append(start + " " + end).append("\n");
        count++;
        printOperation(num - 1, mid, start, end);
    }
}
