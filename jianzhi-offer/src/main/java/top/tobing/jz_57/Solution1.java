package top.tobing.jz_57;

import top.tobing.jz_04.Solution2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tobing
 * @date 2021/9/21 10:09
 * @description 剑指 Offer 57. 和为s的两个数字
 */
public class Solution1 {

    /**
     * 双指针
     * 【理解】
     * 另S(i,j) = nums[i]+nums[j]
     * --------
     * |S(0,1)|
     * ---------------
     * |S(0,2)|S(1,2)|
     * ----------------------
     * |S(0,3)|S(1,3)|S(2,3)|
     * -----------------------------
     * |S(0,4)|S(1,4)|S(2,4)|S(3,4)|
     * ------------------------------------
     * |S(0,5)|S(1,5)|S(2,5)|S(3,5)|S(4,5)|
     * ------------------------------------
     * 假设初始时，i=0，j=5
     * 如果S(0,5) < target，则消去第一列；i++
     * 如果S(0,5) > target，则消去第一行；j--
     * 类似与JZ04{@link Solution2#findNumberIn2DArray(int[][], int)}
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (nums[left] + nums[right] != target) {
            int cur = nums[left] + nums[right];
            if (cur < target) {
                left++;
            } else if (cur > target) {
                right--;
            }
        }
        return new int[]{nums[left], nums[right]};
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] test1 = {10, 26, 30, 31, 47, 60};
        int[] ints = solution.twoSum(test1, 40);
        System.out.println(Arrays.toString(ints));
    }
}
