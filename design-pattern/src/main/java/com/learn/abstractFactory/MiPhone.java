package com.learn.abstractFactory;

public class MiPhone implements PhoneProduct {
    @Override
    public void powerOn() {
        System.out.println("miphone powerOn");
    }

    @Override
    public void shutdown() {
        System.out.println("miphone shutdown");
    }

    @Override
    public void callup() {
        System.out.println("miphone callup");

    }

    @Override
    public void sms() {
        System.out.println("miphone sms");

    }
}
