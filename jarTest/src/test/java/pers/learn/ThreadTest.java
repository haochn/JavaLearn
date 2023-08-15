package pers.learn;

import org.junit.Test;
import pers.learn.thread.*;

import java.util.ArrayList;
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
    public void myThread() {
        MyThread hello = new MyThread("hello");
        MyThread world = new MyThread("world");
        hello.start();
        world.start();
    }

    @Test
    public void lotteryTest() throws InterruptedException {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(100);
        arr.add(100);
        arr.add(1000);
        arr.add(10000);
        arr.add(10001);
        arr.add(10002);
        arr.add(10003);
        arr.add(10004);
        arr.add(10005);


        Lottery lottery1 = new Lottery("抽奖箱1", arr);
        Lottery lottery2 = new Lottery("抽奖箱2", arr);

        Thread.sleep(3);
        lottery1.start();
        lottery2.start();

        lottery2.join();
        lottery1.join();
        System.out.println(arr);
    }
}
