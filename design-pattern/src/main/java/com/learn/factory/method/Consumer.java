package com.learn.factory.method;


public class Consumer {
    public static void main(String[] args) {
        Car car1 = new WulingFactory().getCar();
        Car car2 = new TeslaFactory().getCar();

        car1.name();
        car2.name();

    }
}
