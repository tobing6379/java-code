package principal.single_responsibility.old;

import principal.single_responsibility.restruct.ApplicationContext;

/**
 * @Author tobing
 * @Date 2021/8/3 18:19
 * @Description API 接口监控告警
 * 开闭原则
 * 添加一个新的功能应该是，在已有代码基础上扩展代码（新增模块、类、方法等），而非修改已有代码（修改模块、类、方法等）
 */
public class Alert {
    private AlertRule rule;
    private Notification notification;

    public Alert(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }


    /**
     * 当接口的 TPS 超过某个预先设置的最大值时，以及当接口请求出错数大于某个最大允许值时，<br>
     * 就会触发告警，通知接口的相关负责人或者团队。<br>
     * 添加一个功能，当每秒钟接口超时请求个数，超过某个预先设置的最大阈值时，我们也要触发告警发送通知。<br>
     * 为了添加上面的功能，需要修改两个地方{@link Alert#checkNew(String, long, long, long, long)}</br>
     * 这样一来。</br>
     * 一方面，我们对接口进行了修改，这就意味着调用这个接口的代码都要做相应的修改。</br>
     * 另一方面，修改了 check() 函数，相应的单元测试都需要修改
     * 可以在添加代码的时候，是基于修改来实现的，违反了「开闭原则」，为了遵循「开闭原则」对Alert进行重构，主要包含两部分内容
     * 1）将check()函数多个入参封装为ApiStatInfo
     * 2）引入handler概念，将if判断逻辑分散到各个handler中
     * 具体见重构之后的类{@link principal.single_responsibility.restruct.Alert}
     * 重构的使用{@link ApplicationContext}
     *
     * @param api               对应的api接口
     * @param requestCount      请求数量
     * @param errorCount        异常请求数量
     * @param durationOfSeconds 持续时间
     */
    @Deprecated
    public void check(String api, long requestCount, long errorCount, long durationOfSeconds) {
        long tps = requestCount / durationOfSeconds;
        if (tps > rule.getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "TPS超出阈值");
        }

        if (errorCount > rule.getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.SERVER, "异常计数超出阈值");
        }

    }

    /**
     * @param timeout 第一处修改，添加了参数
     */
    public void checkNew(String api, long requestCount, long errorCount, long timeout, long durationOfSeconds) {
        long tps = requestCount / durationOfSeconds;
        if (tps > rule.getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "TPS超出阈值");
        }

        if (errorCount > rule.getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.SERVER, "异常计数超出阈值");
        }

        // 第二处修改
        if (timeout > rule.getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "超时技术超出阈值");
        }
    }
}
