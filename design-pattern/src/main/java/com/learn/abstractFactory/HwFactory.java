package com.learn.abstractFactory;

public class HwFactory implements ProductFactory {
    @Override
    public PhoneProduct phoneProduct() {
        return new HwPhone();
    }

    @Override
    public RouterProduct routerProduct() {
        return new HwRouter();
    }
}
