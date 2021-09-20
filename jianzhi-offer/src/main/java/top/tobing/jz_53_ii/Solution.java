package top.tobing.jz_53_ii;

/**
 * @author tobing
 * @date 2021/9/20 12:14
 * @description 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class Solution {

    /**
     * 暴力法
     */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }
}
