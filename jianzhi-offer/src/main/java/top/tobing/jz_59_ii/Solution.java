package top.tobing.jz_59_ii;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tobing
 * @date 2021/9/22 8:49
 * @description 剑指 Offer 59 - II. 队列的最大值
 */
public class Solution {
    /**
     * "MaxQueue","max_value","pop_front","max_value","push_back","max_value","pop_front","max_value","pop_front",
     * "push_back","pop_front","pop_front","pop_front","push_back","pop_front","max_value","pop_front","max_value",
     * "push_back","push_back","max_value","push_back","max_value","max_value","max_value","push_back","pop_front",
     * "max_value","push_back","max_value","max_value","max_value","pop_front","push_back","push_back","push_back",
     * "push_back","pop_front","pop_front","max_value","pop_front","pop_front","max_value","push_back","push_back",
     * "pop_front","push_back","push_back","push_back","push_back","pop_front","max_value","push_back","max_value",
     * "max_value","pop_front","max_value","max_value","max_value","push_back","pop_front","push_back","pop_front",
     * "max_value","max_value","max_value","push_back","pop_front","push_back","push_back","push_back","pop_front",
     * "max_value","pop_front","max_value","max_value","max_value","pop_front","push_back","pop_front","push_back",
     * "push_back","pop_front","push_back","pop_front","push_back","pop_front","pop_front","push_back","pop_front",
     * "pop_front","pop_front","push_back","push_back","max_value","push_back","pop_front","push_back","push_back","pop_front"]
     * [[],[],[],[],[46],[],[],[],[],[868],[],[],[],[525],[],[],[],[],[123],[646],[],[229],[],[],[],[871],[],[],[285],
     * [],[],[],[],[45],[140],[837],[545],[],[],[],[],[],[],[561],[237],[],[633],[98],[806],[717],[],[],[186],[],[],[],
     * [],[],[],[268],[],[29],[],[],[],[],[866],[],[239],[3],[850],[],[],[],[],[],[],[],[310],[],[674],[770],[],[525],[],
     * [425],[],[],[720],[],[],[],[373],[411],[],[831],[],[765],[701],[]]
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] operations = {
                "MaxQueue", "max_value", "pop_front", "max_value", "push_back", "max_value", "pop_front", "max_value", "pop_front",
                "push_back", "pop_front", "pop_front", "pop_front", "push_back", "pop_front", "max_value", "pop_front", "max_value",
                "push_back", "push_back", "max_value", "push_back", "max_value", "max_value", "max_value", "push_back", "pop_front",
                "max_value", "push_back", "max_value", "max_value", "max_value", "pop_front", "push_back", "push_back", "push_back",
                "push_back", "pop_front", "pop_front", "max_value", "pop_front", "pop_front", "max_value", "push_back", "push_back",
                "pop_front", "push_back", "push_back", "push_back", "push_back", "pop_front", "max_value", "push_back", "max_value",
                "max_value", "pop_front", "max_value", "max_value", "max_value", "push_back", "pop_front", "push_back", "pop_front",
                "max_value", "max_value", "max_value", "push_back", "pop_front", "push_back", "push_back", "push_back", "pop_front",
                "max_value", "pop_front", "max_value", "max_value", "max_value", "pop_front", "push_back", "pop_front", "push_back",
                "push_back", "pop_front", "push_back", "pop_front", "push_back", "pop_front", "pop_front", "push_back", "pop_front",
                "pop_front", "pop_front", "push_back", "push_back", "max_value", "push_back", "pop_front", "push_back", "push_back", "pop_front"
        };
        int[][] vals = {
                {}, {}, {}, {}, {46}, {}, {}, {}, {}, {868}, {}, {}, {}, {525}, {}, {}, {}, {}, {123}, {646}, {}, {229}, {}, {}, {}, {871}, {}, {}, {285},
                {}, {}, {}, {}, {45}, {140}, {837}, {545}, {}, {}, {}, {}, {}, {}, {561}, {237}, {}, {633}, {98}, {806}, {717}, {}, {}, {186}, {}, {}, {},
                {}, {}, {}, {268}, {}, {29}, {}, {}, {}, {}, {866}, {}, {239}, {3}, {850}, {}, {}, {}, {}, {}, {}, {}, {310}, {}, {674}, {770}, {}, {525}, {},
                {425}, {}, {}, {720}, {}, {}, {}, {373}, {411}, {}, {831}, {}, {765}, {701}, {}};
        MaxQueue maxQueue = new MaxQueue();
        for (int i = 0; i < operations.length; i++) {
            System.out.println(operations[i] + ":" + Arrays.toString(vals[i]));
            if ("max_value".equals(operations[i])) {
                System.out.println(maxQueue.max_value());
            } else if ("pop_front".equals(operations[i])) {
                System.out.println(maxQueue.pop_front());

            } else if ("push_back".equals(operations[i])) {
                maxQueue.push_back(vals[i][0]);
            }
        }
//        maxQueue.push_back(1);
//        maxQueue.push_back(2);
//        System.out.println(maxQueue.max_value());
//        System.out.println(maxQueue.pop_front());
//        System.out.println(maxQueue.max_value());
    }
}

class MaxQueue {

    private LinkedList<Integer> maxQueue;
    private Queue<Integer> realQueue;

    public MaxQueue() {
        maxQueue = new LinkedList<>();
        realQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.getLast();
    }

    public void push_back(int value) {
        realQueue.add(value);
        while (!maxQueue.isEmpty() && maxQueue.getLast() < value) {
            maxQueue.removeLast();
        }
        maxQueue.addLast(value);
        realQueue.add(value);
    }

    public int pop_front() {
        if (realQueue.isEmpty()) {
            return -1;
        }
        Integer ret = realQueue.remove();
        if (ret.equals(maxQueue.getFirst())) {
            maxQueue.removeFirst();
        }

        return ret;
    }
}
