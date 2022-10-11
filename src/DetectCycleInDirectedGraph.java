import java.util.LinkedList;

public class DetectCycleInDirectedGraph {
    int v;
    LinkedList<Integer>[] adjList;

    public DetectCycleInDirectedGraph(int v) {
        this.v = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void populateGraph(int[][] edges) {
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
        }
    }

    public boolean detectCycle() {
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (detectCycleUtil(visited, recStack, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean detectCycleUtil(boolean[] visited, boolean[] recStack, int source) {
        if (recStack[source]) {
            return true;
        }
        if (visited[source]) {
            return false;
        }
        visited[source] = true;
        recStack[source] = true;
        for (int neighbor : adjList[source]) {
            if (detectCycleUtil(visited, recStack, neighbor)) {
                return true;
            }
        }
        recStack[source] = false;
        return false;
    }

    public static void main(String[] args) {
        DetectCycleInDirectedGraph graph1 = new DetectCycleInDirectedGraph(4);
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}};
        graph1.populateGraph(edges);
        System.out.println(graph1.detectCycle()); // true

        DetectCycleInDirectedGraph graph2 = new DetectCycleInDirectedGraph(4);
        int[][] edges2 = {{0, 1}, {1, 2}, {3, 2}};
        graph2.populateGraph(edges2);
        System.out.println(graph2.detectCycle()); // false;
    }
}
