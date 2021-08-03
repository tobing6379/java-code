package principal.single_responsibility.restruct;

import principal.single_responsibility.old.AlertRule;
import principal.single_responsibility.old.Notification;

/**
 * @Author tobing
 * @Date 2021/8/3 18:47
 * @Description 重构之后，Alert的使用
 */
public class ApplicationContext {
    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;


    // 饿汉式单例
    private static final ApplicationContext instance = new ApplicationContext();

    private ApplicationContext() {
    }

    public static ApplicationContext getInstance() {
        return instance;
    }

    public void initializeBeans() {
        alertRule = new AlertRule();
        notification = new Notification();
        alert = new Alert();
        alert.addAlertHandler(new TpsAlertHandler(alertRule, notification));
        alert.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
    }

    private Alert getAlert() {
        return alert;
    }

    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }
}
