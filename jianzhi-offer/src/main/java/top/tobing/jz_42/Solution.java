package top.tobing.jz_42;

/**
 * @author tobing
 * @date 2021/9/5 10:52
 * @description 剑指 Offer 42. 连续子数组的最大和
 */
public class Solution {

    /**
     * 暴力解法
     * 时间复杂度O(n*n)
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = i; j < nums.length; j++) {
                tmp += nums[j];
                res = Math.max(res, tmp);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(arr));
    }
}
