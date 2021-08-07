package top.tobing.jz_14_ii;

import top.tobing.jz_14_i.Solution1;

import java.math.BigInteger;

/**
 * @Author tobing
 * @Date 2021/8/7 10:14
 * @Description 剑指 Offer 14- II. 剪绳子 II
 */
public class Solution {

    /**
     * 动态规划
     * 其实本题和上面一题{@link Solution1}是一样的，只不过本题的范围变大了
     * 本题中重点要考虑的问题就是如何处理大整数的问题，由于在使用dp时，
     * 需要将每一步执行的最大值进行储存，以便于下次执行计算，
     * 但是如果使用的是int，肯定会超出范围，从而导致精度丢失，
     * 和加法不同，a%b+c%b=(a+c)%b，本题使用的是乘法，因此无法利用求余的性质，
     * 因此需要使用BigInteger进行运行，但是性能消耗较大，
     * 最后的方法还是通过数学证明，题解如下，本初不做实现
     * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/mian-shi-ti-14-ii-jian-sheng-zi-iitan-xin-er-fen-f/
     */
    public int cuttingRope(int n) {
        if (n <= 2) {
            return 1;
        }
        BigInteger[] dp = new BigInteger[n + 1];
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(1);
        // cuttingRope(i)的最大值
        for (int i = 3; i <= n; i++) {
            BigInteger max = BigInteger.valueOf(0);
            // 将长度为i的绳子，分成 j 和 i-j
            for (int j = 1; j < i; j++) {
                BigInteger tempA = BigInteger.valueOf((long) j * (i - j));
                BigInteger tempB = dp[i - j].multiply(BigInteger.valueOf(j));
                max = max.compareTo(tempB) > 0 ? max : tempB;
                max = max.compareTo(tempA) > 0 ? max : tempA;
            }
            dp[i] = max;
        }
        BigInteger mod = dp[n].mod(BigInteger.valueOf(1000000007L));
        return mod.intValue();
    }

    public static void main(String[] args) {
        int res = new Solution().cuttingRope(10);
        System.out.println(res);
    }
}
