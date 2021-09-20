package top.tobing.jz_50;

/**
 * @author tobing
 * @date 2021/9/20 11:52
 * @description 剑指 Offer 50. 第一个只出现一次的字符
 */
public class Solution {


    /**
     * 统计法（映射法）
     */
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        // 只存在小写字母，统计字母出现的次数
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
