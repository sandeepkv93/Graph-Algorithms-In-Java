public class UnionFind {
    // Array to store the parent of each node
    private final int[] root;
    // Array to store the rank of each node
    private final int[] rank;

    // O(n)
    // Initialize the root array to itself so that root of each node is itself
    // Initialize the rank array to 1 so that rank of each node is 1 initially
    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; // The initial "rank" of each vertex is 1, because each of them is
            // a standalone vertex with no connection to other vertices.
        }
    }

    // The find function here is the same as that in the disjoint set with path compression.
    // O(α(N)) ~= O(1)
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    // The union function with union by rank
    // O(α(N)) ~= O(1)
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    // O(α(N)) ~= O(1)
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) throws Exception {
        UnionFind unionFind = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        unionFind.union(1, 2);
        unionFind.union(2, 5);
        unionFind.union(5, 6);
        unionFind.union(6, 7);
        unionFind.union(3, 8);
        unionFind.union(8, 9);
        System.out.println(unionFind.connected(1, 5)); // true
        System.out.println(unionFind.connected(5, 7)); // true
        System.out.println(unionFind.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        unionFind.union(9, 4);
        System.out.println(unionFind.connected(4, 9)); // true
    }
}
