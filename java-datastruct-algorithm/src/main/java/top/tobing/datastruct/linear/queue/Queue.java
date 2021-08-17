package top.tobing.datastruct.linear.queue;

/**
 * @author tobing
 * @date 2021/8/17 8:57
 * @description 队列接口
 */
public interface Queue<E> {
    /**
     * 获取队列元素大小
     */
    int getSize();

    /**
     * 队列是否为空
     */
    boolean isEmpty();

    /**
     * 入队
     */
    void enqueue(E e);

    /**
     * 元素出队
     */
    E dequeue();

    /**
     * 获取队首元素
     */
    E getFront();

}
