package top.tobing.jz_16;

/**
 * @author tobing
 * @date 2021/8/8 13:31
 * @description 剑指 Offer 16. 数值的整数次方
 */
public class Solution {

    /**
     * 暴力解法
     * 超时：301 / 304 个通过测试用例，
     * 2.00000     -2147483648
     */
    public double myPow(double x, int n) {
        // 1的n次幂等于1，任何数的0次幂等于1
        if (n == 0 || 1.0 == x) {
            return 1;
        }
        double res = 1.0;
        // 负次幂相除，正次幂相乘
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                res *= x;
            }
        } else {
            for (int i = 0; i > n; i--) {
                res /= x;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(1.00000,
                2147483647));
    }
}
