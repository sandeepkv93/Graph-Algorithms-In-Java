import java.util.LinkedList;

/*
Topological Sorting using Kahn's BFS Algorithm
 */
public class TopologicalSortingKahnsBFS {
    int v;
    LinkedList<Integer>[] adjList;

    public TopologicalSortingKahnsBFS(int v) {
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
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int neighbor : adjList[i]) {
                inDegree[neighbor]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int source = queue.poll();
            System.out.print(source + " ");
            for (int neighbor : adjList[source]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        TopologicalSortingKahnsBFS graph = new TopologicalSortingKahnsBFS(6);
        int[][] edges = {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
        graph.populateGraph(edges);
        graph.topologicalSort(); // 4 5 2 0 3 1
    }
}
