# DFS Recursive with Adjacency Matrix

This is a Java program that performs depth-first search (DFS) on a graph represented by an adjacency matrix.

### Problem Statement

Depth-first search is a graph traversal algorithm that visits all the vertices of a graph in a depth-first manner. The algorithm starts at a source vertex and explores as far as possible along each branch before backtracking. The goal is to visit every vertex in the graph.

The problem is to implement the depth-first search algorithm on a graph represented by an adjacency matrix.

### Algorithm

The algorithm for performing depth-first search on a graph represented by an adjacency matrix is as follows:

1. Start at a source vertex and mark it as visited.
1. Print the source vertex.
1. For each adjacent vertex of the source vertex, if it has not been visited, recursively call the depth-first search function on that vertex.
1. When all the adjacent vertices have been visited, backtrack to the previous vertex and continue with the next adjacent vertex.

The above algorithm is implemented using a recursive function `dfsUtil(boolean[] visited, int source)` that performs depth-first search on a given source vertex.

### Code Explanation

#### Class `DFSRecursiveAdjMatrix`

The DFSRecursiveAdjMatrix class represents a graph and provides methods for adding edges, populating the graph with edges, and performing depth-first search.

#### Variables

1. `v`: an integer representing the number of vertices in the graph.
1. `adjMatrix`: a two-dimensional integer array representing the adjacency matrix of the graph.

#### Constructor

The `DFSRecursiveAdjMatrix(int v)` constructor creates a new instance of the `DFSRecursiveAdjMatrix` class with the specified number of vertices.

#### Methods

1. `addEdge(int src, int dest)`: adds an undirected edge between two vertices in the graph.
1. `populateGraph(int[][] edges)`: populates the graph with the specified edges.
1. `dfs()`: performs depth-first search on the graph.
1. `dfsUtil(boolean[] visited, int source)`: performs depth-first search on a given source vertex.

#### Main Method

The main method creates a new instance of the DFSRecursiveAdjMatrix class, populates the graph with edges, and performs depth-first search on the graph.

### Complexity Analysis

#### Time Complexity

The time complexity of the depth-first search algorithm is O(V + E), where V is the number of vertices and E is the number of edges in the graph.

#### Space Complexity

The space complexity of the depth-first search algorithm is O(V), where V is the number of vertices in the graph.

### Sample Input

```java
int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {4, 5}, {2, 5}, {2, 6}, {2, 7}, {8, 9}};
DFSRecursiveAdjMatrix graph = new DFSRecursiveAdjMatrix(10);
graph.populateGraph(edges);
graph.dfs();
```

The input specifies a graph with 10 vertices and the following edges:

```

0 -- 1
| |
2 -- 3
| |
4 -- 5
|
6 -- 7
8 -- 9

```

### Sample Output

```
0 1 3 4 5 2 6 7 8 9
```
