import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int k = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("<");
        printJosephus(n, k, bw);
        bw.write(">");
        bw.flush();
        bw.close();
    }

    private static void printJosephus(int n, int k, BufferedWriter bw) throws IOException{
        CircularQueue queue = new CircularQueue(n);
        for (int i = 1; i < n + 1; i++) {
            queue.enqueue(i);
        }

        while(!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                int next = queue.dequeue();
                queue.enqueue(next);
            }
            int curr = queue.dequeue();
            if (queue.isEmpty()) {
                bw.write(String.valueOf(curr));
            } else {
                bw.write(String.valueOf(curr) + ", ");
            }
        }
    }
}
    
class CircularQueue {
    int front = 0;
    int rear = 0;
    int[] queue;
    CircularQueue(int size) {
        queue = new int[size + 1];
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.queue.length == this.front;
    }

    public void enqueue(int num) {
        if (this.isFull()) {
            return;
        } else {
            this.rear = (this.rear + 1) % this.queue.length;
            this.queue[this.rear] = num;
        }
    }

    public int dequeue() {
        if (this.isEmpty()) {
            return -1;
        } else {
            this.front = (this.front + 1) % this.queue.length;
            return this.queue[this.front];
        }
    }

}
