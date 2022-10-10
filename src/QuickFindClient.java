class QuickFind {
    // Array to maintain the root of each nodes
    private final int[] root;

    // O(n)
    // Initialize the root array to itself so that root of each node is itself
    public QuickFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    // O(1)
    // Returns the root of the given element from the root array
    public int find(int x) {
        return root[x];
    }

    // O(n)
    // Find the root of x and y
    // If they are not same, then set the root of all the elements for which the root is y to root of x
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }

    // O(1)
    // Call find on x and y, and check if they are same
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

public class QuickFindClient {
    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(10);
        // 1-2-5-6-7 3-8-9 4
        quickFind.union(1, 2);
        quickFind.union(2, 5);
        quickFind.union(5, 6);
        quickFind.union(6, 7);
        quickFind.union(3, 8);
        quickFind.union(8, 9);
        System.out.println(quickFind.connected(1, 5)); // true
        System.out.println(quickFind.connected(5, 7)); // true
        System.out.println(quickFind.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        quickFind.union(9, 4);
        System.out.println(quickFind.connected(4, 9)); // true
    }
}
