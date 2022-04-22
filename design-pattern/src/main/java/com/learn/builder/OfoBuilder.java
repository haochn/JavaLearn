package com.learn.builder;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("铝合金车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("人造革");
    }

    @Override
    public Bike creatBike() {
        return bike;
    }
}
