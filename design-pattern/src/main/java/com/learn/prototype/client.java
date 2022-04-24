package com.learn.prototype;

public class client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype realizetype = new Realizetype();
        Realizetype clone = realizetype.clone();
        System.out.println(realizetype.hashCode());
        System.out.println(clone.hashCode());
    }
}
