package com.learn.abstractFactory;

public class HwRouter implements RouterProduct {
    @Override
    public void powerOn() {
        System.out.println("hwrouter powerOn");
    }

    @Override
    public void shutdown() {
        System.out.println("hwrouter shutdown");

    }

    @Override
    public void openWiFi() {
        System.out.println("hwrouter openWiFi");

    }

    @Override
    public void setting() {
        System.out.println("hwrouter setting");

    }
}
