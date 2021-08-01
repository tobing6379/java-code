package design_pattern.singleton;

/**
 * @Author tobing
 * @Date 2021/8/1 14:21
 * @Description 单例
 * 枚举
 */
public class SingletonDemo07 {
    public static void main(String[] args) throws InterruptedException {
        Singleton07 instance1 = Singleton07.INSTANCE;
        Singleton07 instance2 = Singleton07.INSTANCE;
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance1.getAge());
        System.out.println(instance2.getName());
    }
}

/**
 * 使用枚举实现单例
 * https://www.baeldung.com/a-guide-to-java-enums#1-singleton-pattern
 */
enum Singleton07 {
    // 单例对象
    INSTANCE;

    private static String name;
    private static Integer age;

    static {
        name = "tobing";
        age = 22;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
