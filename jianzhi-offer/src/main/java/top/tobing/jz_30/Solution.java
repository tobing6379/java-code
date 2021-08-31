package top.tobing.jz_30;

import java.util.Stack;

/**
 * @author tobing
 * @date 2021/8/30 9:31
 * @description 剑指 Offer 30. 包含min函数的栈
 */
public class Solution {
}

class MinStack {

    /**
     * 保存元素的正常顺序
     */
    private Stack<Integer> stack;
    /**
     * 辅助栈,存储栈A中所有「非严格降序」的元素，则栈A中的最小元素始终对应栈B的栈顶元素，即 min() 函数只需返回栈B的栈顶元素即可。
     */
    private Stack<Integer> min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        Integer val = stack.pop();
        if (!min.isEmpty() && val.equals(min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}