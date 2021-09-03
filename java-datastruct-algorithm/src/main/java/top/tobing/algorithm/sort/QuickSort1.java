package top.tobing.algorithm.sort;


import java.util.*;

/**
 * @author tobing
 * @date 2021/9/3 13:12
 * @description 快排
 * 稳定版快排
 */
public class QuickSort1<T extends Comparable> {

    private Random random;


    public void sort(T[] arr) {
        // 无需排序
        if (arr == null || arr.length <= 1) {
            return;
        }
        random = new Random();
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

        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (arr[i].compareTo(arr[pivotIdx]) > 0) {
                right.add(arr[i]);
            } else if (arr[i].compareTo(arr[pivotIdx]) < 0) {
                left.add(arr[i]);
            } else {
                if (i < pivotIdx) {
                    left.add(arr[i]);
                } else if (i > pivotIdx) {
                    right.add(arr[i]);
                }
            }
        }
        left.add(arr[pivotIdx]);
        int idx = start;
        for (T tmp : left) {
            arr[idx++] = tmp;
        }
        for (T tmp : right) {
            arr[idx++] = tmp;
        }
        return start + left.size() - 1;
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
        QuickSort1 quickSort1 = new QuickSort1();
        quickSort1.sort(test);
        System.out.println(Arrays.toString(test));
    }


}

