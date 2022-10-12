public class BellmanFordAlgorithm {
    int v;
    int[][] adjacencyMatrix;

    public BellmanFordAlgorithm(int v) {
        this.v = v;
        adjacencyMatrix = new int[v][v];
    }

    public void addEdge(int u, int v, int w) {
        adjacencyMatrix[u][v] = w;
        adjacencyMatrix[v][u] = w;
    }

    public void populateGraph(int[][] edges) {
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1], edge[2]);
        }
    }

    public void shortestPath(int source) {
        int[] distance = new int[v];
        for (int i = 0; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        for (int i = 0; i < v - 1; i++) {
            for (int j = 0; j < v; j++) {
                for (int k = 0; k < v; k++) {
                    if (adjacencyMatrix[j][k] != 0 && distance[j] != Integer.MAX_VALUE && distance[j] + adjacencyMatrix[j][k] < distance[k]) {
                        distance[k] = distance[j] + adjacencyMatrix[j][k];
                    }
                }
            }
        }
        for (int i = 0; i < v; i++) {
            System.out.print(distance[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("*************");

        BellmanFordAlgorithm graph1 = new BellmanFordAlgorithm(6);
        int[][] edges1 = {{0, 1, 4}, {0, 2, 3}, {1, 2, 1}, {1, 3, 2}, {2, 3, 4}, {3, 4, 2}, {4, 5, 6}};
        graph1.populateGraph(edges1);
        graph1.shortestPath(0);

        System.out.println("*************");

        BellmanFordAlgorithm graph2 = new BellmanFordAlgorithm(5);
        int[][] edges2 = {{0, 1, 3}, {0, 2, 8}, {0, 4, -4}, {1, 3, 1}, {1, 4, 7}, {2, 1, 4}, {3, 0, 2}, {3, 2, -5}, {4, 3, 6}};
        graph2.populateGraph(edges2);
        graph2.shortestPath(0);
    }
}
