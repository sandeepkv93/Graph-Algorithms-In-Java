// Dijkstra's Algorithm for finding the shortest path from a source vertex to all other vertices in a graph

import java.util.Arrays;

public class DijkstrasAlgorithm {
    int v; // number of vertices
    int[][] graph; // adjacency matrix

    public DijkstrasAlgorithm(int v) {
        this.v = v;
        graph = new int[v][v];
    }

    public void addEdge(int u, int v, int w) {
        graph[u][v] = w;
        graph[v][u] = w;
    }

    public void populateGraph(int[][] edges) {
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1], edge[2]);
        }
    }

    public void shortestPath(int source) {
        boolean[] visited = new boolean[v];
        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        for (int i = 0; i < v; i++) {
            int minVertex = findMinVertex(distance, visited);
            visited[minVertex] = true;
            for (int j = 0; j < v; j++) {
                if (graph[minVertex][j] != 0 && !visited[j]) {
                    int newDistance = distance[minVertex] + graph[minVertex][j];
                    if (newDistance < distance[j]) {
                        distance[j] = newDistance;
                    }
                }
            }
        }
        for (int i = 0; i < v; i++) {
            System.out.println(i + " " + distance[i]);
        }
    }

    private int findMinVertex(int[] distance, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < v; i++) {
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {
        System.out.print("*************");

        DijkstrasAlgorithm graph1 = new DijkstrasAlgorithm(6);
        int[][] edges1 = {{0, 1, 4}, {0, 2, 1}, {1, 2, 2}, {1, 3, 5}, {2, 3, 8}, {2, 4, 10}, {3, 4, 2}, {3, 5, 6}, {4, 5, 3}};
        graph1.populateGraph(edges1);
        graph1.shortestPath(0); // 0 0 1 5 7 10

        System.out.println("*************");

        DijkstrasAlgorithm graph2 = new DijkstrasAlgorithm(5);
        int[][] edges2 = {{0, 1, 4}, {0, 2, 8}, {1, 2, 11}, {1, 3, 8}, {2, 3, 7}, {2, 4, 1}, {3, 4, 2}};
        graph2.populateGraph(edges2);
        graph2.shortestPath(0); // 0 0 4 12 14 15

        System.out.println("*************");

        DijkstrasAlgorithm graph3 = new DijkstrasAlgorithm(5);
        int[][] edges3 = {{0, 1, 4}, {0, 2, 8}, {1, 2, 11}, {1, 3, 8}, {2, 3, 7}, {2, 4, 2}, {3, 4, 6}};
        graph3.populateGraph(edges3);
        graph3.shortestPath(0); // 0 0 4 12 14 16

        System.out.println("*************");
    }
}
