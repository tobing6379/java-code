package principal.single_responsibility.restruct;

import principal.single_responsibility.old.AlertRule;
import principal.single_responsibility.old.Notification;
import principal.single_responsibility.old.NotificationEmergencyLevel;

/**
 * @Author tobing
 * @Date 2021/8/3 18:43
 * @Description TPS告警处理
 */
public class TpsAlertHandler extends AlertHandler {
    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if (tps > rule.getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "TPS超出阈值");
        }
    }
}
