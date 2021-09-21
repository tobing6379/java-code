package top.tobing.java.base.object;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author tobing
 * @date 2021/9/20 20:34
 * @description
 */
public class Demo02Animal {
    private static int counter = 0;
    private final int id = counter++;
    private final String name;
    private final Size size;

    public Demo02Animal(String name, Size size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public boolean equals(Object rval) {
        return rval instanceof Demo02Animal &&
                Objects.equals(name, ((Demo02Animal) rval).name) &&
                Objects.equals(size, ((Demo02Animal) rval).size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }

    @Override
    public String toString() {
        return String.format("%s[%d]： %s %s %x",
                getClass().getSimpleName(), id, name, size, hashCode());
    }

    public static void main(String[] args) {
        Set<Demo02Animal> set = new HashSet<>();
        set.add(new Dog("Ralph", Size.MEDIUM));
        set.add(new Pig("Ralph", Size.MEDIUM));
        set.forEach(System.out::println);
    }
}

class Dog extends Demo02Animal {
    public Dog(String name, Size size) {
        super(name, size);
    }
}
class Pig extends Demo02Animal {
    public Pig(String name, Size size) {
        super(name, size);
    }
}
