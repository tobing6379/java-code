package top.tobing.datastruct.linear.stack;

import top.tobing.datastruct.linear.array.Array;

/**
 * @author tobing
 * @date 2021/8/17 8:56
 * @description 数组栈
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> data;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacity) {
        this.data = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E pop() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty.");
        }
        E ret = data.removeLast();
        return ret;
    }

    @Override
    public E peek() {
        return data.get(data.getSize() - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < data.getSize(); i++) {
            res.append(data.get(i));
            if (i != data.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
