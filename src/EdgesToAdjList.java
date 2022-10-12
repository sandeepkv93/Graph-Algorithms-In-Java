import java.util.ArrayList;
import java.util.List;

public class EdgesToAdjList {
    /*
        1. Create an array of List objects. The list at index i contains the nodes that
        are adjacent to node i.
        2. For each edge, add the adjacent node to both the source and destination
        nodes. 
    */
    public List<Integer>[] getAdjacencyListFromEdges(int[][] edges, int n) {
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        return adjList;
    }

    public static void main(String[] args) {
        EdgesToAdjList obj = new EdgesToAdjList();
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {2, 3}, {3, 4}, {4, 5}};
        List<Integer>[] adjList = obj.getAdjacencyListFromEdges(edges, 6);
        for (int i = 0; i < adjList.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < adjList[i].size(); j++) {
                System.out.print(adjList[i].get(j) + " ");
            }
            System.out.println();
        }
    }
}
