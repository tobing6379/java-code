package top.tobing.leetcode.jz_990;

/**
 * @author tobing
 * @date 2021/9/1 22:17
 * @description 990. 等式方程的可满足性
 * 解法1：并查集，quick union
 */
public class Solution1 {

    /**
     * parent[i] 代表第i个元素指向的父节点
     */
    private int[] parent;
    /**
     * rank[i]代表以i为根的集合所代表的树的层数
     */
    private int[] rank;

    /**
     * 并查集
     */
    public boolean equationsPossible(String[] equations) {
        if (equations == null || equations.length == 0) {
            return true;
        }

        // 初始化并查集辅助结构
        parent = new int[26];
        rank = new int[26];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
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

    private int find(int p) {
        if (p < 0 || p > 26) {
            return -1;
        }

        while (p != parent[p]) {
            // 路径压缩
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {
            return;
        }

        // 层数小的添加到层数大的
        if (rank[pId] > rank[qId]) {
            parent[qId] = pId;
        } else if (rank[pId] < rank[qId]) {
            parent[pId] = qId;
        } else {
            parent[pId] = qId;
            // 维护rank
            rank[qId]++;
        }
    }

    private boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
