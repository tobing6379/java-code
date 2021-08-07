package top.tobing.jz_14_i;

/**
 * @Author tobing
 * @Date 2021/8/7 9:25
 * @Description 剑指 Offer 14- I. 剪绳子
 */
public class Solution1 {
    /**
     * 暴击递归解法
     * 存在大量重复的计算过程，考虑使用dp，同时可以看出本题应该使用动态规划
     */
    public int cuttingRope(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        // cuttingRope(i)的最大值
        for (int i = 3; i <= n; i++) {
            int max = 0;
            // 将长度为i的绳子，分成 j 和 i-j
            for (int j = 1; j < i; j++) {
                int temp = Math.max(j * (i - j), j * dp[i - j]);
                max = Math.max(temp, max);
            }
            dp[i] = max;
        }
        return dp[n];
    }

}
