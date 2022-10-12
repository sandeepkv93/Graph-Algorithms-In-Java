import java.util.ArrayList;
import java.util.List;

public class AdjListToAdjMatrix {
    public List<Integer>[] getAdjacenceyListFromAdjacencyMatrix(int[][] matrix) {
        List<Integer>[] adjList = new ArrayList[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            adjList[i] = new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    adjList[i].add(j);
                }
            }
        }
        return adjList;
    }

    public static void main(String[] args) {
        AdjListToAdjMatrix obj = new AdjListToAdjMatrix();
        int[][] matrix = {{0, 1, 1, 1, 0, 0}, {1, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 0}, {0, 0, 0, 1, 0, 1}, {0, 0, 0, 0, 1, 0}};
        List<Integer>[] adjList = obj.getAdjacenceyListFromAdjacencyMatrix(matrix);
        for (int i = 0; i < adjList.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < adjList[i].size(); j++) {
                System.out.print(adjList[i].get(j) + " ");
            }
            System.out.println();
        }
    }
}
