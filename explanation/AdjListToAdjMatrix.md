# Adjacency List to Adjacency Matrix Conversion

This program aims to convert an adjacency list into its corresponding adjacency matrix representation.

### Problem Statement

An adjacency list is a collection or set of linked lists that shows or describes the connections between pairs of vertices or nodes in a graph. An adjacency matrix, on the other hand, is a 2D array that displays the relationship between vertices in a graph.

This program takes an adjacency list as input, and returns its corresponding adjacency matrix representation.

### Algorithm Used

-   Create an empty matrix of size adjacentList.length x adjacentList.length
-   Iterate over the rows of the matrix and initialize the values as 0
-   Traverse through the adjacency list and for every vertex i, visit each of its neighbors j and mark matrix[i][j] as 1.
-   When all the edges have been processed and marked as 1 in the matrix, return the matrix.

### Steps to run the program

1. Open the terminal/command prompt.
2. Navigate to the directory where the file is saved.
3. Compile the code using `javac AdjListToAdjMatrix.java` command.
4. Run the code using `java AdjListToAdjMatrix` command.
5. The output will be displayed on the console.

Note: In case there's an error while compiling or running, please make sure that Java is properly installed on your machine and the PATH is set correctly.

### Sample Input

```java
        List<Integer>[] adjList = new List[6];
        adjList[0] = List.of(1, 2, 3);
        adjList[1] = List.of(0, 2);
        adjList[2] = List.of(0, 1, 3);
        adjList[3] = List.of(0, 2, 4);
        adjList[4] = List.of(3, 5);
        adjList[5] = List.of(4);

        int[][] matrix = adjListToAdjMatrix(adjList);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
```

### Sample Output

```java
        0 1 1 1 0 0
        1 0 1 0 0 0
        1 1 0 1 0 0
        1 0 1 0 1 0
        0 0 0 1 0 1
        0 0 0 0 1 0
```
