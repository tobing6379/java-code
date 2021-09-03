package top.tobing.leetcode.lc_990;

/**
 * @author tobing
 * @date 2021/9/1 22:17
 * @description 990. 等式方程的可满足性
 * 解法1：并查集，quick find
 */
public class Solution {

    private int[] ids;

    /**
     * 并查集
     */
    public boolean equationsPossible(String[] equations) {
        if (equations == null || equations.length == 0) {
            return true;
        }

        // 初始化并查集辅助结构
        ids = new int[26];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
        // 处理所有 a==b
        for (String equation : equations) {
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '=') {
                union(a, b);
            }
        }
        // 处理所有 a!=b
        for (String equation : equations) {
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '!') {
                if (isConnected(a, b)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int p, int q) {
        int pId = ids[p];
        int qId = ids[q];

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pId) {
                ids[i] = qId;
            }
        }
    }

    private boolean isConnected(int p, int q) {
        return ids[p] == ids[q];
    }
}
