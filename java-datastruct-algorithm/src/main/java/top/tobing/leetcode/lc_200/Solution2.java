package top.tobing.leetcode.lc_200;

/**
 * @author tobing
 * @date 2021/9/6 17:22
 * @description 200. 岛屿数量
 * 解法1：dfs简化处理
 */
public class Solution2 {


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j, rows, cols);
        dfs(grid, i + 1, j, rows, cols);
        dfs(grid, i, j - 1, rows, cols);
        dfs(grid, i, j + 1, rows, cols);
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '1', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        char[][] grid1 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'},
        };
        System.out.println(solution.numIslands(grid));
    }
}
