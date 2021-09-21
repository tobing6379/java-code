package top.tobing.jz_56_ii;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tobing
 * @date 2021/9/21 9:35
 * @description 剑指 Offer 56 - II. 数组中数字出现的次数 II
 */
public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Map<Integer, Integer> count = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            count.merge(nums[i], 1, Integer::sum);
        }
        final int[] res = {0};
        count.forEach((k, v) -> {
            if (v == 1) {
                res[0] = k;
                return;
            }
        });
        return res[0];
    }

    public static void main(String[] args) {
        int[] test1 = {3, 4, 3, 3};
        Solution solution = new Solution();
        solution.singleNumber(test1);
    }
}
