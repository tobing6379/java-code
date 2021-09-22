package top.tobing.java.base.inner;

/**
 * @author tobing
 * @date 2021/9/22 11:52
 * @description 内部类
 */
public class Demo01InnerClass {

    private int age;
    private String name;

    public Demo01InnerClass(int age, String name) {
        this.age = age;
        this.name = name;
    }

    /**
     * 【隐式引用】
     * 内部类对象持有一个隐式的引用，指向了了它的外部类
     * 编译器会为内部类的构造器生成一个隐式引入的赋值
     * 编译器会完成外部类的this引用的传递
     * 【外部类】
     * 只有内部类可以是私有类，常规的类只能是包可见或公有可见性
     */
    private class InnerClass {

        /**
         * 【内部类构造器】
         * 0 aload_0
         * 1 aload_1
         * 2 putfield #1 <top/tobing/java/base/inner/Demo01InnerClass$InnerClass.this$0 : Ltop/tobing/java/base/inner/Demo01InnerClass;>
         * 5 aload_0
         * 6 invokespecial #2 <java/lang/Object.<init> : ()V>
         * 9 return
         */

        public void accessOuterClass() {
            System.out.println(age);
            System.out.println(name);
        }
        /**
         * 【内部类访问外部类的原理】
         *  0 getstatic #3 <java/lang/System.out : Ljava/io/PrintStream;>
         *  3 aload_0
         *  4 getfield #1 <top/tobing/java/base/inner/Demo01InnerClass$InnerClass.this$0 : Ltop/tobing/java/base/inner/Demo01InnerClass;>
         *  7 invokestatic #4 <top/tobing/java/base/inner/Demo01InnerClass.access$000 : (Ltop/tobing/java/base/inner/Demo01InnerClass;)I>
         * 10 invokevirtual #5 <java/io/PrintStream.println : (I)V>
         * 13 getstatic #3 <java/lang/System.out : Ljava/io/PrintStream;>
         * 16 aload_0
         * 17 getfield #1 <top/tobing/java/base/inner/Demo01InnerClass$InnerClass.this$0 : Ltop/tobing/java/base/inner/Demo01InnerClass;>
         * 20 invokestatic #6 <top/tobing/java/base/inner/Demo01InnerClass.access$100 : (Ltop/tobing/java/base/inner/Demo01InnerClass;)Ljava/lang/String;>
         * 23 invokevirtual #7 <java/io/PrintStream.println : (Ljava/lang/String;)V>
         * 26 return
         */
    }


    /**
     * 【外部类反编译结果】
     * public class top.tobing.java.base.inner.Demo01InnerClass {
     *   private int age;
     *   private java.lang.String name;
     *   public top.tobing.java.base.inner.Demo01InnerClass(int, java.lang.String);
     *   // 编译器在外围类添加静态方法access$000
     *   // 内部了将调用该方法
     *   static int access$000(top.tobing.java.base.inner.Demo01InnerClass);
     *   static java.lang.String access$100(top.tobing.java.base.inner.Demo01InnerClass);
     * }
     */

    /**
     * 【内部类反编译结果】
     * class top.tobing.java.base.inner.Demo01InnerClass$InnerClass {
     *   // 编译器为了引用外围类，生成了一个附加的实例域this$0;
     *   // 这个名字是由编译器合成的，自己编写代码的时候不能引用；
     *   final top.tobing.java.base.inner.Demo01InnerClass this$0;
     *   // 在构造器中，可以看到Demo01InnerClass外部类的参数
     *   // 与普通类不同，内部类具有访问特权，功能更加强大；
     *   private top.tobing.java.base.inner.Demo01InnerClass$InnerClass(top.tobing.java.base.inner.Demo01InnerClass);
     *   public void accessOuterClass();
     * }
     */
}
