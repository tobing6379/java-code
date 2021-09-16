package top.tobing.leetcode.lc_200;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tobing
 * @date 2021/9/6 17:22
 * @description 200. 岛屿数量
 * 解法1：dfs
 */
public class Solution1 {

    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
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
        System.out.println(solution.numIslands(grid1));
    }
}
