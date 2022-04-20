package com.learn.factory.method;

public class WulingFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new WuLing();
    }
}
