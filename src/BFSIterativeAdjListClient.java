import java.util.LinkedList;
import java.util.Queue;

class BFSIterativeAdjList {
    int v;
    LinkedList<Integer>[] adjList;

    public BFSIterativeAdjList(int v) {
        this.v = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
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
            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}

public class BFSIterativeAdjListClient {
    public static void main(String[] args) {
        BFSIterativeAdjList graph = new BFSIterativeAdjList(10);
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {4, 5}, {2, 5}, {2, 6}, {2, 7}, {8, 9}};
        graph.populateGraph(edges);
        graph.bfs(); // 0 1 2 3 4 5 6 7 8 9
    }
}
