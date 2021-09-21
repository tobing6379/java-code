package top.tobing.jz_59_i;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author tobing
 * @date 2021/9/21 11:09
 * @description 剑指 Offer 59 - I. 滑动窗口的最大值
 */
public class Solution1 {


    /**
     * 最大堆
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return nums;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i, j) -> j - i);
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }

        int[] res = new int[nums.length - k + 1];
        res[0] = maxHeap.peek();
        for (int i = 1; i < res.length; i++) {
            maxHeap.remove(nums[i - 1]);
            maxHeap.add(nums[i + k - 1]);
            res[i] = maxHeap.peek();
        }

        return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] test = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = solution.maxSlidingWindow(test, 3);
        System.out.println(Arrays.toString(ints));
    }
}
