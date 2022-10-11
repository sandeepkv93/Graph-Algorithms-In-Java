public class DFSRecursiveAdjMatrix {
    int v;
    int[][] adjMatrix;

    public DFSRecursiveAdjMatrix(int v) {
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

    public void dfs() {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfsUtil(visited, i);
            }
        }
    }

    private void dfsUtil(boolean[] visited, int source) {
        visited[source] = true;
        System.out.print(source + " ");
        for (int i = 0; i < v; ++i) {
            if (adjMatrix[source][i] == 1 && !visited[i]) {
                dfsUtil(visited, i);
            }
        }
    }

    public static void main(String[] args) {
        DFSRecursiveAdjMatrix graph = new DFSRecursiveAdjMatrix(10);
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {4, 5}, {2, 5}, {2, 6}, {2, 7}, {8, 9}};
        graph.populateGraph(edges);
        graph.dfs(); // 0 1 3 4 5 2 6 7 8 9
    }
}
