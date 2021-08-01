package design_pattern.singleton;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @Author tobing
 * @Date 2021/8/1 14:21
 * @Description 单例
 * DCL
 */
public class SingletonDemo05 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                50,
                50,
                1000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10));
        for (int i = 0; i < 20; i++) {
            CompletableFuture.runAsync(() -> {
                Singleton05 instance = Singleton05.getInstance();
                System.out.println(instance);
            }, poolExecutor);
        }
    }
}

class Singleton05 {

    private Singleton05() {
    }

    /**
     * 为什么要加上volatile？
     * 处于性能考虑，CPU编译、编译器编译会存在「指令重排序」的优化
     * 而对于 new Singleton05 这个过程，并不是原子性的，主要分为以下是三个过程：
     * 1、申请对象空间
     * 2、初始化内存空间
     * 3、将分配好的内存空间地址赋值给instance
     * 由于指令重排序的存在，可以的执行顺序如下
     * 1、申请对象空间
     * 2、将分配好的内存空间地址赋值给instance
     * 3、初始化内存空间
     * 显然，在串行执行的时候，上面的代码时没有问题，CPU在执行重排序时，只保证串行执行的正确性。
     * 在并发环境下，由于先会给instance分配对象地址引用，此时分配的地址空间可能还没初始化完成。
     * 此时如果另一个线程来尝试判断instance是否为null，而此时instance不为null，
     * 但是还未初始化成功，就直接拿到instance，直接操作这篇内存空间，这将可能导致产生不可预测的危险
     * 《深入理解JVM虚拟机》2.3.1对象的创建
     * ①在类加载检查通过后， 接下来虚拟机将为新生对象分配内存。...
     * 为对象分配空间的任务实际上便等同于把一块确定大小的内存块从Java堆中划分出来。
     * ②内存分配完成之后， 虚拟机必须将分配到的内存空间（但不包括对象头） 都初始化为零值，
     * 如果使用了TLAB的话， 这一项工作也可以提前至TLAB分配时顺便进行。
     * 当上面的工作完成，从虚拟机的视角来看，一个新的对象已经产生了。
     * ③将对象的内存地址分配给instance。
     */
    private static Singleton05 instance;

    static {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Singleton05 getInstance() {
        if (instance == null) {
            synchronized (Singleton05.class) {
                // 为什么使用两次校验，这里很容易理解，有可能同时多个线程来到同步块外面
                // 同步块外面的线程会依次进入同步块之中，如果在同步块内部不加判断，将无法保证单例
                if (instance == null) {
                    instance = new Singleton05();
                }
            }
        }
        return instance;
    }
}
