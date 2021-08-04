package top.tobing.jz_09;

import java.util.Stack;

/**
 * @Author tobing
 * @Date 2021/8/4 16:52
 * @Description 剑指 Offer 09. 用两个栈实现队列
 */
public class CQueue {

    /**
     * 专门用于入对
     */
    private Stack<Integer> in;
    /**
     * 专门用于出队
     */
    private Stack<Integer> out;

    public CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /**
     * 入队
     */
    public void appendTail(int value) {
        // 往in添加元素是，需要确保out的元素是空的
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
        in.push(value);
    }

    /**
     * 出队
     */
    public int deleteHead() {
        // 往out删除元素时，需要去确保in的元素是空的
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        return out.isEmpty() ? -1 : out.pop();
    }
}
