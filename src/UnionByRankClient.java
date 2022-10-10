class UnionByRank {
    // Array to store the parent of each node
    private final int[] root;
    // Array to store the rank of each node
    private final int[] rank;

    // O(n)
    // Initialize the root array to itself so that root of each node is itself
    // Initialize the rank array to 1 so that rank of each node is 1 initially
    public UnionByRank(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    // O(log n)
    // Until the root of the given element is itself, set the element to its root
    // This finds the top level ancestor of the given element
    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    /*
     * When we union two vertices, instead of always picking the root of x (or y,
     * it doesn't matter as long as we're consistent) as the new root node,
     * we choose the root node of the vertex with a larger “rank”.
     * We will merge the shorter tree under the taller tree
     * and assign the root node of the taller tree as the root node for both vertices.
     * In this way, we effectively avoid the possibility of connecting all vertices into a straight line
     * Time complexity: O(log n)
     */
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

    // O(log n)
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

public class UnionByRankClient {
    public static void main(String[] args) throws Exception {
        UnionByRank unionByRank = new UnionByRank(10);
        // 1-2-5-6-7 3-8-9 4
        unionByRank.union(1, 2);
        unionByRank.union(2, 5);
        unionByRank.union(5, 6);
        unionByRank.union(6, 7);
        unionByRank.union(3, 8);
        unionByRank.union(8, 9);
        System.out.println(unionByRank.connected(1, 5)); // true
        System.out.println(unionByRank.connected(5, 7)); // true
        System.out.println(unionByRank.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        unionByRank.union(9, 4);
        System.out.println(unionByRank.connected(4, 9)); // true
    }
}
