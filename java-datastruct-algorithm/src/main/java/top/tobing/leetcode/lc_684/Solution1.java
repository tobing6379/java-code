package top.tobing.leetcode.lc_684;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/9/1 22:42
 * @description 684. 冗余连接
 * 解法2：并查集QuickUnion
 */
public class Solution1 {

    private int[] parent;
    private int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            return new int[0];
        }

        // 初始化并查集结构
        parent = new int[edges.length];
        rank = new int[edges.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        // 使用并查集求解
        // 如果isConnected，该边可以直接废弃
        // 否则该边有效，执行union操作
        for (int[] edge : edges) {
            int p = edge[0] - 1;
            int q = edge[1] - 1;
            if (isConnected(p, q)) {
                return new int[]{p + 1, q + 1};
            } else {
                union(p, q);
            }
        }

        return new int[0];

    }

    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            return -1;
        }

        while (p != parent[p]) {
            // 路径压缩
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {
            return;
        }

        // 将rank小的添加到rank大
        if (rank[pId] > rank[qId]) {
            parent[qId] = pId;
        } else if (rank[pId] < rank[qId]) {
            parent[pId] = qId;
        } else {
            parent[pId] = qId;
            rank[qId]++;
        }
    }

    public static void main(String[] args) {
        int[][] test1 = {
                {1, 2},
                {1, 3},
                {2, 3},
        };
        int[][] test2 = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 4},
                {1, 5},
        };
        Solution1 solution = new Solution1();
        System.out.println(Arrays.toString(solution.findRedundantConnection(test2)));
    }
}
