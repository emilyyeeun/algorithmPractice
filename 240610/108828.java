import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String nextToken = st.nextToken(" ");
            switch (nextToken) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        bw.write("-1");
                    } else {
                        bw.write(String.valueOf(stack.pop()));
                    }
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        bw.write(String.valueOf(-1));
                    } else {
                        bw.write(String.valueOf(stack.peek()));
                    }
                    break;
                case "size":
                    bw.write(String.valueOf(stack.size()));
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        bw.write("1");
                    } else {
                        bw.write("0");
                    }
                    break;
            }
            if (i != n - 1 && !nextToken.equals("push")) {
                bw.newLine();
            }
        }
        bw.close();
    }

}
