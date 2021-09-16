package top.tobing.jz_48;

import java.util.*;

/**
 * @author tobing
 * @date 2021/9/15 11:57
 * @description 剑指 Offer 48. 最长不含重复字符的子字符串
 */
public class Solution {

    /***
     * 暴力解法
     * 超时
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isUnique(s, i, j)) {
                    res = Math.max((j - i + 1), res);
                }
            }
        }
        return res;
    }

    private boolean isUnique(String str, int start, int end) {
        if (start == end) {
            return true;
        }
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (set.contains(str.charAt(i))) {
                return false;
            } else {
                set.add(str.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }
}
