package top.tobing.java.base.object;

import com.google.gson.Gson;

import java.io.*;
import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/9/20 22:44
 * @description 深拷贝实现1-基于Gson序列化
 * @url https://www.baeldung.com/java-deep-copy#2-json-serialization-with-gson
 * https://www.baeldung.com/java-system-arraycopy-arrays-copyof-performance
 */
public class Demo04DepthCloneImpl1 implements Cloneable, Serializable {

    private int id;
    private User user;

    public Demo04DepthCloneImpl1(String name, int age) {
        id = 1;
        user = new User(name, age);
    }

    @Override
    public Demo04DepthCloneImpl1 clone() throws CloneNotSupportedException {
        Gson gson = new Gson();
        Demo04DepthCloneImpl1 clone = gson.fromJson(gson.toJson(this), Demo04DepthCloneImpl1.class);
        return clone;
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
        Demo04DepthCloneImpl1 tobing = new Demo04DepthCloneImpl1("tobing", 22);
        Demo04DepthCloneImpl1 cloneTobing = tobing.clone();
        System.out.println(tobing == cloneTobing);
        System.out.println(tobing.getUser() == cloneTobing.getUser());
        System.out.println(tobing);
        System.out.println(cloneTobing);

        System.out.println();
        System.out.println();
        // 数组的clone
        User[] userList = {
                new User("tobing1", 22),
                new User("tobing2", 23),
                new User("tobing3", 24),
                new User("tobing4", 25)
        };
        // 拷贝方式1：Object#clone
        User[] cloneList = userList.clone();
        // 拷贝方式2：System#arraycopy
        User[] cloneList2 = new User[userList.length];
        System.arraycopy(userList, 0, cloneList2, 0, cloneList2.length);
        // 拷贝方式3：Arrays#copyOf
        User[] cloneList3 = Arrays.copyOf(userList, cloneList.length);

        System.out.println("Object#clone\t:" + (userList == cloneList));
        System.out.println("System#arraycopy\t:" + (userList == cloneList2));
        System.out.println("Arrays.copyOf\t:" + (userList == cloneList3));
        System.out.println("============DepthCopy============");
        System.out.println("Object#clone\t:" + isDepthCopy(userList, cloneList));
        System.out.println("System#arraycopy\t:" + isDepthCopy(userList, cloneList2));
        System.out.println("Arrays.copyOf\t:" + isDepthCopy(userList, cloneList3));


    }

    private static boolean isDepthCopy(User[] src, User[] dest) {
        boolean res = true;
        for (int i = 0; i < src.length; i++) {
            if (src[i] == dest[i]) {
                res = false;
            }
        }
        return res;
    }
}
