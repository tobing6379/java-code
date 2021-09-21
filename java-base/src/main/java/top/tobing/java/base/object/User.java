package top.tobing.java.base.object;

import java.io.Serializable;

/**
 * @author tobing
 * @date 2021/9/20 22:46
 * @description
 */
public class User implements Serializable {
    private String username;
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
