package principal.single_responsibility.after;

/**
 * @Author tobing
 * @Date 2021/7/30 14:04
 * @Description
 */
public class Demo03 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.run("电车");
        vehicle.fly("飞机");
    }

}

/**
 * Demo02的方式中，其解决的方式挨冻太大，同时还需要修改使用者的API
 * 因此考虑使用在方法级别上遵循单一职责原则，
 */
class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "运行在路上跑");
    }

    public void fly(String vehicle) {
        System.out.println(vehicle + "运行在天上飞");
    }
}
