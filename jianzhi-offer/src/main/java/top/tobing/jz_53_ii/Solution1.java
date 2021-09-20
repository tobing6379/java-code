package top.tobing.jz_53_ii;

/**
 * @author tobing
 * @date 2021/9/20 12:14
 * @description 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class Solution1 {

    /**
     * 二分法
     */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums[nums.length - 1] == nums.length - 1) {
            return nums.length;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) >> 1;
        while (start < end) {
            if (nums[mid] == mid) {
                // 前面部分不缺失值
                start = mid + 1;
            } else { // nums[mid] != mid
                end = mid;
                // 后面部分存在缺失值
            }
            mid = (start + end) >> 1;
        }

        return mid;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] test1 = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        int[] test2 = {0};
        System.out.println(solution.missingNumber(test2));
    }
}
