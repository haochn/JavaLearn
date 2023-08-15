package pers.learn.thread;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lottery extends Thread {
    List list;

    public Lottery(String name, List list) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {

        while (!list.isEmpty()) {
            synchronized (Lottery.class) {
                Random random = new Random();
                if (!list.isEmpty()) {
                    Collections.shuffle(list);
                    int i = (int) list.remove(list.size() - 1);
                    System.out.println(getName() + "@产生了一个" + i + "元大奖");
//                    int i = random.nextInt(list.size()) + 1;
//                    System.out.println(getName() + "@产生了一个" + list.get(i - 1) + "元大奖");
//                    list.remove(i - 1);
                }
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
