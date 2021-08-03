package principal.single_responsibility.old;

/**
 * @Author tobing
 * @Date 2021/8/3 18:20
 * @Description 告警通知类
 * 支持邮件、短信、微信、手机等多个通知渠道
 */
public class Notification {

    /**
     * 发出通知
     */
    public void notify(NotificationEmergencyLevel urgency, String msg) {
        // TODO tobing 2021年8月3日 实现具体的通知渠道
        System.out.println(urgency.toString() + ":" + msg);
    }
}
