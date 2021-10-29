package top.tobing.java.base.method_call;

import java.util.Random;

/**
 * @author tobing
 * @date 2021/9/24 8:17
 * @description 静态分配
 */
public class Demo01StaticDispatch {

    static abstract class Human {

    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void sayHello(Human guy) {
        System.out.println("sayHello(Human)");
    }

    public void sayHello(Man guy) {
        System.out.println("sayHello(Man)");
    }

    public void sayHello(Woman guy) {
        System.out.println("sayHello(Woman)");
    }

    public static void main(String[] args) {
        // Human称为静态类型(外观类型)
        // Man称为实际类型(运行时类型)
        // 静态类型和实际类型在程序中都可能会发生变化
        // 区别是静态类型的变化在使用时发生，变量本身的静态类型不会改变，最终的静态类型在编译器可知；
        // 实际类型变化的结果在运行期才确定，编译器在编写程序的时候并不知道一个对象的实际类型是什么；
        // 【实际类型变化】
        Human human = new Random().nextBoolean() ? new Man() : new Woman();

        Human man = new Man();
        Human woman = new Woman();
        Demo01StaticDispatch staticDispatch = new Demo01StaticDispatch();
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
        // 在方法接收者确定对象是staticDispatch之后，可以根据参数数量和类型决定使用那个重载的版本；
        // 虚拟机重载是通过参数的静态类型作为判定依据，由于静态类型编译器可知，在编译器有Javac编译器根据参数静态类型决定重载的版本；
        // 静态分配的典型表现是「方法重载」，发生在编译器阶段，因此确定静态分配的动作实际不是有虚拟机执行；
    }

}
