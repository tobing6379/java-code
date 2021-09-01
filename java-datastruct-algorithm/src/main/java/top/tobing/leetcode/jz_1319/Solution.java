package top.tobing.leetcode.jz_1319;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tobing
 * @date 2021/9/1 23:23
 * @description 1319. 连通网络的操作次数
 * 解法1-并查集QuickFind 1674ms
 */
public class Solution {

    private int[] ids;

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
        ids = new int[n];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
        // 更新并查集
        for (int[] connection : connections) {
            int p = connection[0];
            int q = connection[1];
            union(p, q);
        }
        // 计算独立区间个数
        Set<Integer> set = new HashSet<>();
        for (int id : ids) {
            set.add(id);
        }
        return set.size() - 1;
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
        Solution solution = new Solution();
        System.out.println(solution.makeConnected(5, test));
    }
}
