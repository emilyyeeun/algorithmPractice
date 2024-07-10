import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) (Math.pow(2, N));
        printOperation(r, c, size);
        System.out.println(cnt);
    }

    private static void printOperation(int x, int y, int size) {
        if (size == 1) {
            return;
         }
        int newSize = size / 2;
        if (r < newSize && c < newSize) {
	        printOperation(newSize, r, c);
	      } else if (r < newSize && c >= newSize) {
		      count += size * size / 4;
		      printOperation(newSize, r, c - newSize);
		    } else if (r >= newSize && c < newSize) {
			    count += (size * size / 4) * 2;
			    printOperation(newSize, r - newSize, c);
			  } else {
				  count += (size * size / 4 ) * 3;
				  printOperation(newSize, r - newSize, c - newSize);

    }
}
