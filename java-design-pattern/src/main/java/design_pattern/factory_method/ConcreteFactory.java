package design_pattern.factory_method;


import design_pattern.simple_factory.ConcreteProduct;
import design_pattern.simple_factory.Product;

import java.util.Calendar;

/**
 * @author tobing
 * @date 2021/10/7 18:31
 * @description 定义一个创建对象的接口，由子类决定要实例化哪个类。工程方法将实例化操作推迟到子类
 */
public class ConcreteFactory extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}
