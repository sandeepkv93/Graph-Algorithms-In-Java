import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GraphColoring {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        };
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        colors[0] = 0;
        boolean isColorable = colorGraph(graph, colors, 0);
        System.out.println(isColorable);
        for (int ele : colors) {
            System.out.print(ele + " ");
        }
    }

    private static boolean colorGraph(int[][] graph, int[] colors, int node) {
        if (node == graph.length) {
            return true;
        }
        Set<Integer> usedColors = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] == 1 && colors[i] != -1) {
                usedColors.add(colors[i]);
            }
        }
        for (int color = 0; color < graph.length; color++) {
            if (!usedColors.contains(color)) {
                colors[node] = color;
                if (colorGraph(graph, colors, node + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
