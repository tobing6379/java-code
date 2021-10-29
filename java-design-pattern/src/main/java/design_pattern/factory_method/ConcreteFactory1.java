package design_pattern.factory_method;

import design_pattern.simple_factory.Concrete1Product;
import design_pattern.simple_factory.Product;

/**
 * @author tobing
 * @date 2021/10/7 18:33
 * @description
 */
public class ConcreteFactory1 extends Factory{
    @Override
    public Product factoryMethod() {
        return new Concrete1Product();
    }
}
