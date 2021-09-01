package top.tobing.leetcode.jz_1319;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tobing
 * @date 2021/9/1 23:23
 * @description 1319. 连通网络的操作次数
 * 解法1-并查集QuickUnion 3ms
 */
public class Solution1 {

    private int[] parent;
    private int[] rank;

    public int makeConnected(int n, int[][] connections) {
        if (connections == null || connections.length == 0 || connections[0].length == 0) {
            return 0;
        }
        // 线缆不足
        if (connections.length < n - 1) {
            return -1;
        }

        // 计算线缆
        // 初始化并查集结构
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        // 更新并查集
        for (int[] connection : connections) {
            int p = connection[0];
            int q = connection[1];
            union(p, q);
        }
        // 计算独立区间个数
        return count() - 1;
    }

    private int find(int p) {
        if (p < 0 || p > parent.length) {
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

        // rank小的添加到rank大的
        if (rank[pId] > rank[qId]) {
            parent[qId] = pId;
        } else if (rank[pId] < rank[qId]) {
            parent[pId] = qId;
        } else {
            parent[pId] = qId;
            rank[qId]++;
        }
    }

    private int count() {
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] test = {
                {0, 1},
                {0, 2},
//                {0, 3},
//                {1, 2},
//                {1, 3},
                {2, 3},
                {3, 4}
        };
        int[][] test2 = {
                {0, 1},
                {0, 2},
                {3, 4},
                {2, 3},
        };
        Solution1 solution = new Solution1();
        System.out.println(solution.makeConnected(5, test));
    }
}
