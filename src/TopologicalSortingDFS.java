import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSortingDFS {
    int v;
    LinkedList<Integer>[] adjList;

    public TopologicalSortingDFS(int v) {
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

    public void topologicalSort() {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topologicalSortUtil(visited, i, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private void topologicalSortUtil(boolean[] visited, int source, Stack<Integer> stack) {
        visited[source] = true;
        for (int neighbor : adjList[source]) {
            if (!visited[neighbor]) {
                topologicalSortUtil(visited, neighbor, stack);
            }
        }
        stack.push(source);
    }

    public static void main(String[] args) {
        TopologicalSortingDFS graph = new TopologicalSortingDFS(6);
        int[][] edges = {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
        graph.populateGraph(edges);
        graph.topologicalSort(); // 5 4 2 3 1 0
    }
}
