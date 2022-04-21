package com.learn.abstractFactory;

public class HwPhone implements PhoneProduct {
    @Override
    public void powerOn() {
        System.out.println("HwPhone powerOn");
    }

    @Override
    public void shutdown() {
        System.out.println("HwPhone shutdown");
    }

    @Override
    public void callup() {
        System.out.println("HwPhone callup");

    }

    @Override
    public void sms() {
        System.out.println("HwPhone sms");

    }
}
