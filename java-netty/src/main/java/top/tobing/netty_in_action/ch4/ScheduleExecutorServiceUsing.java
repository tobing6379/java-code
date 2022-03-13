package top.tobing.netty_in_action.ch4;

import io.netty.channel.Channel;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * $ JUC & Netty Schedule ExecutorService
 *
 * @author tobing
 * @date 2022/2/15 21:22
 */
public class ScheduleExecutorServiceUsing {
    public static void main(String[] args) {
        Channel channel = null;
        // 调度在60秒之后，并且每间隔60秒运行
        io.netty.util.concurrent.ScheduledFuture<?> future = channel.eventLoop().scheduleAtFixedRate(() -> {
            System.out.println("60 秒之后");
        }, 60, 60, TimeUnit.SECONDS);


    }

    private static void jdkScheduleExecutorService() {
        // 创建一个具有10个线程的线程池
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        // 创建一个Runnable，其将在60秒之后执行
        ScheduledFuture<?> future = executor.schedule(() -> {
            System.out.println("10 秒之后");
        }, 10, TimeUnit.SECONDS);
        // 所有的调度任务完成之后，关闭ScheduledExecutorService，释放资源
        executor.shutdown();
    }
}
