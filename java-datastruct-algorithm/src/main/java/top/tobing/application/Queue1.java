package top.tobing.application;

/**
 * @author tobing
 * @date 2021/9/25 23:29
 * @description 循环队列-生产者-消费者模型【无锁】
 * 当队列满了，生产者就轮询等待；
 * 当队列空了，消费者就轮询等待；
 */
public class Queue1 {
    private long[] data;
    private int size;
    private int head;
    private int tail;

    public Queue1(int size) {
        this.size = size;
        data = new long[size + 1];
        head = 0;
        tail = 0;
    }

    /**
     * 添加元素
     */
    public synchronized boolean add(long element) {
        // 判断循环队列是否已满
        if ((tail + 1) % size == head) {
            return false;
        }
        data[tail] = element;
        tail = (tail + 1) % size;
        return true;
    }

    /**
     * 删除元素
     */
    public synchronized long poll() {
        // 队列为空
        if (head == tail) {
            return -1;
        }
        long ret = data[head];
        head = (head + 1) % size;
        return ret;
    }


    class Producer {
        private Queue1 queue;

        public Producer(Queue1 queue) {
            this.queue = queue;
        }

        public void produce(long data) throws InterruptedException {
            while (!queue.add(data)) {
                Thread.sleep(100);
            }
        }
    }

    class Consumer {
        private Queue1 queue;

        public Consumer(Queue1 queue) {
            this.queue = queue;
        }

        public void consume() throws InterruptedException {
            long data = queue.poll();
            if (data == -1) {
                Thread.sleep(100);
            } else {
                // TODO 消费数据
            }
        }
    }

}
