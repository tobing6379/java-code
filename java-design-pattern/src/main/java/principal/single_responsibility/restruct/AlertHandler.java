package principal.single_responsibility.restruct;

import principal.single_responsibility.old.AlertRule;
import principal.single_responsibility.old.Notification;

/**
 * @Author tobing
 * @Date 2021/8/3 18:39
 * @Description 告警处理类
 */
public abstract class AlertHandler {

    protected AlertRule rule;
    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    /**
     * 对 api 状态进行检查
     */
    public abstract void check(ApiStatInfo apiStatInfo);
}
