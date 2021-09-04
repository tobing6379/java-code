package top.tobing.jz_40;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author tobing
 * @date 2021/9/4 11:56
 * @description 剑指 Offer 40. 最小的k个数
 */
public class Solution1 {


    /**
     * 最小堆
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[0];
        }
        if (k == arr.length) {
            return arr;
        }
        // 最小堆
        PriorityQueue<Integer> mimHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            mimHeap.add(arr[i]);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = mimHeap.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] arr = {6, 5, 4, 3, 2, 1};
        int[] leastNumbers = solution.getLeastNumbers(arr, 3);
        System.out.println(Arrays.toString(leastNumbers));
    }
}
