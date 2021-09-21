package top.tobing.java.base.object;

/**
 * @author tobing
 * @date 2021/9/20 20:55
 * @description 测试HashCode
 */
public class Demo03Hash {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o3 = new Object();
        Object o2 = new Object();
        // 460141958
        System.out.println(o1.hashCode());
        // 1163157884
        System.out.println(o2.hashCode());


        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str1 == str2);

    }
}
