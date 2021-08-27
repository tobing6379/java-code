package top.tobing.algorithm.greedy.lc_435;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author tobing
 * @date 2021/8/27 16:42
 * @description 435. 无重叠区间
 * 运用贪心算法
 */
public class Solution1 {

    /**
     * 【贪心算法】
     * 每次选择是，选择左端点不与前面重合的，并且右端点尽量小
     * 简单的思路，按照右端点从小到大排序，每次取的时候按序去，如果取出的节点左端点小于当前的右端点，即为符合点
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照end排序
        // Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int res = 0;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                res++;
                end = intervals[i][1];
            }
        }
        return intervals.length - res;
    }


    public static void main(String[] args) {
        int[][] res = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        int[][] res1 = {
                {1, 100},
                {11, 22},
                {1, 11},
                {2, 12}
        };
        Solution1 solution = new Solution1();
        System.out.println(solution.eraseOverlapIntervals(res1));
    }
}
