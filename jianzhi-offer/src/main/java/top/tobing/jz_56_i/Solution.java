package top.tobing.jz_56_i;

/**
 * @author tobing
 * @date 2021/9/20 14:00
 * @description 剑指 Offer 56 - I. 数组中数字出现的次数
 */
public class Solution {
    /**
     * 【思路】
     * 在位运算中，异或操作可以实现相同为0；
     * <p>
     * <p>
     * 【要求】
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        return nums;
    }


    public static void main(String[] args) {
        int[] test = {1, 10, 4, 1, 4, 3, 3};
        int tmp = 0;
        for (int i = 0; i < test.length; i++) {
            tmp ^= test[i];
            System.out.println(tmp);
        }
    }
}
