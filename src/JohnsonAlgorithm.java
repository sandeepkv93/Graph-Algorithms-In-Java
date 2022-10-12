// Johnson's Algorithm - Shortest Path from every vertex to every other vertex in a graph

import java.util.Arrays;

public class JohnsonAlgorithm {
    int v;
    int[][] adjacencyMatrix;

    public JohnsonAlgorithm(int v) {
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
    
    /* The code above does the following, explained in English:
        1. For each vertex, we start with an array distance[] of size v (number of
        vertices) and fill it with Integer.MAX_VALUE.
        2. We set the first element of distance[] to 0 (distance from 0 to 0 is 0).
        3. We have a nested for loop. The outer for loop runs (v-1) times. The inner for
        loop runs v times.
        4. For each vertex j, we find the shortest path from 0 to j by considering all
        the edges.
        5. For each edge, we check if the distance from 0 to the source of the edge is
        not equal to Integer.MAX_VALUE, and if the distance from 0 to the source of
        the edge + weight of the edge is less than the distance from 0 to the
        destination of the edge.
        6. If it is, we update the distance array.
        7. We print the distance array. 
    */
    public void shortestPathUsingJohnsonsAlgorithm() {
        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
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

        JohnsonAlgorithm graph1 = new JohnsonAlgorithm(6);
        int[][] edges1 = {{0, 1, 4}, {0, 2, 3}, {1, 2, 1}, {1, 3, 2}, {2, 3, 4}, {3, 4, 2}, {4, 5, 6}};
        graph1.populateGraph(edges1);
        graph1.shortestPathUsingJohnsonsAlgorithm();

        System.out.println("*************");

        JohnsonAlgorithm graph2 = new JohnsonAlgorithm(5);
        int[][] edges2 = {{0, 1, 3}, {0, 2, 8}, {0, 4, -4}, {1, 3, 1}, {1, 4, 7}, {2, 1, 4}, {3, 0, 2}, {3, 2, -5}, {4, 3, 6}};
        graph2.populateGraph(edges2);
        graph2.shortestPathUsingJohnsonsAlgorithm();
    }
}
