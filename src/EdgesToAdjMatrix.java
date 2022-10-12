public class EdgesToAdjMatrix {
    /*
        1. Create a 2-dimensional array of size n x n, which represents the adjacency
        matrix
        2. For each edge in the edges array, set the corresponding value in the
        adjacency matrix to 1
        3. Return the adjacency matrix 
    */
    public int[][] getAdjacencyMatrixFromEdges(int[][] edges, int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            matrix[edges[i][0]][edges[i][1]] = 1;
            matrix[edges[i][1]][edges[i][0]] = 1;
        }
        return matrix;
    }

    public static void main(String[] args) {
        EdgesToAdjMatrix obj = new EdgesToAdjMatrix();
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {2, 3}, {3, 4}, {4, 5}};
        int[][] matrix = obj.getAdjacencyMatrixFromEdges(edges, 6);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
