package top.tobing.jz_41;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author tobing
 * @date 2021/9/4 14:04
 * @description 剑指 Offer 41. 数据流中的中位数
 */
public class Solution {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        // ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());

        //[[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]


    }
}


/**
 * 双堆法：
 * minHeap保存后1/2元素
 * maxHeap保存前1/2元素
 */
class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        // 集合为空
        if (maxHeap.size() == 0) {
            maxHeap.add(num);
            return;
        }
        if (maxHeap.size() == minHeap.size()) {
            // 元素个数相等，优先放在maxHeap
            if (num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            }
        } else {
            // 元素个数不相等，minHeap.size=maxHeap.size-1
            if (num <= maxHeap.peek()) {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            } else {
                minHeap.add(num);
            }
        }
    }

    /**
     * 简化版
     */
    public void addNumSimplify(int num) {
        if (maxHeap.size() == minHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return 0.5 * (minHeap.peek() + maxHeap.peek());
        }
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */