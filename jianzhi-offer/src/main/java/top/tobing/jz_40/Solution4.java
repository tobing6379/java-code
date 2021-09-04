package top.tobing.jz_40;

import java.util.Arrays;
import java.util.Random;

/**
 * @author tobing
 * @date 2021/9/4 11:56
 * @description 剑指 Offer 40. 最小的k个数
 */
public class Solution4 {


    /**
     * 计数排序
     * 由于元素范围有限，直接计数排序
     * 0 <= arr[i] <= 10000
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[0];
        }
        if (k == arr.length) {
            return arr;
        }

        int[] count = new int[10001];
        for (int i : arr) {
            count[i]++;
        }
        int[] res = new int[k];
        int idx = 0;
        for (int i = 0; i < count.length && idx < k; i++) {
            while (count[i] != 0 && idx < k) {
                res[idx++] = i;
                count[i]--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int[] arr = {0, 0, 1, 3, 4, 5, 0, 7, 6, 7};
        int[] arr1 = {0, 1, 2, 1};
        int[] leastNumbers = solution.getLeastNumbers(arr, 9);
        System.out.println(Arrays.toString(leastNumbers));
    }
}
