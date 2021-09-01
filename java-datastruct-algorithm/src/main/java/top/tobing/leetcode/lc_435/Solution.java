package top.tobing.leetcode.lc_435;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobing
 * @date 2021/8/27 16:42
 * @description 435. 无重叠区间
 * 运用贪心算法
 */
public class Solution {
    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new Interval(interval[0], interval[1]));
        }
        list.sort((o1, o2) -> o1.end - o2.end);
        System.out.println("==================>");
        for (Interval interval : list) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }

        int res = 0;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).start >= end) {
                res++;
                end = list.get(i).end;
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
        Solution solution = new Solution();
        System.out.println(solution.eraseOverlapIntervals(res));
    }
}
