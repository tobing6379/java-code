package top.tobing.java.base.inner;

/**
 * @author tobing
 * @date 2021/9/22 12:45
 * @description 局部内部类
 */
public class Demo02LocalInnerClass {


    public void testLocalInnerClassAccess(final boolean flag) {

        final int[] state = {0};

        class LocalInnerClass {
            /**
             * 测试局部内部访问为访问外部类的局部变量
             */
            public void testAccessOuterLocalVariable() {
                // 访问外部类的局部变量
                System.out.println(flag);
            }

            /**
             * 测试局部内部类与外部类修改状态进行通信
             */
            public void testChangeOuterState() {
                // 局部变量表final的限制有时会显得不太方便；
                // 如有时候需要更新在一个封闭作用域的计数器；
                // 如此处的state需要更新
                // 此时奖补鞥将counter声明为final；
                // 由于Integer对象不可变，因此不能使用Integer代替它；
                // 一个补救的方法就是使用一个长度为1的数组；
                // 这样一来，尽管数组遍历被声明为final，但不影响其内部元素可以自由改变；
                state[0] = 1;
            }

        }
    }

}
