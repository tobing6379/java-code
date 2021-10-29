package top.tobing.java.base.generics;

/**
 * @author tobing
 * @date 2021/9/24 17:22
 * @description 泛型方法
 * 【定义规则】
 * ① 泛型方法都有一个类型参数声明部分，类型参数声明部分在方法类型返回之前；
 * ② 每个类型声明部分包含一个或多个类型参数，参数键使用逗号隔开；
 * ③ 参数类型能够用来声明返回值类型，并且能作为泛型方法得到实际采纳数类型的占位符；
 * ④ 泛型方法体声明和其他方法一样。
 */
public class Demo01GenericsMethod {
    public static <E> void printArray(E[] intputArray) {
        for (E e : intputArray) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6};
        Double[] doubleArray = {1.1, 1.2, 1.3, 1.4, 1.5, 1.6};
        Character[] charArray = {'a', 'b', 'c', 'd', 'e'};
        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);
    }
}
