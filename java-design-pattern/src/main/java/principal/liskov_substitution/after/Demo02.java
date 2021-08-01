package principal.liskov_substitution.after;

/**
 * @Author tobing
 * @Date 2021/7/30 14:16
 * @Description 里氏代换原则
 * 如果对每个类型为T1的对象o1，都有类型为T2的对象o2，
 * 使得以T1定义的所有程序 P在所有的对象o1都代换成o2时，
 * 程序P的行为没有发生变化，那么类型T2是类型T1 的子类型。
 * 换句话说，所有引用基类的地方必须能透明地使用其子类的对象。
 * <p>
 * 在使用继承时，遵循里氏替换原则，在子类中尽量不要重写父类的方法
 * 里氏替换原则告诉我们，继承实际上让两个类耦合性增强了，在适当的情况下，
 * 可以通过聚合，组合，依赖 来解决问题。
 */
public class Demo02 {
    public static void main(String[] args) {
        // 由于AA类继承了A类并重写了其fun1方法，其中AA#fun1()与A#fun1()的实现效果并不相同。
        // 如果使用AA类替换A类，由于AA类对于fun1的实现与A类的实现不同，将不能透明替换。
        // 因此此处违反了里氏代换原则
        // 这是为了能够遵循里氏代换原则，（将A类与AA类）使用聚合、依赖、组合等来解决问题
        A a = new A();
        System.out.println("1+1=" + a.fun1(1, 1));
        System.out.println("1+3=" + a.fun1(1, 3));
        System.out.println("1+4=" + a.fun1(1, 4));
    }
}

class A {
    public int fun1(int a, int b) {
        return a + b;
    }
}

/**
 * 使用依赖方式来代替重写方式：{@link principal.liskov_substitution.before.AA#fun2(int, int)}
 */
class AA {

    private A a;

    public AA(A a) {
        this.a = a;
    }

    public int fun2(int i, int j) {
        return a.fun1(i, j) + 9;
    }
}
