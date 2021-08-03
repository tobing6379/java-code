package top.tobing.jz_3;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author tobing
 * @Date 2021/8/3 9:02
 * @Description 剑指 Offer 03. 数组中重复的数字
 */
public class Solution {

    /**
     * 辅助Set
     */
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
