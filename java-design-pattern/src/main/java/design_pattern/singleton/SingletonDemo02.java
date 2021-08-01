package design_pattern.singleton;

/**
 * @Author tobing
 * @Date 2021/8/1 14:21
 * @Description 单例
 * 饿汉式静态代码块
 */
public class SingletonDemo02 {
    public static void main(String[] args) {
        Singleton02 instance1 = Singleton02.getInstance();
        Singleton02 instance2 = Singleton02.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println("instance1：" + instance1);
        System.out.println("instance2：" + instance2);
    }
}

class Singleton02 {
    // 私有化构造器
    private Singleton02() {
    }

    private static final Singleton02 instance;

    static {
        instance = new Singleton02();
    }

    public static Singleton02 getInstance() {
        return instance;
    }
}
