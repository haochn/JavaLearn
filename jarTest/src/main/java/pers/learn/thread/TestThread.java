package pers.learn.thread;

public class TestThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("run---" + i);
        }
    }

    public static void main(String[] args) {
        new TestThread().start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main------" + i);
        }
    }
}
