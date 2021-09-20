package top.tobing.jz_49;

/**
 * @author tobing
 * @date 2021/9/20 11:39
 * @description 剑指 Offer 49. 丑数
 */
public class Solution {

    /**
     * 三数取小法
     * 一个丑数乘上5之后，可能会被后面的丑数乘上2还要大；
     * 因此需要为和每个丑数乘上2、3、5的情况；
     * 只有被选中之后才将乘上2的丑数往后递增；
     */
    public int nthUglyNumber(int n) {
        int a = 0;
        int b = 0;
        int c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));
            //  可能存在 n2==n3 n3==n5 n2==n5等情况
            // 为了去重，存在重复直接两个都递增
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }
        return dp[n - 1];
    }
}

