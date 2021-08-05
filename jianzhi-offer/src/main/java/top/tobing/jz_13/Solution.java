package top.tobing.jz_13;

import java.util.Arrays;

/**
 * @Author tobing
 * @Date 2021/8/5 11:08
 * @Description 剑指 Offer 13. 机器人的运动范围
 */
public class Solution {

    private boolean[][] map;

    public int movingCount(int m, int n, int k) {
        map = new boolean[m][n];
        return dfs(m, n, 0, 0, k);
    }

    private int dfs(int m, int n, int curX, int curY, int k) {
        if (curX >= m || curX < 0 || curY >= n || curY < 0 || (countSum(curX) + countSum(curY)) > k || map[curX][curY]) {
            return 0;
        }

        // 标记为走过
        map[curX][curY] = true;
        return dfs(m, n, curX + 1, curY, k)
                + dfs(m, n, curX - 1, curY, k)
                + dfs(m, n, curX, curY + 1, k)
                + dfs(m, n, curX, curY - 1, k) + 1;
    }

    /**
     * 统计num每位数之和
     */
    private int countSum(int num) {
        if (num < 10) {
            return num;
        }
        int res = 0;
        while (num >= 1) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(7, 2, 3));
    }
}
