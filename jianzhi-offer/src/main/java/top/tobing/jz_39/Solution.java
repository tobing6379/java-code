package top.tobing.jz_39;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tobing
 * @date 2021/9/4 11:12
 * @description 剑指 Offer 39. 数组中出现次数超过一半的数字
 */
public class Solution {
    /**
     * 哈希表法
     * 时间复杂度O(n)
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
                if (count + 1 > nums.length >>> 1) {
                    return num;
                }
            }
        }
        return nums[0];
    }


}
