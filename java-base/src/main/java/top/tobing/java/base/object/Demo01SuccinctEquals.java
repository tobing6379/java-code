package top.tobing.java.base.object;

import java.util.Objects;

/**
 * @author tobing
 * @date 2021/9/20 20:24
 * @description
 */
public class Demo01SuccinctEquals extends Demo01Equals {
    public Demo01SuccinctEquals(int i, String s, double d) {
        super(i, s, d);
        System.out.println("made 'Demo01SuccinctEquals'");
    }

    @Override
    public boolean equals(Object rval) {
        // 使用instanceof避免null检查和this检查
        return rval instanceof Demo01SuccinctEquals &&
                Objects.equals(i, ((Demo01SuccinctEquals) rval).i) &&
                Objects.equals(i, ((Demo01SuccinctEquals) rval).s) &&
                Objects.equals(i, ((Demo01SuccinctEquals) rval).d);
    }

    public static void main(String[] args) {
        Demo01Equals.testAll(Demo01SuccinctEquals::new);
    }
}
