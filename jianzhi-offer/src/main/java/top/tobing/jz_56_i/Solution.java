package top.tobing.jz_56_i;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/9/20 14:00
 * @description 剑指 Offer 56 - I. 数组中数字出现的次数
 */
public class Solution {
    /**
     * 【思路】
     * 在位运算中，对于异或操作，相同为0，不同为1；
     * ①a^a=0
     * ②a^b^a^b=0
     * ③a^b^a^b^c=c
     * <p>
     * 【要求】
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        // 假设只出现一次的两个数字分别为a和b
        // 则通过下列运算，最终k=a^b
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }
        // 由于a!=b，则至少存在一位mask使得a&mask!=b&mask
        int mask = 1;
        while ((k & mask) == 0) {
            mask <<= 1;
        }

        // 根据mask将a和b分到不同组
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }


    public static void main(String[] args) {
        int[] test = {1, 2, 10, 4, 1, 4, 3, 3};
        Solution solution = new Solution();
        int[] ints = solution.singleNumbers(test);
        System.out.println(Arrays.toString(ints));
    }
}
