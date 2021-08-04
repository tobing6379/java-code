package top.tobing.jz_10_ii;

/**
 * @Author tobing
 * @Date 2021/8/4 18:16
 * @Description 剑指 Offer 10- II. 青蛙跳台阶问题
 */
public class Solution {
    /**
     * 动态规划
     * 递归公式
     * f(0)=f(1)=1; 0阶或1阶时只能有1中跳法
     * f(n)=f(n-1)+f(n-2); 其他情况时，可以有f(n-2)跳2阶或f(n-1)跳1阶
     */
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
