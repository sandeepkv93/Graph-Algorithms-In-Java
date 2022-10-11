
public class PathCompression {
    // Array to store the parent of each node
    private final int[] root;

    // O(n)
    // Initialize the root array to itself so that root of each node is itself
    public PathCompression(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    // O(logn)
    // Until the root of the given element is itself, set its root to find of its root
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    // O(logn)
    // Find the root of x and y
    // If they are not same, then set the root of root y to root of x
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    // O(logn)
    // Call find on x and y, and check if they are same
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) throws Exception {
        PathCompression pathCompression = new PathCompression(10);
        // 1-2-5-6-7 3-8-9 4
        pathCompression.union(1, 2);
        pathCompression.union(2, 5);
        pathCompression.union(5, 6);
        pathCompression.union(6, 7);
        pathCompression.union(3, 8);
        pathCompression.union(8, 9);
        System.out.println(pathCompression.connected(1, 5)); // true
        System.out.println(pathCompression.connected(5, 7)); // true
        System.out.println(pathCompression.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        pathCompression.union(9, 4);
        System.out.println(pathCompression.connected(4, 9)); // true
    }
}
