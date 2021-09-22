package top.tobing.java.base.string;

import java.nio.charset.StandardCharsets;

/**
 * @author tobing
 * @date 2021/9/21 17:42
 * @description 字符串的性质
 * 创建单字符串
 * ①字面量方式创建字符串
 * 先去字符串常量池中判断是否存在该字符串，如果存在直接返回；如果不存在先放到常量池，再返回；
 * ②new方式创建字符串
 * 会将指明了
 */
public class Demo01SingleString {

    public static void main(String[] args) {

        String str1 = "tobing";
        String str2 = "tobing";
        String str3 = new String("python");
        String str4 = new String("python");
        String str5 = "python";
        String str6 = str4.intern();
        String str7 = new String("tobing");

        System.out.println(str3.intern() == str4.intern()); // true
        System.out.println(str1 == str2);   // true
        System.out.println(str2 == str3);   // false
        System.out.println(str3 == str4);   // false
        System.out.println(str3 == str5);   // true
        System.out.println(str5 == str6);   // true
        System.out.println(str7.intern() == str1);  // true

    }
}
