package pers.learn.thread;

public class ABCSynch {

    // 成员内部类
    public class ThreadPrinter2 extends Thread {
        private String name;
        private Object pre;
        private Object self;

        public ThreadPrinter2(String name, Object pre, Object self) {
            this.name = name;
            this.pre = pre;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                synchronized (pre) {
                    synchronized (self) {
                        System.out.println(name);
                        count--;
                        self.notifyAll();
                    }
                    try {
                        if (count == 0) {
                            pre.notifyAll();
                        }
                        else {
                            pre.wait();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}
