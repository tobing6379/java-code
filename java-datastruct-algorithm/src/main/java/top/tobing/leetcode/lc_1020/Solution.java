package top.tobing.leetcode.lc_1020;

/**
 * @author tobing
 * @date 2021/9/19 0:20
 * @description 1020. 飞地的数量
 * 解法1：DFS
 */
public class Solution {
    public int numEnclaves(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int rowLen = grid.length;
        if (rowLen == 0) {
            return 0;
        }
        int colLen = grid[0].length;
        if (colLen == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] != 0) {
                    int temp = dfs(grid, i, j);
                    if (temp > 0) {
                        res += temp;
                    }
                }
            }
        }
        return res;
    }


    /**
     * 当接触到陆地，直接返回-1
     * 当没接触到陆地，返回且合法，返回1
     */
    private int dfs(int[][] grid, int i, int j) {
        //接触到陆地
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return -1;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;

        int right = dfs(grid, i + 1, j);
        int left = dfs(grid, i - 1, j);
        int up = dfs(grid, i, j + 1);
        int down = dfs(grid, i, j - 1);
        if (right == -1 || left == -1 || up == -1 || down == -1) {
            return -1;
        } else {
            return 1 + right + left + up + down;
        }
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();
        int[][] test1 = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
        };
        System.out.println(solution.numEnclaves(test1));
    }
}
