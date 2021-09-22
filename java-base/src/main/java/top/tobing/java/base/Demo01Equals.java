package top.tobing.java.base;

/**
 * @author tobing
 * @date 2021/9/20 19:48
 * @description
 */
public class Demo01Equals {
    public static void main(String[] args) {
        final int[] i = {0};
        int j = 10;
        new Thread(() -> {
            i[0] = 1;
            System.out.println(j);
        }).start();
        String str = "1";

    }

}
