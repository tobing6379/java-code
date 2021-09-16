package top.tobing.jz_45;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/9/15 11:00
 * @description 剑指 Offer 45. 把数组排成最小的数
 */
public class Solution {

    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrings, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder res = new StringBuilder();
        for (String numString : numStrings) {
            res.append(numString);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"3`2", "30", "34", "5", "9"};
        Arrays.sort(arr, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        System.out.println(Arrays.toString(arr));
        Solution solution = new Solution();
        int[] test1 = {3, 30, 34, 5, 9};
        System.out.println(solution.minNumber(test1));
    }
}
