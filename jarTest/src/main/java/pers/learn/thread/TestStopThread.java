package pers.learn.thread;

public class TestStopThread implements Runnable {
    //建议使用标志位flag
    //不建议使用stop(),destroy()等方法，已经@Deprecated的方法

    private boolean flag = true;

    public void stop() {
        this.flag = false;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run---" + i);
            i++;
        }
    }

    public static void main(String[] args) {
        TestStopThread testStopThread = new TestStopThread();
        new Thread(testStopThread).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main------" + i);
            if (i == 900) {
                testStopThread.stop();
                System.out.println("testStopThread.stop();");
            }
        }

//        new Thread(()->{
//            int i=0;
//            System.out.println("Runnable---"+i);
//            i++;
//        }).start();
    }
}
