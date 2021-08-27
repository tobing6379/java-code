package top.tobing.algorithm.heap.lc_295;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author tobing
 * @date 2021/8/27 22:54
 * @description 295. 数据流的中位数
 */
public class Solution {
}

class MedianFinder {

    /**
     * 【大顶堆】
     * 当n为奇数，大顶堆储存n/2+1个元素，并且中位数为大顶堆堆顶元素
     */
    private PriorityQueue<Integer> maxHeap;
    /**
     * 【小顶堆】
     * 当n为偶数，待定对储存n/2个元素，小顶堆储存n/2个元素，两者堆顶元素平均值为中位数
     */
    private PriorityQueue<Integer> minHeap;


    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.size() == 0 && minHeap.size() == 0) {
            maxHeap.add(num);
            return;
        }
        if (maxHeap.size() == minHeap.size()) {
            if (num < maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            }
        } else {
            if (num < maxHeap.peek()) {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            } else {
                minHeap.add(num);
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return 1.0 * (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}