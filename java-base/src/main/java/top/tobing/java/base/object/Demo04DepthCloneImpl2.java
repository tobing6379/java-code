package top.tobing.java.base.object;

import com.google.gson.Gson;
import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;

/**
 * @author tobing
 * @date 2021/9/20 22:44
 * @description 深拷贝实现1-基于Clmmons.lang序列化
 * @url https://www.baeldung.com/java-deep-copy#1-apache-commons-lang
 */
public class Demo04DepthCloneImpl2 implements Cloneable, Serializable {

    private int id;
    private User user;

    public Demo04DepthCloneImpl2(String name, int age) {
        id = 1;
        user = new User(name, age);
    }

    @Override
    public Demo04DepthCloneImpl2 clone() throws CloneNotSupportedException {
        return (Demo04DepthCloneImpl2) SerializationUtils.clone(this);
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Demo04DepthCloneImpl1{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Demo04DepthCloneImpl2 tobing = new Demo04DepthCloneImpl2("tobing", 22);
        Demo04DepthCloneImpl2 cloneTobing = tobing.clone();
        System.out.println(tobing == cloneTobing);
        System.out.println(tobing.getUser() == cloneTobing.getUser());
        System.out.println(tobing);
        System.out.println(cloneTobing);
    }
}
