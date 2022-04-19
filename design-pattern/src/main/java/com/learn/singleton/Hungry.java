package com.learn.singleton;

//饿汉式单例
public class Hungry {

    private Hungry() {
    }

    private final static Hungry Hungry = new Hungry();

    public static Hungry getInstance() {
        return Hungry;
    }
}
