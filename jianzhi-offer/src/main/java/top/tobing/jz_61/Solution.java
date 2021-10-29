package top.tobing.jz_61;

/**
 * @author tobing
 * @date 2021/9/23 18:08
 * @description 剑指 Offer 61. 扑克牌中的顺子
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        int[] count = new int[14];
        for (int num : nums) {
            count[num]++;
        }
        boolean isNoFirst = false;
        int len = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0 && !isNoFirst) { // 不存在牌且前面没有牌，直接跳过
                continue;
            }
            if (count[i] == 1 && !isNoFirst) { // 第一牌
                isNoFirst = true;
                len++;
                continue;
            }
            if (count[i] == 1) {
                len++;
            } else if (count[i] == 0) {
                if (count[0] > 0) {
                    count[0]--;
                    len++;
                } else {
                    break;
                }
            }
        }
        len += count[0];
        return len >= 5;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5};
        int[] test2 = {0, 0, 1, 2, 5};
        int[] test3 = {0, 6, 1, 2, 5};
        int[] test4 = {11, 10, 0, 0, 12};
        Solution solution = new Solution();
        System.out.println(solution.isStraight(test1));
        System.out.println(solution.isStraight(test2));
        System.out.println(solution.isStraight(test3));
        System.out.println(solution.isStraight(test4));
    }
}
