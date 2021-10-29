package top.tobing.java.base.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobing
 * @date 2021/9/24 17:37
 * @description 类型通配符
 * ① 类型通配符一般是使用?代替具体的类型参数
 * ② 例如 List<?> 在逻辑上是List<String>,List<Integer> 等所有List<具体类型实参>的父类。
 */
public class Demo03GernricClassWildcard {


    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<Number> number = new ArrayList<>();

        name.add("icon");
        age.add(18);
        number.add(312);

        getData(name);
        getData(age);
        getData(number);
    }

    public static void getData(List<?> data) {
        System.out.println("data: " + data.get(0));
    }

    public static void getNumber(List<? extends Number> data) {
        System.out.println("Number: " + data.get(0));
    }

}
