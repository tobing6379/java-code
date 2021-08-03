package principal.single_responsibility.old;

/**
 * @Author tobing
 * @Date 2021/8/3 18:21
 * @Description 通知的紧急程度
 */
public enum NotificationEmergencyLevel {
    /**
     * 严重
     */
    SERVER,
    /**
     * 紧急
     */
    URGENCY,
    /**
     * 普通
     */
    NORMAL,
    /**
     * 无关紧要
     */
    TRIVIAL
}
