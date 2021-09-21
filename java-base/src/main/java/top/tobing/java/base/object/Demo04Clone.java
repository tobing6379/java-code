package top.tobing.java.base.object;

/**
 * @author tobing
 * @date 2021/9/20 22:32
 * @description clone测试
 */
public class Demo04Clone implements Cloneable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        // 对于Object实现的clone方法，如果没有实现Cloneable接口，会直接抛出CloneNotSupportedException
        return super.clone();
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Demo04Clone o1 = new Demo04Clone();
        Object clone = o1.clone();
        System.out.println(clone);
    }
}
