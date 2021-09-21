package top.tobing.jz_56_ii;

/**
 * @author tobing
 * @date 2021/9/21 9:35
 * @description 剑指 Offer 56 - II. 数组中数字出现的次数 II
 */
public class Solution2 {
    /**
     * TODO
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
            System.out.printf("%d : %d, %d\n", num, ones, twos);
        }

        return ones;
    }


    public static void main(String[] args) {
        int[] test1 = {3, 4, 3, 3};
        Solution2 solution = new Solution2();
        System.out.println(solution.singleNumber(test1));
    }
}
