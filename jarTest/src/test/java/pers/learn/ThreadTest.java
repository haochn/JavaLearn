package pers.learn;

import org.junit.Test;
import pers.learn.thread.ABCReentrantLock;
import pers.learn.thread.ABCSynch;
import pers.learn.thread.MyCallable;
import pers.learn.thread.MyThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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


    @Test
    public void callableTest() throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(myCallable);
        new Thread(integerFutureTask).start();
        while (!integerFutureTask.isDone()) {
            System.out.println(integerFutureTask.isDone());
        }
        System.out.println(integerFutureTask.get());
    }

    @Test
    public void myThread(){
        MyThread hello = new MyThread("hello");
        MyThread world = new MyThread("world");
        hello.start();
        world.start();
    }
}
