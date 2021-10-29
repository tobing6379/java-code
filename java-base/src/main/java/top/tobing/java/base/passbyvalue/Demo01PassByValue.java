package top.tobing.java.base.passbyvalue;

import java.util.Arrays;
import java.util.Random;

/**
 * @author tobing
 * @date 2021/9/24 11:25
 * @description Java中的值传递
 */
public class Demo01PassByValue {


    public static void main(String[] args) {

        int[] arr = {0, 0, 0, 0};
        testChangeArrayParam(arr);
        System.out.println(Arrays.toString(arr));
        int i = 0;
        testExpressionInParam(new Random().nextInt() > 0);
    }

    private static void testChangeArrayParam(int arr[]) {
        arr[0] = 1;
        arr[1] = 2;
    }

    private static void testExpressionInParam(boolean flag) {
        System.out.println(flag);
    }
}
