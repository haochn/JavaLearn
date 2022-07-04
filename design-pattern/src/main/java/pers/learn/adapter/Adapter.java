package pers.learn.adapter;

// 真正的适配器
public class Adapter extends Adaptee implements NetToUSB{
    @Override
    public void handlerRequest() {
        super.request();
    }
}
