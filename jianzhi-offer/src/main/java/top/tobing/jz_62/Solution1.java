package top.tobing.jz_62;

import java.util.LinkedList;

/**
 * @author tobing
 * @date 2021/9/23 18:51
 * @description 剑指 Offer 62. 圆圈中最后剩下的数字
 */
public class Solution1 {

    /**
     * 暴力解法
     */
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.lastRemaining(56795, 87778));
    }

}
