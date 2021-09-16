package top.tobing.leetcode.lc_5;

/**
 * @author tobing
 * @date 2021/9/14 21:34
 * @description 5. 最长回文子串
 * 解法1：暴力解法
 */
public class Solution {

    /**
     * 超时
     */
    public String longestPalindrome(String str) {
        // 判断合法性
        if (str == null || str.length() == 0) {
            return str;
        }
        int max = 0;
        int maxI = 0;
        int maxJ = 0;
        // 判断以i开始j结尾的字符串是否为回文串
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if (isPalindrome(str, i, j)) {
                    int tmp = j - i;
                    if (max < tmp) {
                        maxI = i;
                        maxJ = j;
                        max = tmp;
                    }
                }
            }
        }
        return str.substring(maxI, maxJ + 1);
    }

    /**
     * 判断 str[i, j]是否为回文串
     */
    private boolean isPalindrome(String str, int i, int j) {
        if (i == j) {
            return true;
        }
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution main2 = new Solution();
        System.out.println(main2.longestPalindrome("dabad"));
    }
}
