package top.tobing.datastruct.linear.queue;


import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/8/17 9:10
 * @description 循环队列
 * tail（删除元素）               队尾（添加元素）
 * -----------------------------------------
 * |    |    |    |    |    |    |    |    |
 * -----------------------------------------
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        // 留一位用于判断是否队列是否已满
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        // 队列已经满了
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        E ret = data[front];
        // 置空，便于GC
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue: size = %d , capacity = %d\n", size, data.length - 1));
        builder.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            builder.append(data[i]);
            if (i + 1 % data.length != tail) {
                builder.append(", ");
            }
        }
        builder.append(" ] tail");
        return builder.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        int idx = 0;
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            newData[idx++] = data[i];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    private int getCapacity() {
        return this.data.length - 1;
    }


    public static void main(String[] args) {

        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 20; i++) {
            if (i == 10) {
                System.out.println("test");
            }
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
