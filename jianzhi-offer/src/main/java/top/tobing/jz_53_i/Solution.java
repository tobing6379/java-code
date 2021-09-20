package top.tobing.jz_53_i;

/**
 * @author tobing
 * @date 2021/9/20 12:48
 * @description 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class Solution {

    /**
     * 暴力解法
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        for (int num : nums) {
            if (num == target) {
                res++;
            }
        }
        return res;
    }
}
