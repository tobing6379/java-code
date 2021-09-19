package top.tobing.algorithm.sort;

import top.tobing.datastruct.tree.heap.MaxHeap;

/**
 * @author tobing
 * @date 2021/9/18 15:25
 * @description 堆排序
 * 堆排序主要分为两步：
 * 1、将数组堆化
 * 2、从堆中不断取出最大值放到数组最后一个位置，然后长度减一
 */
public class HeapSort {
    private int[] arr;

    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        int len = arr.length - 1;
        int beginIdx = (arr.length >> 1) - 1;
        // 第一步：将数组堆化
        // 从第一个非叶子节点(beginIdx)开始，不断堆化
        // 将叶子节点看做以及符合堆要求的节点
        // |非叶子节点|叶子节点|
        for (int i = beginIdx; i >= 0; i--) {
            maxHeapify(i, len);
        }

        // 第二步：将堆化的数据排序
        // 每次取出顶层元素（最大值），与尾部元素调整位置
        // 同时需要将遍历的数组长度减一
        // 由于尾部元素已经与堆顶元素交换，因此需要将堆顶元素重新堆化
        for (int i = len; i > 0; i--) {
            swap(0, i);
            maxHeapify(0, i - 1);
        }
    }


    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 将下标为idx的元素堆化
     * 【自上而下堆化】，详情看{@link MaxHeap#siftDown(int)}
     */
    private void maxHeapify(int idx, int len) {
        // 计算左右孩节点
        int leftChildIdx = (idx << 1) + 1;
        int rightChildIdx = leftChildIdx + 1;
        int cMax = leftChildIdx;
        // 判断左孩子是否存在，不存在直接返回
        if (leftChildIdx > len) {
            return;
        }
        // 右孩子存在，且右孩子大于左孩子，直接赋值为右孩子
        if (rightChildIdx <= len && arr[rightChildIdx] > arr[leftChildIdx]) {
            cMax = rightChildIdx;
        }
        // 如果左右孩子中存在比当前节点要大的节点，直接交换两个节点，继续堆化
        if (arr[cMax] > arr[idx]) {
            swap(cMax, idx);
            maxHeapify(cMax, len);
        }
    }
}
