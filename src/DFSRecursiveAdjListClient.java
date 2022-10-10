import java.util.LinkedList;
import java.util.List;

class DFSRecursiveAdjList {
    int v;
    LinkedList<Integer>[] adjList;

    public DFSRecursiveAdjList(int v) {
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

    public void dfs() {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; ++i) {
            if (!visited[i]) {
                dfsUtil(visited, i);
            }
        }
    }

    private void dfsUtil(boolean[] visited, int source) {
        visited[source] = true;
        System.out.print(source + " ");
        for (int neighbor : adjList[source]) {
            if (!visited[neighbor]) {
                dfsUtil(visited, neighbor);
            }
        }
    }
}

public class DFSRecursiveAdjListClient {
    public static void main(String[] args) {
        DFSRecursiveAdjList graph = new DFSRecursiveAdjList(10);
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {4, 5}, {2, 5}, {2, 6}, {2, 7}, {8, 9}};
        graph.populateGraph(edges);
        graph.dfs(); // 0 1 3 4 5 2 6 7 8 9
    }
}
