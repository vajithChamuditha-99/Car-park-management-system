package CarParkManager;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        Vehicle car = new Car("9999", "nissan", new DateTime(10, 9, 2020, 5, 30), 4, new Color(12, 12, 12));
        Vehicle car1 = new Car("2222", "toyota", new DateTime(20, 9, 2020, 5, 30), 2, new Color(22, 12, 12));
        Vehicle van = new Van("1111", "honda", new DateTime(5, 4, 2020, 3, 20), 30);
        Vehicle bike = new Motorbike("3333", "peugeot", new DateTime(6, 6, 2020, 3, 20), 40);

        CarParkManager westminsterCarParkManager = new WestminsterCarParkManager();
        westminsterCarParkManager.addVehicle(car);
        westminsterCarParkManager.addVehicle(van);
        westminsterCarParkManager.addVehicle(bike);
        westminsterCarParkManager.addVehicle(car1);

        westminsterCarParkManager.printVehicleList();

//        Car car2 = car1;

//        System.out.println(car1.equals(car2));
//        System.out.println(car.equals(car1));

//        System.out.println(car1);
//        System.out.println(car2);
//        System.out.println(car);

    }
}
