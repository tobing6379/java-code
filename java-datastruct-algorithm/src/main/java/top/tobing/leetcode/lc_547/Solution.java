package top.tobing.leetcode.lc_547;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tobing
 * @date 2021/8/31 23:55
 * @description 547. 省份数量
 */
public class Solution {

    private int[] id;

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        // 初始化id
        id = new int[isConnected.length];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        // 遍历矩阵的左下三角形即可
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        // 使用set统计id的不重复元素个数
        Set<Integer> set = new HashSet<>();
        for (int i : id) {
            set.add(i);
        }
        return set.size();
    }

    private void union(int p, int q) {
        if (id[p] == id[q]) {
            return;
        }
        int tempA = id[p];
        int tempB = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == tempA) {
                id[i] = tempB;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
        };
        Solution solution = new Solution();
        solution.findCircleNum(arr);

    }

}
