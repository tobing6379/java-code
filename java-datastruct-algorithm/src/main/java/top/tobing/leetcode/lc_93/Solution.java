package top.tobing.leetcode.lc_93;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author tobing
 * @date 2021/9/3 13:05
 * @description 93. 复原 IP 地址
 */
public class Solution {

    private Stack<String> stack;
    private List<String> res;

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0 || s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        stack = new Stack<>();
        trackBack(s, 0, 0);

        return res;
    }

    private void trackBack(String s, int start, int idx) {

        // IP地址最多4段
        if (idx == 4) {
            if (start == s.length()) {
                res.add(String.join(".", stack));
            }
            return;
        }

        for (int i = 0; i < 3 && start + i < s.length(); i++) {
            String current = s.substring(start, start + i + 1);
            int tmp = Integer.parseInt(current);
            if (tmp >= 0 && tmp <= 255) {
                stack.push(String.valueOf(tmp));
                trackBack(s, start + i + 1, idx + 1);
                stack.pop();
            }
            if (s.charAt(start) == '0') {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("101023"));
    }
}
