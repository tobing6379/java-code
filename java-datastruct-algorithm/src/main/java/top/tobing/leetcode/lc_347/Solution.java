package top.tobing.leetcode.lc_347;

import top.tobing.datastruct.tree.heap.PriorityQueue;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/9/5 22:34
 * @description 347. 前 K 个高频元素
 * 解法1：计数法
 */
public class Solution {


    private int[] count;
    private int[] data;
    private int size;


    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        if (k == nums.length) {
            return nums;
        }

        count = new int[k + 2];
        data = new int[k + 1];
        int[] res = new int[k];
        size = 0;
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                add(i);
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = removeMax();
        }
        return res;
    }

    public void add(int i) {
        data[size] = i;
        size++;
        siftUp(size);
    }

    public int getMax() {
        return data[0];
    }

    public int removeMax() {
        int ret = data[0];
        swap(0, size - 1);
        data[size - 1] = 0;
        size--;
        siftDown(0);
        return ret;
    }

    /**
     * 获取当前下标所在节点的父节点在数组中的下标
     */
    private int parent(int k) {
        return (k - 1) >>> 1;
    }

    /**
     * 获取当前下标所在节点的左子节点在数组中的下标
     */
    private int leftChild(int k) {
        return (k << 1) + 1;
    }

    /**
     * 获取当前下标所在节点的右子节点在数组中的下标
     */
    private int rightChild(int k) {
        return (k << 1) + 2;
    }

    /**
     * 上浮
     */
    private void siftUp(int k) {
        // k大于0且当前频数大于父节点频数
        while (parent(k) > 0 && count[parent(k)] < count[k]) {
            swap(parent(k), k);
            k = parent(k);
        }
    }

    /**
     * 下沉
     */
    private void siftDown(int k) {
        // 从左右孩子中选择一个较大的元素进行上浮
        while (leftChild(k) < size) {
            int left = leftChild(k);
            if (left + 1 < size && count[left + 1] > count[left]) {
                left++;
            }
            if (count[left] < count[k]) {
                break;
            }
            swap(k, left);
            k = left;
        }
    }

    /**
     * 交换data[a]与data[b]
     */
    private void swap(int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(ints));
    }
}
