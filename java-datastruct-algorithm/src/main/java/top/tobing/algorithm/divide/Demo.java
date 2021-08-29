package top.tobing.algorithm.divide;

/**
 * @author tobing
 * @date 2021/8/28 12:21
 * @description 分治算法典型示例
 */
public class Demo {
    /**
     * 逆序对个数
     */
    private int count = 0;

    public int count(int[] arr) {
        count = 0;
        mergeSortCount(arr, 0, arr.length - 1);
        return count;
    }

    private void mergeSortCount(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortCount(arr, start, mid);
        mergeSortCount(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] tmp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
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
        for (i = 0; i < end - start; ++i) {
            arr[start + i] = tmp[i];
        }
    }


}
