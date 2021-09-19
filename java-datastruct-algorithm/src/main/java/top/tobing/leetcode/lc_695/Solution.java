package top.tobing.leetcode.lc_695;

/**
 * @author tobing
 * @date 2021/9/17 23:44
 * @description 695. 岛屿的最大面积
 * 解法1：DFS
 */
public class Solution {

    private int[][] grid;
    private boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rowLen = grid.length;
        int colLen = grid[0].length;

        this.grid = grid;
        visited = new boolean[rowLen][colLen];
        int res = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (!visited[i][j] && grid[i][j] != 0) {
                    res = Math.max(res, dfs(i, j));
                }
            }
        }

        return res;
    }

    private int dfs(int i, int j) {
        visited[i][j] = true;
        int res = 1;
        if (isArea(i + 1, j) && grid[i + 1][j] != 0 && !visited[i + 1][j]) {
            res += dfs(i + 1, j);
        }
        if (isArea(i - 1, j) && grid[i - 1][j] != 0 && !visited[i - 1][j]) {
            res += dfs(i - 1, j);
        }
        if (isArea(i, j + 1) && grid[i][j + 1] != 0 && !visited[i][j + 1]) {
            res += dfs(i, j + 1);
        }
        if (isArea(i, j - 1) && grid[i][j - 1] != 0 && !visited[i][j - 1]) {
            res += dfs(i, j - 1);
        }
        return res;
    }

    /**
     * 判断i和j是合法
     */
    private boolean isArea(int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public static void main(String[] args) {
        int[][] test1 = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
        };
        int[][] test2 = {
                {1, 1}
        };
        final Solution solution = new Solution();
        System.out.println(solution.maxAreaOfIsland(test2));
    }
}
