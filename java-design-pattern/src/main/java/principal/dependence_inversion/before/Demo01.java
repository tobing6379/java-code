package principal.dependence_inversion.before;

/**
 * @Author tobing
 * @Date 2021/7/30 14:16
 * @Description 依赖倒转原则
 * 高层模块不应该依赖低层模块，二者都应该依赖其抽象。抽象不应该依赖细节，细节应该依赖抽象。
 */
public class Demo01 {
}


class Email {
    public String getInfo() {
        return "电子邮件信息：hello, world!";
    }
}


class Person {

    /**
     * 由于此处使用的是Email来作为接收参数，以后如果需要接收QQ信息，该怎么办了
     * 因此，在这里不应该接受具体的细节实现，应该接受其抽象Receiver
     */
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}

