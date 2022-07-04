package pers.learn.singleton;

//懒汉式单例
public class LazyMan {
    //构造器私有
    private LazyMan() {
        System.out.println(Thread.currentThread().getName() + "ok");
    }

    //volatile禁止指令重排
    private volatile static LazyMan lazyMan;

    //双重检测锁模式的懒汉式，DCL懒汉式
    public static LazyMan getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();
                    /**
                     * 不是原子性操作，会有指令重排
                     * 1.分配内存
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向这个空间
                     */
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LazyMan.getInstance();
            }).start();
        }
    }
}
