package principal.single_responsibility.restruct;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tobing
 * @Date 2021/8/3 18:38
 * @Description API 接口监控告警
 * 重构之后的Alert，如果需要添加「超时告警」只需要改动以下代码
 * 1）为ApiStatInfo添加一个新的属性{@link ApiStatInfo#getTimeoutCount()}
 * 2）添加一个AlertHandler的超时处理实现类{@link TimeoutAlertHandler}
 * 3）改动initializeBeans添加属性 {@link ApplicationContext#initializeBeans()}
 * 4）使用Alert类是，需要给check设置timeoutCount值
 * <p>
 * （相比于以前的{@link principal.single_responsibility.old.Alert#check(java.lang.String, long, long, long)}，所有使用到该函数的都要改动）
 */
public class Alert {
    private List<AlertHandler> alertHandlers = new ArrayList<>();

    /**
     * 添加警告处理
     */
    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler alertHandler : alertHandlers) {
            alertHandler.check(apiStatInfo);
        }
    }
}
