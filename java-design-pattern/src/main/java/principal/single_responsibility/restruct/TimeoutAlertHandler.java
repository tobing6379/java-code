package principal.single_responsibility.restruct;

import principal.single_responsibility.old.AlertRule;
import principal.single_responsibility.old.Notification;
import principal.single_responsibility.old.NotificationEmergencyLevel;

/**
 * @Author tobing
 * @Date 2021/8/3 18:43
 * @Description 超时告警处理
 */
public class TimeoutAlertHandler extends AlertHandler {
    public TimeoutAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.SERVER, "错误告警超出阈值");
        }
    }
}
