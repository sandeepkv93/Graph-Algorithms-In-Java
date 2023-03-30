# Adjacency Matrix to Adjacency List

This code is a Java implementation of a simple algorithm to convert a given adjacency matrix into its corresponding adjacency list.

## Problem Statement

An adjacency matrix is a square matrix where the element in the i-th row and j-th column represents the presence of an edge between the i-th and j-th nodes in a graph. If the element is 1, then an edge exists between the two nodes; otherwise, it does not.

An adjacency list, on the other hand, is a collection of lists where the i-th list contains all the nodes that are adjacent to the i-th node in a graph.

This code takes an adjacency matrix as input and returns its corresponding adjacency list as output.

## Algorithm

The algorithm for converting an adjacency matrix into an adjacency list is straightforward and involves the following steps:

1. Create an array of ArrayLists, with the size of the matrix.
1. For each row in the matrix, create a new ArrayList.
1. For each column in the row, if the value is 1, add the index of the column to the ArrayList.
1. Return the array of ArrayLists.

The implementation in this code follows this algorithm closely. It creates an array of ArrayLists of the same length as the input matrix. For each row in the matrix, a new ArrayList is created, and for each column in the row, if the value is 1, the index of the column is added to the ArrayList. Finally, the resulting array of ArrayLists is returned.

## How to use

The code can be used as a standalone Java program or as a class in another Java program. The main method in the class demonstrates how to use the code. It creates an instance of the `AdjMatrixToAdjList` class, initializes an adjacency matrix, and calls the `getAdjacenceyListFromAdjacencyMatrix` method to obtain the adjacency list. The resulting adjacency list is then printed to the console.

To use the code in another Java program, simply import the `AdjMatrixToAdjList` class and call its `getAdjacenceyListFromAdjacencyMatrix` method with a suitable adjacency matrix.

## Sample Input

```java
int[][] matrix = {{0, 1, 1, 1, 0, 0}, {1, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 0}, {0, 0, 0, 1, 0, 1}, {0, 0, 0, 0, 1, 0}};
List<Integer>[] adjList = obj.getAdjacenceyListFromAdjacencyMatrix(matrix);
```

## Sample Output

```
0 1 2 3
1 0 2
2 0 1 3
3 0 2 4
4 3 5
5 4
```

The output shows the adjacency list for the given adjacency matrix. For example, the first line 0 1 2 3 indicates that node 0 is adjacent to nodes 1, 2, and 3. Similarly, the second line 1 0 2 indicates that node 1 is adjacent to nodes 0 and 2. The remaining lines follow the same pattern, with each line representing the adjacency list for the corresponding node.

## Conclusion

This code demonstrates a simple algorithm for converting an adjacency matrix into an adjacency list. The algorithm is straightforward and easy to understand, making it a useful tool in graph theory and related fields. The code is well-documented and easy to use, making it a good starting point for anyone interested in working with graphs in Java.
