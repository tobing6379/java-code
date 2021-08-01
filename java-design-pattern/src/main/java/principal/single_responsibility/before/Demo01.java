package principal.single_responsibility.before;

/**
 * @Author tobing
 * @Date 2021/7/30 14:02
 * @Description
 */
public class Demo01 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("电车");
        vehicle.run("汽车");
        // 此处显然不合理，飞机怎么在地上跑呢？
        vehicle.run("飞机");
    }

}

class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "运行在路上跑");
    }
}
