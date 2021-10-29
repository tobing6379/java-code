package top.tobing.java.base.generics;

/**
 * @author tobing
 * @date 2021/9/24 17:22
 * @description 泛型类
 * 【定义规则】
 * ① 泛型类的声明和非泛型类的声明类似，处理在类名之后添加类型参数声明部分；
 * ② 和发泛型方法一样，泛型类的类型参数声明部分包含一个或多个类型参数，参数之间用逗号隔开。
 * ③ 泛型参数可以成为一个类变量，用于指定一个泛型类型名称的标识符。
 */
public class Demo02GenericsClass<T, U> {

    private T t;
    private U u;

    public Demo02GenericsClass(T t, U u) {
        this.t = t;
        this.u = u;
    }

    public T getT() {
        return t;
    }

    public U getU() {
        return u;
    }

    public static void main(String[] args) {
        Demo02GenericsClass<String, Integer> stringIntegerDemo02GenericsClass = new Demo02GenericsClass<String, Integer>("tobing", 1);
        System.out.println(stringIntegerDemo02GenericsClass.getT());
        System.out.println(stringIntegerDemo02GenericsClass.getU());
    }
}
