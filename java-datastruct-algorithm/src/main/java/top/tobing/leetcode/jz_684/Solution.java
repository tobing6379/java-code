package top.tobing.leetcode.jz_684;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/9/1 22:42
 * @description 684. 冗余连接
 * 解法1：并查集QuickFind
 */
public class Solution {

    private int[] ids;

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            return new int[0];
        }

        // 初始化并查集结构
        ids = new int[edges.length];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
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

    private boolean isConnected(int p, int q) {
        return ids[p] == ids[q];
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
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findRedundantConnection(test2)));
    }
}
