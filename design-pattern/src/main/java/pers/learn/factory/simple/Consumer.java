package pers.learn.factory.simple;

public class Consumer {
    public static void main(String[] args) {
//        Car car1 = new WuLing();
//        Car car2 = new Tesla();

        Car car1 = CarFactory.getCar("wuling");
        Car car2 = CarFactory.getCar("tesla");

        car1.name();
        car2.name();
    }
}
