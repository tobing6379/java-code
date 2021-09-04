package top.tobing.jz_40;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/9/4 11:56
 * @description 剑指 Offer 40. 最小的k个数
 */
public class Solution {


    /**
     * 排序法
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[0];
        }
        if (k == arr.length) {
            return arr;
        }

        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        return res;
    }
}
