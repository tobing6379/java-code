package top.tobing.jz_53_i;

/**
 * @author tobing
 * @date 2021/9/20 12:48
 * @description 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class Solution1 {

    /**
     * 暴力解法
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int left, int right, int target) {
        if (left == right) {
            return nums[left] == target ? 1 : 0;
        }

        if (nums[left] > target || nums[right] < target) {
            return 0;
        }

        int mid = (right + left) >> 1;
        int leftCount = search(nums, left, mid, target);
        int rightCount = search(nums, mid + 1, right, target);
        return leftCount + rightCount;
    }
}
