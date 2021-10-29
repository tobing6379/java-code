package top.tobing.java.base.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tobing
 * @date 2021/9/24 17:04
 * @description 泛型的类型擦除
 */
public class Demo01TypeErasure {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "A");
        map.put("b", "B");
        map.put("c", "C");
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));

    }

    private static void testReflectionTypeErasure() {
        ArrayList<Integer> integers = new ArrayList<>();
        String simpleName = integers.getClass().getSimpleName();

    }
}
