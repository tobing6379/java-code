package top.tobing.jz_42;

/**
 * @author tobing
 * @date 2021/9/5 10:52
 * @description 剑指 Offer 42. 连续子数组的最大和
 */
public class Solution1 {

    /**
     * 动态规划
     * 时间复杂度O(n)，当前状态可以有上一个状态与当前状态来决定
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            res = Math.max(res, nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(arr));
    }
}
