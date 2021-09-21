package top.tobing.jz_57_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobing
 * @date 2021/9/21 10:45
 * @description 剑指 Offer 57 - II. 和为s的连续正数序列
 */
public class Solution {


    /**
     * 滑动窗口
     * 1 <= target <= 10^5
     */
    public int[][] findContinuousSequence(int target) {

        int left = 1;
        int right = 2;
        int sum = 3;
        List<int[]> res = new ArrayList<>();
        while (left < right) {
            if (sum == target) {
                int[] ans = new int[right - left + 1];
                for (int k = left; k <= right; k++) {
                    ans[k - left] = k;
                }
                res.add(ans);
            }
            if (sum >= target) {
                sum -= left;
                left++;
            } else {
                right++;
                sum += right;
            }
        }
        return res.toArray(new int[0][]);
    }
}
