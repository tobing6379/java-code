package top.tobing.java.base.boxing;

/**
 * @author tobing
 * @date 2021/9/21 13:01
 * @description 自动装箱和自动拆箱
 */
public class Demo01BoxingAndUnBoxing {
    public static void main(String[] args) {
        // 下面两行语句本质上是相同的
        Integer i1 = 1;
        Integer i2 = Integer.valueOf(1);

        // 下面两行语句本质上是相同的
        int i3 = i1;
        int i4 = i1.intValue();

    }
}
