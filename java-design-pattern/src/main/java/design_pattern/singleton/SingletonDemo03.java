package design_pattern.singleton;

/**
 * @Author tobing
 * @Date 2021/8/1 14:21
 * @Description 单例
 * 懒汉式线程不安全
 */
public class SingletonDemo03 {
    public static void main(String[] args) {
        Singleton03 instance1 = Singleton03.getInstance();
        Singleton03 instance2 = Singleton03.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
}

class Singleton03 {
    // 私有化构造器
    private Singleton03() {
    }

    private static Singleton03 instance;

    // 有线程安全
    public static Singleton03 getInstance() {
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;
    }
}
