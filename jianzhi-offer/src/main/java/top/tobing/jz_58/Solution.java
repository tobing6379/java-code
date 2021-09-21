package top.tobing.jz_58;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/9/21 10:51
 * @description 剑指 Offer 58 - I. 翻转单词顺序
 */
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!"".equals(words[i])) {
                res.append(words[i]);
                res.append(" ");
            }
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
        System.out.println(solution.reverseWords("  hello world!  "));
        System.out.println(solution.reverseWords("a good   example"));
        String[] s = "a good   example".split(" ");
        System.out.println(Arrays.toString(s));
    }
}
