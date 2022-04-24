package com.learn.prototype;

public class Realizetype implements Cloneable {
    public Realizetype() {
        System.out.println("构造方法，具体原型对象创建完成");
    }

    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型对象复制成功！");
        return (Realizetype) super.clone();
    }
}
