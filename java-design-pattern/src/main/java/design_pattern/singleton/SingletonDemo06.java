package design_pattern.singleton;

/**
 * @Author tobing
 * @Date 2021/8/1 14:21
 * @Description 单例
 * DCL
 */
public class SingletonDemo06 {
    public static void main(String[] args) throws InterruptedException {
        Singleton06 instance1 = Singleton06.getInstance();
        Singleton06 instance2 = Singleton06.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
}

class Singleton06 {

    private Singleton06() {
    }

    private static class Singleton0602 {
        private static final Singleton06 INSTANCE = new Singleton06();
    }

    /**
     * 为什么静态内部类能够实现 lazy-loading ？
     * 《Java虚拟机规范》严格规定了有且只有六种情况必须立即对类进行“初始化”
     * 1、使用new关键字实例化对象的时候；
     * 读取或设置一个类型的静态字段（被final修饰、 已在编译期把结果放入常量池的静态字段除外）的时候。
     * 调用一个类型的静态方法的时候。
     * 2、使用java.lang.reflect包的方法对类型进行反射调用的时候，如果类型没有进行过初始化， 则需要先触发其初始化。
     * 3、当初始化类的时候， 如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化。
     * 4、当虚拟机启动时， 用户需要指定一个要执行的主类（包含main()方法的那个类），虚拟机会先初始化这个主类。
     * 5、当使用JDK 7新加入的动态语言支持时...【省略】
     * 6、当一个接口中定义了JDK 8新加入的默认方法（被default关键字修饰的接口方法）时，
     * 如果有这个接口的实现类发生了初始化，那该接口要在其之前被初始化。
     * <p>
     * 初始化阶段就是执行类构造器<clinit>()方法的过程。 <clinit>()并不是程序员在Java代码中直接编写的方法，
     * 它是Javac编译器的自动生成物，由编译器自动收集类中的所有类变量的赋值动作和静态语句块（static{}块）中的语句合并产生的
     * <p>
     * 显然，对于静态内部类{@link Singleton0602}，只有在调用@{@link Singleton06#getInstance()}时（第2点）
     * 才会引起类的初始化，进而创建对象，否则将不会占用空间，可以实现懒加载
     *
     */
    public static Singleton06 getInstance() {
        return Singleton0602.INSTANCE;
    }
}
