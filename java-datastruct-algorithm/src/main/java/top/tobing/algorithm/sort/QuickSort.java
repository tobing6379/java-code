package top.tobing.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author tobing
 * @date 2021/9/3 13:12
 * @description 快排
 * 经典快排-非稳定版
 */
public class QuickSort<T extends Comparable> {

    private Random random;

    public QuickSort() {
        this.random = new Random(System.currentTimeMillis());
    }

    private void sort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private void sort(T[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = pivot(arr, start, end);
        sort(arr, start, pivot - 1);
        sort(arr, pivot + 1, end);
    }

    private int pivot(T[] arr, int start, int end) {
        int pivotIdx = random.nextInt(end - start) + start;
        swap(arr, start, pivotIdx);
        T pivot = arr[start];

        int segment = start;
        for (int i = start; i <= end; i++) {
            if (arr[i].compareTo(pivot) < 0) {
                segment++;
                swap(arr, i, segment);
            }
        }

        swap(arr, segment, start);

        return segment;
    }

    private void swap(T[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        T tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        Couple[] test = {
                new Couple(2, 1),
                new Couple(1, 2),
                new Couple(3, 3),
                new Couple(5, 4),
                new Couple(6, 5),
                new Couple(7, 6),
                new Couple(3, 7),
                new Couple(4, 8),
                new Couple(3, 9)
        };
        System.out.println(Arrays.toString(test));
        QuickSort quickSort = new QuickSort();
        quickSort.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
