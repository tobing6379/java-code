package top.tobing.leetcode.lc_695;

/**
 * @author tobing
 * @date 2021/9/17 23:44
 * @description 695. 岛屿的最大面积
 * 解法1：DFS简化版，原地优化
 */
public class Solution1 {


    public int maxAreaOfIsland(int[][] grid) {
        // 边界判断
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rowLen = grid.length;
        int colLen = grid[0].length;

        int res = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] != 0) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }

        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int res = 1;
        if (isArea(grid, i + 1, j) && grid[i + 1][j] != 0) {
            res += dfs(grid, i + 1, j);
        }
        if (isArea(grid, i - 1, j) && grid[i - 1][j] != 0) {
            res += dfs(grid, i - 1, j);
        }
        if (isArea(grid, i, j + 1) && grid[i][j + 1] != 0) {
            res += dfs(grid, i, j + 1);
        }
        if (isArea(grid, i, j - 1) && grid[i][j - 1] != 0) {
            res += dfs(grid, i, j - 1);
        }
        return res;
    }

    /**
     * 判断i和j是合法
     */
    private boolean isArea(int[][] grid, int i, int j) {
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
        final Solution1 solution = new Solution1();
        System.out.println(solution.maxAreaOfIsland(test1));
    }
}
