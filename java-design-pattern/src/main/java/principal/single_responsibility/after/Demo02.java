package principal.single_responsibility.after;

/**
 * @Author tobing
 * @Date 2021/7/30 14:04
 * @Description
 */
public class Demo02 {
    public static void main(String[] args) {
        OilCarVehicle oilCarVehicle = new OilCarVehicle();
        ElectricityCarVehicle electricityCarVehicle = new ElectricityCarVehicle();
        AirVehicle airVehicle = new AirVehicle();
        oilCarVehicle.run("汽车");
        electricityCarVehicle.run("电车");
        airVehicle.run("飞机");
    }

}

/**
 * 考虑到电车，汽车，飞机运行的功能并不相同，现在这些功能进行拆分
 * 分别封装到不同的类中，实现单一职责
 */
class OilCarVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "运行在路上跑");
    }
}

class ElectricityCarVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "运行在路上跑");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "运行在天上飞");
    }
}