package top.tobing.leetcode.lc_785;

/**
 * @author tobing
 * @date 2021/9/18 0:17
 * @description 785. 判断二分图
 * 解法1：dfs-二分图
 */
public class Solution {

    private int[] colors;
    private boolean[] visited;

    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return true;
        }

        int nodes = graph.length;
        colors = new int[nodes];
        visited = new boolean[nodes];

        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                if (!dfs(graph, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean dfs(int[][] graph, int v, int color) {
        visited[v] = true;
        colors[v] = color;
        for (int w : graph[v]) {
            if (!visited[w]) {
                if (!dfs(graph, w, 1 - color)) {
                    return false;
                }
            } else {
                if (colors[w] == colors[v]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();
        int[][] test1 = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2},
        };
        int[][] test2 = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2},
        };
        int[][] test3 = {
                {},
                {2, 4, 6},
                {1, 4, 8, 9},
                {7, 8},
                {1, 2, 8, 9},
                {6, 9},
                {1, 5, 7, 8, 9},
                {3, 6, 9},
                {2, 3, 4, 6, 9},
                {2, 4, 5, 6, 7, 8},
        };
//        System.out.println(solution.isBipartite(test1));
//        System.out.println(solution.isBipartite(test2));
        System.out.println(solution.isBipartite(test3));
    }
}
