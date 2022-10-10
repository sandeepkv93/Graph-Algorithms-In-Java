import java.util.LinkedList;
import java.util.Queue;

class BFSIterativeAdjMatrix {
    int v;
    int[][] adjMatrix;

    public BFSIterativeAdjMatrix(int v) {
        this.v = v;
        adjMatrix = new int[v][v];
    }

    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }

    public void populateGraph(int[][] edges) {
        for (int[] edge : edges) {
            this.addEdge(edge[0], edge[1]);
        }
    }

    public void bfs() {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                bfsUtil(visited, i);
            }
        }
    }

    private void bfsUtil(boolean[] visited, int source) {
        visited[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int i = 0; i < v; ++i) {
                if (adjMatrix[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}

public class BFSIterativeAdjMatrixClient {
    public static void main(String[] args) {
        BFSIterativeAdjMatrix graph = new BFSIterativeAdjMatrix(10);
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {4, 5}, {2, 5}, {2, 6}, {2, 7}, {8, 9}};
        graph.populateGraph(edges);
        graph.bfs(); // 0 1 2 3 4 5 6 7 8 9
    }
}
