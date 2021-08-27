package top.tobing.algorithm.greedy.lc_56;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/8/27 22:03
 * @description 56. 合并区间 todo
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            // 当前区间比上一个区间
            if (interval[0] < end) {
                end = interval[1];
                start = Math.min(start, interval[0]);
            }
        }
        int[] res = new int[2];
        res[0] = start;
        res[1] = end;
        return new int[][]{res};
    }
}
