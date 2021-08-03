package principal.single_responsibility.restruct;

import principal.single_responsibility.old.AlertRule;
import principal.single_responsibility.old.Notification;
import principal.single_responsibility.old.NotificationEmergencyLevel;

/**
 * @Author tobing
 * @Date 2021/8/3 18:43
 * @Description 错误告警处理
 */
public class ErrorAlertHandler extends AlertHandler {
    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.SERVER, "错误告警超出阈值");
        }
    }
}
