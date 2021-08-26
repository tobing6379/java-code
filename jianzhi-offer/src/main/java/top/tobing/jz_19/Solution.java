package top.tobing.jz_19;

/**
 * @author tobing
 * @date 2021/8/10 9:38
 * @description 剑指 Offer 19. 正则表达式匹配
 */
public class Solution {

    /**
     * 【动态规划】
     * 加入主串为s，模式串为p从最后一步出发，需要关注最后进来的字符。
     * 假设s的长度为n，p的长度为m，关注正则表达式p的最后一个字符是什么（「正常字符」、「.」、「*」）
     * 1）如果p的最后一个字符为「正常字符」，直接看s[n-1]与p[m-1]是否相等，相等则前面(未添加最后一个字符的时候)是否相等，不相等则不匹配
     * 2）如果p的最后一个字符为「.」，可以匹配任意一个字符，直接看s[n-2]与p[m-2]是否相等
     * 3）如果p的最后一个字符为「*」，代表p[m-2]=c可以重复0次或多次，是一个整体c*
     * 情况1：s[n-1]是0个c，p的c*部分无需匹配，只需要判断s[0,n-1]与p[0,m-3]的情况
     * 情况2：s[n-1]是多个c中的最后一个，因此p匹配往前移动一位，s继续匹配，因为可以匹配多个，因此就行看s[0,n-2]和p[0,m-1]是否匹配
     * <p>
     * 初始条件
     * 需要特别考虑空串（空s）和空正则（空p）
     * 空s和空p可以匹配
     * 空s和非空p需要计算
     * 非空s和空p不匹配
     * 非空s和非空p肯定要技术
     *
     * @url https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/zhu-xing-xiang-xi-jiang-jie-you-qian-ru-shen-by-je/
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // 分空p和非空p
                if (j == 0) { // p空
                    if (i == 0) {
                        // 空s和空p匹配
                        dp[i][j] = true;
                    }
                } else {  // p非空
                    if (p.charAt(j - 1) != '*') {
                        // 最后加入匹配字符不为「*」存在2种情况：正常字符与「.」
                        if (i > 0                                      // 空s与非空p（i>0）一定不匹配
                                && (s.charAt(i - 1) == p.charAt(j - 1) // 正常字符
                                || p.charAt(j - 1) == '.')) {          // 「.」
                            // 直接看前面部分是否匹配
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {
                        // 最后加入的匹配字符为「*」存在2种情况：0个字符或多个字符
                        if (j >= 2) {
                            dp[i][j] |= dp[i][j - 2];
                        }
                        if (i >= 1  // 主串要求为空
                                && j >= 2  // 模式串要求非空（一个字符+*，至少两个）
                                && (s.charAt(i - 1) == p.charAt(j - 2) // 主串的最后加入字符与模式串的模糊匹配第一个字符相同
                                || p.charAt(j - 2) == '.')  // 模糊串的第一个字符为任意字符，可以任意匹配
                        ) {
                            // 直接看前一个字符（需要注意是或等，如果dp[i-1][j]为false，但是dp[i][j]上一步是true，让人是true）
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }
}



