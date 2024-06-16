
import java.io.*;
import java.util.*;

class Node {
    int data;
    List<Node> adjacent;

    Node(int data) {
        this.data = data;
        this.adjacent = new ArrayList<>();
    }
}

class Graph {
    Node[] nodes;

    Graph(int size) {
        nodes = new Node[size + 1];
        for (int i = 1; i <= size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void sortDesc() {
        for (int i = 1; i <= nodes.length - 1; i++) {
            List<Node> nodeList = nodes[i].adjacent;
            nodeList.sort((a, b) -> Integer.compare(b.data, a.data));
        }
    }

    void sortAsc() {
        for (int i = 1; i <= nodes.length - 1; i++) {
            List<Node> nodeList = nodes[i].adjacent;
            nodeList.sort(Comparator.comparingInt(a -> a.data));
        }
    }

    void print() {
        for (int i = 1; i <= nodes.length - 1; i++) {
            List<Node> nodeList = nodes[i].adjacent;
            for (int j = 0; j < nodeList.size(); j++) {
                System.out.print(nodes[i].adjacent.get(j).data);
            }
            System.out.println();
        }
    }

    void dfs(int n, int src, BufferedWriter bw) throws IOException {
        boolean[] visited = new boolean[n + 1];
        Node root = nodes[src];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        visited[src] = true;
        bw.write(root.data + " ");
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (!visited[node.data]) {
                visited[node.data] = true;
                bw.write(node.data + " ");
            }

            for (Node no : node.adjacent) {
                if (!visited[no.data]) {
                    stack.push(no);
                }
            }
        }
    }

    void bfs(int n, int src, BufferedWriter bw) throws IOException {
        boolean[] visited = new boolean[n + 1];
        Node root = nodes[src];
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        visited[src] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            bw.write(node.data + " ");
            for (Node no : node.adjacent) {
                if (!visited[no.data]) {
                    queue.add(no);
                    visited[no.data] = true;
                }
            }
        }
    }
}

public class DayOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken()); // Number of nodes
        int m = Integer.parseInt(stringTokenizer.nextToken()); // Number of edges
        int source = Integer.parseInt(stringTokenizer.nextToken()); // Source node for traversal

        Graph graph = new Graph(n);

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(stringTokenizer.nextToken());
            int next = Integer.parseInt(stringTokenizer.nextToken());
            graph.addEdge(first, next);
        }

        graph.sortDesc();
        graph.dfs(n, source, bw);
        bw.newLine();
        graph.sortAsc();
        graph.bfs(n, source, bw);

        br.close();
        bw.flush();
        bw.close();
    }
}


