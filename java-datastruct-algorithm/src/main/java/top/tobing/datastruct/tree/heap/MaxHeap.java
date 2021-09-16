package top.tobing.datastruct.tree.heap;

import top.tobing.datastruct.linear.array.Array;

/**
 * @author tobing
 * @date 2021/9/4 23:36
 * @description
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        if (arr.length != 1) {
            // 从后倒数第二层开始，往前进行siftDown操作（最后一层无需进行siftDown，因为无子节点）
            for (int i = parent(arr.length - 1); i >= 0; i--) {
                siftDown(i);
            }
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引代表的元素的父节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引代表的元素的左孩子的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引代表的元素的右孩子的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 添加元素到大根堆中
     */
    public void add(E e) {
        data.addLast(e);
        // 添加元素之后，需要维护大根堆的状态。
        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮
     * 对于大根堆，需要维护父节点比
     */
    private void siftUp(int k) {
        // 如果添加的元素比其父节点还要小，将父节点与当前节点；继续与器父节点比较，直到当前节点比父节点小或已经是根节点
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 查看堆中的最大元素
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 取出堆中的最大值
     */
    public E extractMax() {
        // 获取最大值的用于返回
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    /**
     * 下浮
     * 当要给元素添加到堆顶，需要维护堆的属性
     */
    private void siftDown(int k) {

        while (leftChild(k) < data.getSize()) {
            // 左孩子索引
            int j = leftChild(k);
            // （j+1）是右孩子索引
            if (j + 1 < data.getSize() // 判断是否存在右孩子
                    && data.get(j + 1).compareTo(data.get(j)) > 0) { // 判断右孩子是否大于右孩子
                j++;
            }

            // 如果当前元素大于或等于孩子节点了，无需处理，直接退出
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 将堆顶元素替换为元素e
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
