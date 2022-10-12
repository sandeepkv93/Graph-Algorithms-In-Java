import java.util.ArrayList;
import java.util.List;

public class AdjListToAdjMatrix {
    /*
        1. Makes an empty matrix of size adjacencyList.length x adjacencyList.length
        2. Iterates through the adjacency list and sets
        matrix[i][adjacencyList[i].get(j)] to 1
        3. Returns the matrix
    */
    public int[][] getAdjacencyMatrixFromAdjacencyList(List<Integer>[] adjacencyList) {
        int[][] matrix = new int[adjacencyList.length][adjacencyList.length];
        for (int i = 0; i < adjacencyList.length; i++) {
            for (int j = 0; j < adjacencyList[i].size(); j++) {
                matrix[i][adjacencyList[i].get(j)] = 1;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        AdjListToAdjMatrix obj = new AdjListToAdjMatrix();
        List<Integer>[] adjList = new List[6];
        adjList[0] = List.of(1, 2, 3);
        adjList[1] = List.of(0, 2);
        adjList[2] = List.of(0, 1, 3);
        adjList[3] = List.of(0, 2, 4);
        adjList[4] = List.of(3, 5);
        adjList[5] = List.of(4);
        int[][] matrix = obj.getAdjacencyMatrixFromAdjacencyList(adjList);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
