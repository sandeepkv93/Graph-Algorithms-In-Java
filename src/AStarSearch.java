import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarSearch {
    int v;
    int[][] adjacencyMatrix;

    public AStarSearch(int v) {
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

    /*
        1. The first step is to find the x and y coordinates of the source and
           destination. 
        2. The x and y coordinates of the source and destination are calculated
            using the formula: x = index / 3 y = index % 3
        3. The x and y coordinates of the source and destination can be used to
            calculate the manhattan distance as:

            manhattan distance = |x1 - x2| + |y1 - y2|
    */
    private int manhattanDistance(int source, int destination) {
        int x1 = source / 3;
        int y1 = source % 3;
        int x2 = destination / 3;
        int y2 = destination % 3;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }


    /*
        1. Create a distance array, where distance[i] is the distance from
           source to i.
        2. Initialize all distances with MAX_VALUE.
        3. Set distance[source] = 0.
        4. Add source to a priority queue, where the priority is the distance
           from source to i + manhattanDistance(i, destination).
        5. While the queue is not empty, poll the first element, u, and for each
           i in the graph, if there is an edge from u to i and distance[u] is
           not MAX_VALUE and distance[u] + edge(u, i) < distance[i], set
           distance[i] = distance[u] + edge(u, i) and add i to the queue.
        6. Print the distance array. 
    */    
    public void shortestPath(int source, int destination) {
        int[] distance = new int[v];
        for (int i = 0; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> distance[o] + manhattanDistance(o, destination)));
        queue.add(source);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i = 0; i < v; i++) {
                if (adjacencyMatrix[u][i] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + adjacencyMatrix[u][i] < distance[i]) {
                    distance[i] = distance[u] + adjacencyMatrix[u][i];
                    queue.add(i);
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

        AStarSearch graph1 = new AStarSearch(6);
        int[][] edges1 = {{0, 1, 4}, {0, 2, 3}, {1, 2, 1}, {1, 3, 2}, {2, 3, 4}, {3, 4, 2}, {4, 5, 6}};
        graph1.populateGraph(edges1);
        graph1.shortestPath(0, 5);

        System.out.println("*************");

        AStarSearch graph2 = new AStarSearch(9);

        int[][] edges3 = {{0, 1, 4}, {0, 7, 8}, {1, 2, 8}, {1, 7, 11}, {2, 3, 7}, {2, 8, 2}, {2, 5, 4}, {3, 4, 9}, {3, 5, 14}, {4, 5, 10}, {5, 6, 2}, {6, 7, 1}, {6, 8, 6}, {7, 8, 7}};

        graph2.populateGraph(edges3);
        graph2.shortestPath(0, 4);

    }
}
