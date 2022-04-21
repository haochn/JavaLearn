package com.learn.abstractFactory;

public class MiFactory implements ProductFactory {
    @Override
    public PhoneProduct phoneProduct() {
        return new MiPhone();
    }

    @Override
    public RouterProduct routerProduct() {
        return new MiRouter();
    }
}
