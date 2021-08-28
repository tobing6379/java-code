package top.tobing.jz_21;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/8/28 10:17
 * @description 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class Solution {

    /**
     * 简单双指针
     */
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        // 前闭后闭区间
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            // 当nums[start]为偶数，nums[end]为奇数时，刚好和题目要求相反，直接交换即可
            if (nums[start] % 2 == 0 && nums[end] % 2 == 1) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            } else {
                // 当nums[start]不为偶数，将start向前移动，直到为偶数
                if (nums[start] % 2 == 1) {
                    start++;
                }
                // 当nums[end]不为奇数，将end先后移动，直到为奇数
                if (nums[end] % 2 == 0) {
                    end--;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7};
        int[] exchange = new Solution().exchange(test);
        System.out.println(Arrays.toString(exchange));
    }
}
