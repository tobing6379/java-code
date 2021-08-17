package top.tobing.datastruct.linear.stack;

/**
 * @author tobing
 * @date 2021/8/17 10:11
 * @description 队列
 */
public interface Stack<E> {
    /**
     * 获取栈中元素个数
     */
    int getSize();

    /**
     * 判断一个栈是否为空
     */
    boolean isEmpty();

    /**
     * 将元素压栈
     */
    void push(E e);

    /**
     * 将栈顶元素出栈
     */
    E pop();

    /**
     * 获取栈顶元素
     */
    E peek();
}
