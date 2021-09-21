package top.tobing.jz_58_ii;

/**
 * @author tobing
 * @date 2021/9/21 11:06
 * @description 剑指 Offer 58 - II. 左旋转字符串
 */
public class Solution {
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0 || n <= 0) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseLeftWords("abcdefg", 2));
        System.out.println(solution.reverseLeftWords("lrloseumgh", 6));
    }
}
