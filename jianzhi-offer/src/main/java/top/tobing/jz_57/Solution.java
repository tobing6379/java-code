package top.tobing.jz_57;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tobing
 * @date 2021/9/21 10:09
 * @description 剑指 Offer 57. 和为s的两个数字
 */
public class Solution {

    /**
     * 辅助Map
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(target - nums[i]);
            if (val != null) {
                return new int[]{nums[i], nums[val]};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {10, 26, 30, 31, 47, 60};
        int[] ints = solution.twoSum(test1, 40);
        System.out.println(Arrays.toString(ints));
    }
}
