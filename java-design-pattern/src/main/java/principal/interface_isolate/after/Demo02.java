package principal.interface_isolate.after;

/**
 * @Author tobing
 * @Date 2021/7/30 14:16
 * @Description 接口隔离原则
 * 对于A只需要实现Interface1的operation01方法；
 * 对于B只需要实现Interface1的operation03、operation02方法；
 * 对于C只需要实现Interface1的operation04、operation05方法；
 * 如果只使用一个接口，A、B、C三个类将不得不区实现一些没有使用到的方法
 * 这样一来，就违反了「客户端不应该依赖它不需要的接口，即一个类对另一个类的依赖应该建立在最小的接口上。」
 * 为了能够符合接口隔离原则，考虑将Interface1接口进行拆分
 */
public class Demo02 {
}


interface Interface1 {
    void operation01();
}

interface Interface2 {
    void operation02();

    void operation03();
}

interface Interface3 {
    void operation04();

    void operation05();
}

class A implements Interface1 {

    @Override
    public void operation01() {

    }
}

class B implements Interface2 {
    @Override
    public void operation02() {

    }

    @Override
    public void operation03() {

    }
}

class C implements Interface3 {

    @Override
    public void operation04() {

    }

    @Override
    public void operation05() {

    }
}
