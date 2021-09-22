package top.tobing.java.base.string;

/**
 * @author tobing
 * @date 2021/9/21 23:48
 * @description String#intern()问题
 */
public class Demo02StringInternProblem {
    public static void main(String[] args) {
        String s1 = new String("1");    // 此过程将"1"放入字符串常量池中
        String s8 = s1.intern();// 在此之前已经有1，直接返回字符串常量池中的1
        String s2 = "1";                // 拿到的也是字符串常量池中的1
        System.out.println(s1 == s2);    // JDK6/7/8 false
        System.out.println(s2 == s8);

        String s3 = new String("1") + new String("1");    // 这一步执行完，字符串常量池中是没有“11”的
        s3.intern();                                    // 在字符串常量池中生成“11”
        String s4 = "11";                                // 获取字符串常量池中的“11”
        System.out.println(s3 == s4);    // JDK6:false	JDK7/8 true
    }
}
