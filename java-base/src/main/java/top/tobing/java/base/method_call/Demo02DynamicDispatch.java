package top.tobing.java.base.method_call;

/**
 * @author tobing
 * @date 2021/9/24 8:31
 * @description 动态分派
 */
public class Demo02DynamicDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("sayHello(Man)");
        }
    }

    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("sayHello(Woman)");
        }
    }
    public static void main(String[] args) {
        // 对于重写的方法，Java虚拟机根据实际类型决定方法执行的版本；
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
        // 【invokevirtual指令解析过程】
        // 找到操作数栈的第一个元素执行的对象的实际类型，记为C；
        // 在C中找到与常量中描述符和简单名称都相符的方法，进行访问权限校验；
        // 如果校验通过返回方法的直接引用，查找过程结束；
        // 不通过会返回java.lang.IlleagalAccessError异常；
        // 否则按照继承关系从下往上依次对C的各个父类进行第二步搜索和验证过程；
        // 如果始终没有找到合适的发发发，抛出java.lang.AbstractMethodError异常；

    }
}
