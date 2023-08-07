package pers.learn;

import org.junit.Test;
import pers.learn.thread.ABCReentrantLock;
import pers.learn.thread.ABCSynch;

public class ThreadTest {
    @Test
    public void abcTest() throws InterruptedException {
        ABCSynch abcSynch = new ABCSynch();
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        abcSynch.new ThreadPrinter2("A", c, a).start();
        Thread.sleep(3);
        abcSynch.new ThreadPrinter2("B", a, b).start();
        Thread.sleep(3);
        abcSynch.new ThreadPrinter2("C", b, c).start();
        Thread.sleep(3);


    }

    @Test
    public void reentrantLockTest() throws InterruptedException {
        ABCReentrantLock.A a = new ABCReentrantLock().new A();
        ABCReentrantLock.B b = new ABCReentrantLock().new B();
        ABCReentrantLock.C c = new ABCReentrantLock().new C();

        a.start();
        Thread.sleep(3);
        b.start();
        Thread.sleep(3);
        c.start();
        Thread.sleep(3);


    }
}
