package top.tobing.java.base.object;

import java.util.Objects;

/**
 * @author tobing
 * @date 2021/9/20 20:12
 * @description 测试Equals
 */
public class Demo01Equals {
    protected int i;
    protected String s;
    protected double d;

    public Demo01Equals(int i, String s, double d) {
        this.i = i;
        this.s = s;
        this.d = d;
        System.out.println("made 'Equals'");
    }

    @Override
    public boolean equals(Object rval) {
        if (rval == null) {
            return false;
        }
        if (rval == this) {
            return true;
        }
        if (!(rval instanceof Demo01Equals)) {
            return false;
        }
        Demo01Equals other = (Demo01Equals) rval;
        if (!Objects.equals(i, other.i)) {
            return false;
        }
        if (!Objects.equals(s, other.s)) {
            return false;
        }
        if (!Objects.equals(d, other.d)) {
            return false;
        }
        return true;
    }

    public void test(String descr, String expected, Object rval) {
        System.out.format("-- Testing %s --%n" + "%s instanceof Equality: %s%n" +
                        "Expected %s, got %s%n",
                descr, descr, rval instanceof Demo01Equals, expected, equals(rval));
    }

    public static void testAll(Demo01EqualsFactory eqf) {
        Demo01Equals
                e = eqf.make(1, "Monty", 3.14),
                eq = eqf.make(1, "Monty", 3.14),
                neq = eqf.make(99, "Monty", 1.618);
        e.test("null", "false", null);
        e.test("same object", "true", e);
        e.test("different type", "false", Integer.valueOf(99));
        e.test("same values", "true", eq);
        e.test("different values", "false", neq);
    }

    public static void main(String[] args) {
        testAll((i, s, d) -> new Demo01Equals(i, s, d));
    }
}
