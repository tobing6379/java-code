package top.tobing.java.base.inner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobing
 * @date 2021/9/22 12:59
 * @description 匿名内部类
 */
public class Demo03AnonymousLocalInnerClass {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("test");
            Class<?> enclosingClass = new Object() {
            }.getClass().getEnclosingClass();
            System.out.println(enclosingClass.getSimpleName());
        }).start();


        Demo03AnonymousLocalInnerClass clazz = new Demo03AnonymousLocalInnerClass();
        // 编码技巧：双括号初始化
        // 外层括号表建立了ArrayList的匿名子类
        // 内存括号时是有个对象构造块
        clazz.dfs(new ArrayList<Integer>() {{
            add(1);
            add(2);
        }});
    }

    public void dfs(List<Integer> list) {
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
