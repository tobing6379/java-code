package design_pattern.factory_method;

import design_pattern.simple_factory.Product;

/**
 * @author tobing
 * @date 2021/10/7 18:30
 * @description
 */
public abstract class Factory {
    abstract public Product factoryMethod();

    public void doSomething() {
        Product product = factoryMethod();
    }
}
