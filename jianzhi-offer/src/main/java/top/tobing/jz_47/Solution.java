package top.tobing.jz_47;

/**
 * @author tobing
 * @date 2021/9/15 11:49
 * @description 剑指 Offer 47. 礼物的最大价值
 * 解法1：动态规划
 */
public class Solution {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (i != 0 && j != 0) {
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                } else if (i != 0) {
                    grid[i][j] += grid[i - 1][j];
                } else if (j != 0) {
                    grid[i][j] += grid[i][j - 1];
                }
            }
        }
        return grid[rowLen - 1][colLen - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };
        System.out.println(solution.maxValue(test1));
    }
}
