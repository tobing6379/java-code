package top.tobing.jz_17;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/8/9 8:48
 * @description 剑指 Offer 17. 打印从1到最大的n位数
 */
public class Solution {
    /**
     * 普通解法
     */
    public int[] printNumbers(int n) {
        int temp = 1;
        for (int i = 0; i < n; i++) {
            temp *= 10;
        }
        int[] res = new int[temp - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new Solution().printNumbers(1);
        System.out.println(Arrays.toString(res));
    }
}
