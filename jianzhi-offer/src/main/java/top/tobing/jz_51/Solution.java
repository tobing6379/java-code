package top.tobing.jz_51;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/8/28 12:55
 * @description 剑指 Offer 51. 数组中的逆序对
 */
public class Solution {

    /**
     * 逆序对对数
     */
    private int count;


    /**
     * 归并排序法
     */
    public int reversePairs(int[] nums) {
        count = 0;
        mergeSortCount(nums, 0, nums.length - 1);
        return count;
    }

    /**
     * 排序，并借助排序统计逆序对个数
     */
    private void mergeSortCount(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSortCount(arr, start, mid);
        mergeSortCount(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    /**
     * 合并逆序对
     */
    private void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] tmp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                // 累加逆序对
                count += (mid - i + 1);
                tmp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= end) {
            tmp[k++] = arr[j++];
        }

        for (int l = 0; l < end - start + 1; l++) {
            arr[start + l] = tmp[l];
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 4};
        int res = new Solution().reversePairs(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);
    }
}
