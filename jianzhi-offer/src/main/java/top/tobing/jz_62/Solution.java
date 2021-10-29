package top.tobing.jz_62;

import java.util.LinkedList;

/**
 * @author tobing
 * @date 2021/9/23 18:51
 * @description 剑指 Offer 62. 圆圈中最后剩下的数字
 */
public class Solution {

    /**
     * 暴力解法
     */
    public int lastRemaining(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.addLast(i);
        }

        int i = 0;
        while (list.size() > 1) {
            i = (i + m - 1) % list.size();
            list.remove(i);
        }
        return list.getLast();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastRemaining(56795, 87778));
    }

}
