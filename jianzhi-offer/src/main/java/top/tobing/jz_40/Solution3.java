package top.tobing.jz_40;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

/**
 * @author tobing
 * @date 2021/9/4 11:56
 * @description 剑指 Offer 40. 最小的k个数
 */
public class Solution3 {

    private Random random;

    /**
     * 快排思想
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[0];
        }
        if (k == arr.length) {
            return arr;
        }
        random = new Random(System.currentTimeMillis());
        return helper(arr, 0, arr.length - 1, k);
    }

    private int[] helper(int[] arr, int left, int right, int k) {
        int segment = partition(arr, left, right);
        if (segment == k) {
            return Arrays.copyOf(arr, k);
        }
        // 根据切分的下标，决定继续切分哪一部分
        if (segment > k) {
            return helper(arr, left, segment - 1, k);
        } else {
            return helper(arr, segment + 1, right, k);
        }
    }

    /**
     * 快排分切函数
     * 在arr[left, right]范围内随着选择一个元素（选基点）
     * 根据基点将数组划分为：小于基点部分 基点 大于基点部分
     * 返回分切之后基点所在下标
     */
    private int partition(int[] arr, int left, int right) {

        // 选取基准点
        // int pivot = arr[left];
        int pivotIdx = random.nextInt(right - left + 1) + left;
        int pivot = arr[pivotIdx];
        swap(arr, left, pivotIdx);
        int segment = left;
        /**
         *
         * 从左往右遍历，维护：
         *  -----------------------------------
         * |根节点|小于根节点|大于根节点|未遍历数据|
         * -----------------------------------
         *          segment          i
         * segment用于分给小于根节点与大于根节点两部分，保存了小于根节点部分的右区间
         * 如果遍历的元素比根节点大，无需处理直接下一个；
         * 如果遍历的元素比根节点小，将元素segment交换，由于segment保存大于根节点元素，因此交换之后，并没有改变上述条件
         */
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] > pivot) {
                // 无需处理
            } else {
                // 维护segment
                segment++;
                // 交换segment与i位置的元素
                swap(arr, i, segment);
            }
        }
        swap(arr, segment, left);
        return segment;
    }

    /**
     * 交换数组arr[a] 与 arr[b]的两个元素
     * 由于private，因此该方法会被内联优化，无需考虑函数入栈出栈的性能问题，应该考虑代码可读性问题
     */
    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] arr = {6, 5, 4, 3, 2, 1};
        int[] arr1 = {0, 1, 2, 1};
        int[] leastNumbers = solution.getLeastNumbers(arr, 5);

        System.out.println(Arrays.toString(leastNumbers));
    }
}
