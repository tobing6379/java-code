package top.tobing.java.base.method_call;

/**
 * @author tobing
 * @date 2021/9/24 8:54
 * @description 单分派与多分派
 * 方法的接收者与方法的参数统称为方法的宗量
 * 根据分派基于多少种宗量，可以将分派划分为单分派和多分派两种；
 */
public class Demo03MultiAndSimpleDispatch {
    static class QQ {

    }

    static class _360 {

    }

    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("Father:QQ");
        }

        public void hardChoice(_360 arg) {
            System.out.println("Father:360");

        }
    }

    public static class Son extends Father {
        @Override
        public void hardChoice(QQ arg) {
            System.out.println("Son:QQ");
        }

        @Override
        public void hardChoice(_360 arg) {
            System.out.println("Son:360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
        // 在执行上述的方法调用时会经历下面过程
        // ① 方法调用分为两种方式，静态解析和动态分派
        // ② 静态分配是在编译阶段由编译器决定，编译器根据静态类型和方法参数选择具体的方法；（重载的具体实现）
        // ③ 动态分派发送在运行阶段，有invokevirtual指令实现；
        // ④ invokevirtual执行时，由于编译阶段决定 目标方法的签名必须为hardChoice(QQ)
        // ⑤ 虚拟机不关心传递的参数是「腾讯QQ」还是「奇瑞QQ」
        // ⑥ 因为这时虚拟机选择方法的隐式是接受者的实际类型


    }
}
