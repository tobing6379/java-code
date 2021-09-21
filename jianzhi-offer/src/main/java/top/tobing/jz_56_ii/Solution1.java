package top.tobing.jz_56_ii;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tobing
 * @date 2021/9/21 9:35
 * @description 剑指 Offer 56 - II. 数组中数字出现的次数 II
 */
public class Solution1 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int[] bitCount = new int[32];

        for (int i = 0; i < nums.length; i++) {
            countBit(bitCount, nums[i]);
        }

        for (int i = 0; i < bitCount.length; i++) {
            bitCount[i] %= 3;
        }
        int cur = 1;
        int res = 0;
        for (int i = 0; i < bitCount.length; i++) {
            if (bitCount[i] == 1) {
                res += cur;
            }
            cur <<= 1;
        }
        return res;
    }

    /**
     * 统计number二进制格式下1出现的次数
     */
    private void countBit(int[] bitCount, int number) {
        int cur = 0;
        while (number > 0) {
            bitCount[cur++] += number & 1;
            number >>= 1;
        }
    }

    public static void main(String[] args) {
        int[] test1 = {3, 4, 3, 3};
        Solution1 solution = new Solution1();
        System.out.println(solution.singleNumber(test1));
    }
}
