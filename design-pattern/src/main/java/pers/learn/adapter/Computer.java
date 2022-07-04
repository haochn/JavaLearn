package pers.learn.adapter;

public class Computer {
    public void net(NetToUSB adapter) {
        adapter.handlerRequest();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter();
        computer.net(adapter);
    }
}
