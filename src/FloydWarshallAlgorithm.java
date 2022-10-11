// Shortest Path from every vertex to every other vertex in a graph using Floyd Warshall Algorithm

public class FloydWarshallAlgorithm {
    int v;
    int[][] adjacencyMatrix;

    public FloydWarshallAlgorithm(int v) {
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

    public void shortestPath() {
        int[][] distance = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                distance[i][j] = adjacencyMatrix[i][j];
            }
        }
        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE && distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("*************");

        FloydWarshallAlgorithm graph1 = new FloydWarshallAlgorithm(6);
        int[][] edges1 = {{0, 1, 4}, {0, 2, 3}, {1, 2, 1}, {1, 3, 2}, {2, 3, 4}, {3, 4, 2}, {4, 5, 6}};
        graph1.populateGraph(edges1);
        graph1.shortestPath();

        System.out.println("*************");

        FloydWarshallAlgorithm graph2 = new FloydWarshallAlgorithm(5);
        int[][] edges2 = {{0, 1, 3}, {0, 2, 8}, {0, 4, -4}, {1, 3, 1}, {1, 4, 7}, {2, 1, 4}, {3, 0, 2}, {3, 2, -5}, {4, 3, 6}};
        graph2.populateGraph(edges2);
        graph2.shortestPath();

        System.out.println("*************");
    }
}
