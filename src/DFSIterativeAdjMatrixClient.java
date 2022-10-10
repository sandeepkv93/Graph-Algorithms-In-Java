import java.util.Stack;

class DFSIterativeAdjMatrix {
    int v;
    int[][] adjMatrix;

    public DFSIterativeAdjMatrix(int v) {
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
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while(!stack.isEmpty()) {
            int node = stack.pop();
            System.out.print(node + " ");
            for (int i = v - 1; i >= 0; --i) {
                if (adjMatrix[node][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }
}

public class DFSIterativeAdjMatrixClient {
    public static void main(String[] args) {
        DFSIterativeAdjMatrix graph = new DFSIterativeAdjMatrix(10);
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {4, 5}, {2, 5}, {2, 6}, {2, 7}, {8, 9}};
        graph.populateGraph(edges);
        graph.dfs(); // 0 1 3 4 5 2 6 7 8 9
    }
}
