package top.tobing.jz_60;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/9/23 16:47
 * @description 剑指 Offer 60. n个骰子的点数
 */
public class Solution {

    // 每个骰子概率投出1~6的概率为1/6；
    public static final double ONE_DIV_SIX = 1.0 / 6;

    private double[][] dp;

    /**
     * 递归+dp
     */
    public double[] dicesProbability(final int n) {
        // n个骰子，最小点数是n(所有都是1)，最大的点数是6n(所有都是6)，则一共有6n-n+1=6n+1种可能；
        int len = 5 * n + 1;
        double[] res = new double[len];
        // dp[n][k]：n个骰子，投出点数为k的概率
        dp = new double[n + 1][6 * n + 1];
        int idx = 0;
        for (int i = n; i <= 6 * n; i++) {
            res[idx++] = probability(i, n);
        }
        return res;
    }

    /**
     * 计算n个骰子得出k的概率
     */
    private double probability(int k, int n) {
        if (dp[n][k] != 0) {
            return dp[n][k];
        }
        if (n == 1) {
            return ONE_DIV_SIX;
        }

        // 对于n个骰子，如果需要投出k，则第一个骰子
        // start：后面骰子最多全部投出6，此时想要投出k，第一个骰子至少是k-6(n-1)，如果这个值为负数，设置为1；
        // end：后面骰子最少全部投出1，此时想要投出k，第一个头骰子至多是k-n+1，如果这个值大于6，去6
        // i ∈ [start, end]
        double res = 0;
        for (int i = Math.max(1, k - 6 * (n - 1)); i <= k - n + 1 && i <= 6; i++) {
            // 第1个骰子扔出i，i>k-6n+1
            res += ONE_DIV_SIX * probability(k - i, n - 1);
        }
        dp[n][k] = res;
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        double[] res = solution.dicesProbability(2);
        System.out.println(Arrays.toString(res));
    }
}
