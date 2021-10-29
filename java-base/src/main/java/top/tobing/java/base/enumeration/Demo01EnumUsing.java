package top.tobing.java.base.enumeration;

/**
 * @author tobing
 * @date 2021/9/25 9:25
 * @description 枚举使用
 */
public enum Demo01EnumUsing {

    OK(200, "OK"),
    NOT_FOUND(404, "NOT_FOUND");


    private int code;
    private String msg;

    Demo01EnumUsing(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
