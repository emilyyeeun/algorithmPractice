import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
    boolean[] visited;
    int connected;

    Graph(int size) {
        nodes = new Node[size + 1];
        visited = new boolean[size + 1];
        for (int i = 1; i <= size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdges(int u, int v) {
        if (!nodes[u].adjacent.contains(nodes[v])) {
            nodes[u].adjacent.add(nodes[v]);
        }

        if (!nodes[v].adjacent.contains(nodes[u])) {
            nodes[v].adjacent.add(nodes[u]);
        }
    }

    void dfs(int start) {
        Node root = nodes[start];
        visited[start] = true;

        if (!root.adjacent.isEmpty()) {
            for (Node n : root.adjacent) {
                if (!visited[n.data]) {
                    dfs(n.data);
                }
            }
        }
    }

    int countSolo() {
        // 간선이 없는 정점 카운트
        int counter = 0;
        for (Node n: nodes) {
            if (n != null && n.adjacent.isEmpty()) {
                counter++;
            }
        }
        return counter;
    }
}


public class DayFour {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph.addEdges(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int counter = 0;

        for (int i = 1; i < n + 1; i++) {
            if (!graph.visited[i] && !graph.nodes[i].adjacent.isEmpty()) {
                graph.dfs(i);
                counter++;
            }
        }

        bw.write(String.valueOf(counter + graph.countSolo()));
        bw.flush();
        bw.close();
    }
}
