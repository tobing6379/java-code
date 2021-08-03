package principal.single_responsibility.old;

/**
 * @Author tobing
 * @Date 2021/8/3 18:53
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        AlertRule alertRule = new AlertRule();
        Notification notification = new Notification();
        Alert alert = new Alert(alertRule, notification);
        alert.check("/user", 100, 100, 100);
    }
}
