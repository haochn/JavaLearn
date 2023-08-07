package com.pers.proxy.factory;

import com.pers.proxy.service.UsbSell;

public class UsbFactory implements UsbSell {
    @Override
    public float sell(int amount) {
        return 85.0f;
    }
}
