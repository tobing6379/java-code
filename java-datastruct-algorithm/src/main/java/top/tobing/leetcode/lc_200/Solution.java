package top.tobing.leetcode.lc_200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author tobing
 * @date 2021/9/6 17:22
 * @description 200. 岛屿数量
 * 解法1：并查集QuickUnion
 */
public class Solution {

    private int[] parent;
    private int[] rank;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rowLen = grid.length;
        int colLen = grid[0].length;
        parent = new int[rowLen * colLen];
        rank = new int[rowLen * colLen];
        int unLand = 0;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1') {
                    int cur = i * colLen + j;
//                    // 上
//                    if (i > 0 && grid[i - 1][j] == '1') {
//                        int curUp = (i - 1) * colLen + j;
//                        union(cur, curUp);
//                    }
                    // 下
                    if (i < rowLen - 1 && grid[i + 1][j] == '1') {
                        int curDown = (i + 1) * colLen + j;
                        union(cur, curDown);
                    }
//                    // 左
//                    if (j > 0 && grid[i][j - 1] == '1') {
//                        int curLeft = i * colLen + (j - 1);
//                        union(cur, curLeft);
//                    }
                    // 右
                    if (j < colLen - 1 && grid[i][j + 1] == '1') {
                        int curRight = i * colLen + (j + 1);
                        union(cur, curRight);
                    }
                } else {
                    unLand++;
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            set.add(find(parent[i]));
        }
        return set.size() - unLand;
    }

    private int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private void union(int p, int q) {
        if (p < 0 || p >= parent.length || q < 0 || q >= parent.length) {
            return;
        }
        int pId = find(p);
        int qId = find(q);

        if (qId == pId) {
            return;
        }

        // 将rank低的添加到rank的接单中
        if (rank[p] > rank[q]) {
            parent[qId] = pId;
        } else if (rank[p] < rank[q]) {
            parent[pId] = qId;
        } else {
            parent[pId] = qId;
            rank[qId]++;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        System.out.println(solution.numIslands(grid));
    }
}
