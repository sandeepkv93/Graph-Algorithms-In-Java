import java.util.LinkedList;

// Check if a graph is bipartite
public class IsGraphBiPartite {
    int v;
    LinkedList<Integer>[] adjList;

    public IsGraphBiPartite(int v) {
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

    /* The code above does the following:
    1. It creates a color array of size v (where v is the number of vertices in the graph)
    2. It then goes through each vertex of the graph and checks whether the vertex is colored or not. If it is colored,
       it skips the vertex. If it is not colored, it goes to the helper function and checks if the graph is bipartite
       or not. If it is not bipartite, it returns false. If it is bipartite, it continues to the next vertex.
    3. isBipartiteUtil() colors the vertices of the graph with either 1 or 2. For the first vertex, it colors it with 1.
       For the next vertex, it checks if any of its adjacent vertices are colored with 1. If they are, it colors it with
       2. If it is colored with 2, it returns false because the graph is not bipartite. If the vertex is not colored with
       1 or 2, it colors it with 1. It then repeats the process for the next vertex. If it traverses through all the
       vertices and returns true, then the graph is bipartite.
    */
    public boolean isBipartite() {
        int[] color = new int[v];
        for (int i = 0; i < v; i++) {
            if (color[i] == 0) {
                if (!isBipartiteUtil(color, i)) {
                    return false;
                }
            }
        }
        return true;
    }


    /* The code above does the following:
    1. First we assign a color to the node. (We are using 1 and -1 to represent the two colors)
    2. Then we iterate through all its neighbors.
    3. If the neighbor is uncolored, we assign it the opposite color of its parent and recursively call the function
       on that neighbor.
    4. If the neighbor is already colored, we check if the color of the neighbor is the same as the color of the parent.
       If yes, then the graph is not bipartite, else we continue.
    */
    private boolean isBipartiteUtil(int[] color, int source) {
        color[source] = 1;
        for (int neighbor : adjList[source]) {
            if (color[neighbor] == 0) {
                color[neighbor] = -color[source];
                if (!isBipartiteUtil(color, neighbor)) {
                    return false;
                }
            } else if (color[neighbor] == color[source]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsGraphBiPartite graph = new IsGraphBiPartite(5);
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0}};
        graph.populateGraph(edges);
        System.out.println(graph.isBipartite()); // false
    }
}
