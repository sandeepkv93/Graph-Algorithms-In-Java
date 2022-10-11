import java.util.ArrayList;
import java.util.List;

// Detect Cycle in an Undirected Graph
public class DetectCycleInUndirectedGraph {
    int v;
    List<Integer>[] adjList;

    public DetectCycleInUndirectedGraph(int v) {
        this.v = v;
        adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void populateGraph(int[][] edges) {
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
    }

    public boolean detectCycle() {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycleUtil(boolean[] visited, int source, int parent) {
        visited[source] = true;
        for (int neighbor : adjList[source]) {
            if (!visited[neighbor]) {
                if (detectCycleUtil(visited, neighbor, source)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleInUndirectedGraph graph1 = new DetectCycleInUndirectedGraph(5);
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0}};
        graph1.populateGraph(edges);
        System.out.println(graph1.detectCycle()); // true

        DetectCycleInUndirectedGraph graph2 = new DetectCycleInUndirectedGraph(3);
        int[][] edges2 = {{0, 1}, {1, 2}};
        graph2.populateGraph(edges2);
        System.out.println(graph2.detectCycle()); // false

        DetectCycleInUndirectedGraph graph3 = new DetectCycleInUndirectedGraph(5);
        int[][] edges3 = {{1, 0}, {0, 2}, {2, 1},  {0, 3}, {3, 4}};
        graph3.populateGraph(edges3);
        System.out.println(graph3.detectCycle()); // true
    }
}
