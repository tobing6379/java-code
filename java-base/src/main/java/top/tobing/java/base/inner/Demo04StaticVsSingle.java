package top.tobing.java.base.inner;

/**
 * @author tobing
 * @date 2021/9/24 9:50
 * @description 静态内部类与单例
 */
public class Demo04StaticVsSingle {

    static class StaticInner implements Comparable{

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }


    public static void main(String[] args) {
        StaticInner staticInner = new StaticInner();
        staticInner.compareTo(staticInner);
    }

}
