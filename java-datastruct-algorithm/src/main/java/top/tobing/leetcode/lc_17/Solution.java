package top.tobing.leetcode.lc_17;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author tobing
 * @date 2021/9/3 12:39
 * @description 17. 电话号码的字母组合
 * 回溯法
 */
public class Solution {

    private String[] map = {
            "",     // 0
            "!@#",  // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    private List<String> res;
    private LinkedList<Character> stack;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        stack = new LinkedList<>();
        res = new ArrayList<>();

        dfs(digits, 0);
        return res;
    }

    private void dfs(String digits, int idx) {
        // 递归结束，保存字符串
        if (idx == digits.length()) {
            StringBuilder path = new StringBuilder();
            for (Character character : stack) {
                path.append(character);
            }
            res.add(path.toString());
            return;
        }

        String str = map[digits.charAt(idx) - '0'];
        for (int i = 0; i < str.length(); i++) {
            stack.addLast(str.charAt(i));
            dfs(digits, idx + 1);
            stack.removeLast();
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations("23");
        System.out.println(strings);
    }

}
