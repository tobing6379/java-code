package top.tobing.jz_59_i;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/9/21 11:09
 * @description 剑指 Offer 59 - I. 滑动窗口的最大值
 */
public class Solution {


    /**
     * 暴力解法
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null ||nums.length == 0||  nums.length < k) {
            return nums;
        }

        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = findMax(nums, i, i + k - 1);
        }

        return res;
    }

    private int findMax(int[] nums, int left, int right) {
        int res = nums[left];
        for (int i = left + 1; i <= right; i++) {
            res = Math.max(nums[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = solution.maxSlidingWindow(test, 3);
        System.out.println(Arrays.toString(ints));
    }
}
