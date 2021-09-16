package top.tobing.leetcode.lc_200;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tobing
 * @date 2021/9/6 17:22
 * @description 200. 岛屿数量
 * 解法1：bfs
 */
public class Solution3 {

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
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        // Queue用于保存当前一个节点的临近节点
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[]{i, j});
        while (!list.isEmpty()) {
            int[] cur = list.remove();
            i = cur[0];
            j = cur[1];
            if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length) {
                grid[i][j] = '0';
                list.add(new int[]{i + 1, j});
                list.add(new int[]{i - 1, j});
                list.add(new int[]{i, j + 1});
                list.add(new int[]{i, j - 1});
            }
        }
    }


    public static void main(String[] args) {
        Solution3 solution = new Solution3();
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
