import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] papers;
    static int negativeOne;
    static int zero;
    static int one;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        papers = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        coloredPaper(0, 0, n);
        System.out.println(negativeOne);
        System.out.println(zero);
        System.out.println(one);
    }
    private static void coloredPaper(int r, int c, int size) {
    // 종이를 9분할로 계속 잘라서 종이의 적힌 숫자가 모두 같은 숫자일 때, 숫자를 카운팅해준다. 
        if (checkSamePaper(r, c, size)) {
            int num = papers[r][c];
            if (num == -1) {
                negativeOne++;
            } else if (num == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }
// 그게 아닐 경우 이중 for 문으로 종이를 9분할해 새로운 r, c, size 를 정해서
// 재귀를 돌리면 된다. 이때 사이즈는 /3을 한 값이다.  
        int newSize = size / 3;
        for (int i = r; i < r + size; i += newSize){
            for (int j = c; j < c + size; j += newSize) {
                coloredPaper(i, j, newSize);
            }
        }

    }

    private static boolean checkSamePaper(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (papers[r][c] != papers[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
