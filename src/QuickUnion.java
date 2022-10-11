public class QuickUnion {
    // Array to maintain the root of each nodes
    private final int[] root;

    // O(n)
    // Initialize the root array to itself so that root of each node is itself
    public QuickUnion(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    // O(n)
    // Until the root of the given element is itself, set the element to its root
    // This finds the top level ancestor of the given element
    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    // Find the root of x and y
    // If they are not same, then set the root of root y to root of x
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    // O(n)
    // Call find on x and y, and check if they are same
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) throws Exception {
        QuickUnion quickUnion = new QuickUnion(10);
        // 1-2-5-6-7 3-8-9 4
        quickUnion.union(1, 2);
        quickUnion.union(2, 5);
        quickUnion.union(5, 6);
        quickUnion.union(6, 7);
        quickUnion.union(3, 8);
        quickUnion.union(8, 9);
        System.out.println(quickUnion.connected(1, 5)); // true
        System.out.println(quickUnion.connected(5, 7)); // true
        System.out.println(quickUnion.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        quickUnion.union(9, 4);
        System.out.println(quickUnion.connected(4, 9)); // true
    }
}

