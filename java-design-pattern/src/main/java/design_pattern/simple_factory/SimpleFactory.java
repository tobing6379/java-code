package design_pattern.simple_factory;

/**
 * @author tobing
 * @date 2021/10/7 18:20
 * @description 简单工厂
 * @url1 https://www.jianshu.com/p/a9f397c4ff98
 * @url2 https://www.jianshu.com/p/e55fbddc071c
 * 简单工厂不是设计模式，更像是一种编程习惯。
 * 它把实例化的操作单独放在一个类中，这类就会成为了简单工厂类，
 * 让简单工厂类决定应该用哪个具体子类来实例化。
 */
public class SimpleFactory {
    public Product createProduct(int type) {
        if (type == 1) {
            return new Concrete1Product();
        } else if (type == 2) {
            return new Concrete2Product();
        }
        return new ConcreteProduct();
    }
}
