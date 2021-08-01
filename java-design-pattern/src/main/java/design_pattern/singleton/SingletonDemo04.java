package design_pattern.singleton;

/**
 * @Author tobing
 * @Date 2021/8/1 14:21
 * @Description 单例
 * 懒汉式线程安全，同步方法
 */
public class SingletonDemo04 {
    public static void main(String[] args) {
        Singleton04 instance1 = Singleton04.getInstance();
        Singleton04 instance2 = Singleton04.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
}

class Singleton04 {
    private Singleton04() {
    }

    private static Singleton04 instance;

    // 使用同步方法保证线程安全
    public static synchronized Singleton04 getInstance() {
        if (instance == null) {
            instance = new Singleton04();
        }
        return instance;
    }
}
