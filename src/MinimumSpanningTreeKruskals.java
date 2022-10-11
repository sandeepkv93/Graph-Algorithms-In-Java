import java.util.LinkedList;

// Kruskal's Algorithm - Minimum Spanning Tree
public class MinimumSpanningTreeKruskals {
    int v;
    LinkedList<Integer>[] adjList;

    public MinimumSpanningTreeKruskals(int v) {
        this.v = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void populateGraph(int[][] edges) {
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
    }

    public void minimumSpanningTreeUsingKruskal() {
        int[] parent = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adjList[i].size(); j++) {
                int node = adjList[i].get(j);
                int x = find(parent, i);
                int y = find(parent, node);
                if (x != y) {
                    union(parent, x, y);
                    System.out.println("Edge from " + i + " to " + node + " is selected.");
                }
            }
        }
    }

    public int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }

    public void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    public static void main(String[] args) {
        MinimumSpanningTreeKruskals graph = new MinimumSpanningTreeKruskals(6);
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {3, 4}, {4, 5}};
        graph.populateGraph(edges);
        graph.minimumSpanningTreeUsingKruskal(); // 0 1 1 2 2 3 3 4 4 5
    }
}
