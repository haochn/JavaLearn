package com.learn.abstractFactory;

public class MiRouter implements RouterProduct{
    @Override
    public void powerOn() {
        System.out.println("Mi router powerOn");
    }

    @Override
    public void shutdown() {
        System.out.println("Mi router shutdown");

    }

    @Override
    public void openWiFi() {
        System.out.println("Mi router openWiFi");

    }

    @Override
    public void setting() {
        System.out.println("Mi router setting");

    }
}
