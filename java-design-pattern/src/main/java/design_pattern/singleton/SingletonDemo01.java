package design_pattern.singleton;

/**
 * @Author tobing
 * @Date 2021/8/1 14:21
 * @Description 单例
 * 饿汉式静态常量
 */
public class SingletonDemo01 {
    public static void main(String[] args) {
        Singleton01 instance1 = Singleton01.getInstance();
        Singleton01 instance2 = Singleton01.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println("instance1：" + instance1);
        System.out.println("instance2：" + instance2);
    }
}

class Singleton01 {
    // 私有化构造器
    private Singleton01() {
    }

    private static final Singleton01 instance = new Singleton01();

    public static Singleton01 getInstance() {
        return instance;
    }
}
