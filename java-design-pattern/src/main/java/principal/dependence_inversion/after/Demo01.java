package principal.dependence_inversion.after;

/**
 * @Author tobing
 * @Date 2021/7/30 14:16
 * @Description 依赖倒转原则
 * 高层模块不应该依赖低层模块，二者都应该依赖其抽象。抽象不应该依赖细节，细节应该依赖抽象。
 */
public class Demo01 {
}


class Email implements Receiver {
    @Override
    public String getInfo() {
        return "电子邮件信息：hello, world!";
    }
}

class QQ implements Receiver {

    @Override
    public String getInfo() {
        return "QQ信息：hello, world!";
    }
}

interface Receiver {
    /**
     * 接收信息
     */
    String getInfo();
}

class Person {

    /**
     * 在这里不应该接受具体的细节实现，应该接受其抽象Receiver
     */
    public void receive(Receiver receiver) {
        System.out.println(receiver.getInfo());
    }
}

