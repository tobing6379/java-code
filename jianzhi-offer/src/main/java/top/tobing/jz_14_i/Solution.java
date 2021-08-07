package top.tobing.jz_14_i;

/**
 * @Author tobing
 * @Date 2021/8/7 9:25
 * @Description 剑指 Offer 14- I. 剪绳子
 */
public class Solution {
    /**
     * 暴击递归解法
     * 存在大量重复的计算过程，考虑使用dp，同时可以看出本题应该使用动态规划
     * 最直观的想法就是分别求长度为n的绳子在分成[ 2，n ]份的乘积最大值。
     * 对于将n的绳子分为m份，可以看做是每次将n的绳子先分出1份，再在剩下的部分分出m-1份
     * 因此递归函数可以定义为，求长度为n的绳子，分成m段时每段乘积最大值。
     */
    public int cuttingRope(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, recur(n, i));
        }
        return res;
    }

    /**
     * 求长度为n的绳子，分成m端时，各段相乘的最大值
     */
    private int recur(int n, int m) {
        // 当绳子只需要分成一段，直接返回原值
        if (m == 1) {
            return n;
        }

        int max = 0;
        // 将绳子分为m端，第一段的位置可以在绳子的[1,n-1]切分
        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * recur(n - i, m - 1));
        }
        return max;
    }

}
