
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DayThree {
    static int[][] field;
    static boolean[][] visited;
    static int length = 0;
    static int width = 0;
    static int numCabbages = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        getWorms();
    }
    private static void getWorms() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {

            st = new StringTokenizer(br.readLine());
            length = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            numCabbages = Integer.parseInt(st.nextToken());
