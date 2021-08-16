package top.tobing.jz_19;

/**
 * @author tobing
 * @date 2021/8/10 9:38
 * @description 剑指 Offer 19. 正则表达式匹配
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (s.length() == 0 && p.length() == 0) {
            return true;
        } else if (s.length() == 0) {
            return false;
        } else if (p.length() == 0) {
            return false;
        }

        int sIdx = 0;
        int pIdx = 0;
        while (pIdx < p.length()) {
        }


        return true;
    }
}



