import java.util.LinkedList;

// Minimum Spanning Tree using Prim's Algorithm
public class MinimumSpanningTreePrims {
    int v;
    LinkedList<Integer>[] adjList;

    public MinimumSpanningTreePrims(int v) {
        this.v = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    public void populateGraph(int[][] edges) {
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
        }
    }

    public void minimumSpanningTreeUsingPrimsAlgorithm() {
        boolean[] visited = new boolean[v];
        int[] distance = new int[v];
        int[] parent = new int[v];
        for (int i = 0; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        distance[0] = 0;
        for (int i = 0; i < v - 1; i++) {
            int minNode = getMinNode(distance, visited);
            visited[minNode] = true;
            for (int j = 0; j < adjList[minNode].size(); j++) {
                int node = adjList[minNode].get(j);
                if (!visited[node] && distance[node] > 1) {
                    distance[node] = 1;
                    parent[node] = minNode;
                }
            }
        }
        printMST(parent);
    }

    public int getMinNode(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minNode = -1;
        for (int i = 0; i < v; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minNode = i;
            }
        }
        return minNode;
    }

    public void printMST(int[] parent) {
        for (int i = 1; i < v; i++) {
            System.out.println(parent[i] + "-" + i);
        }
    }

    public static void main(String[] args) {
        int v = 9;
        int[][] edges = {{0, 1}, {0, 7}, {1, 2}, {1, 7}, {2, 3}, {2, 8}, {2, 5}, {3, 4}, {3, 5}, {4, 5}, {5, 6}, {6, 7}, {6, 8}, {7, 8}};
        MinimumSpanningTreePrims minimumSpanningTreePrims = new MinimumSpanningTreePrims(v);
        minimumSpanningTreePrims.populateGraph(edges);
        minimumSpanningTreePrims.minimumSpanningTreeUsingPrimsAlgorithm();
    }
}
