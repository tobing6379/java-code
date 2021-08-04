package top.tobing.jz_10_i;

/**
 * @Author tobing
 * @Date 2021/8/4 18:08
 * @Description 剑指 Offer 10- I. 斐波那契数列
 */
public class Solution {
    /**
     * 普通递归法【超时】
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) % 1000000007 + fib(n - 2) % 1000000007;
    }
}
