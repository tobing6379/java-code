package top.tobing.jz_38;

import java.util.*;

/**
 * @author tobing
 * @date 2021/9/3 11:02
 * @description 剑指 Offer 38. 字符串的排列
 */
public class Solution {

    private boolean[] visited;
    private Stack<Character> stack;
    private Set<String> res;


    /**
     * 暴力回溯法
     */
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        visited = new boolean[s.length()];
        stack = new Stack<>();
        res = new HashSet<>();
        dfs(s, 0);
        return res.toArray(new String[0]);
    }

    private void dfs(String s, int idx) {
        // 遍历终止
        if (idx == s.length()) {
            StringBuilder builder = new StringBuilder();
            for (Character re : stack) {
                builder.append(re);
            }
            res.add(builder.toString());
        }

        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                stack.push(s.charAt(i));
                visited[i] = true;
                dfs(s, idx + 1);
                stack.pop();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = solution.permutation("aab");
        System.out.println(Arrays.toString(arr));
    }
}
