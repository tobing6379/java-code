package top.tobing.jz_10_i;

/**
 * @Author tobing
 * @Date 2021/8/4 18:08
 * @Description 剑指 Offer 10- I. 斐波那契数列
 */
public class Solution1 {
    /**
     * 动态规划
     * 递推公式
     * f(0)=0; f(1)=1;
     * f(n)=f(n-1)+f(n-1);
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
