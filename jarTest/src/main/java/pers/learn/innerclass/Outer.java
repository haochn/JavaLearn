package pers.learn.innerclass;

public class Outer {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        Outer.StaticInner staticInner = new Outer.StaticInner();
        inner.inprint();
        inner.getId();
        // 没有 将 类 实例化 保存到变量中
        new Apple().eat();
        new UserService() {
            @Override
            public void hello() {
                System.out.println("UserService.hello");
            }

            @Override
            public void goodbye() {
                System.out.println("byebye");
            }
        };
        new UserService() {
            @Override
            public void hello() {
                System.out.println("UserService.hello1");
            }

            @Override
            public void goodbye() {
                System.out.println("byebye1");
            }
        }.goodbye();

        new AdminService() {

            @Override
            public void manage() {
                System.out.println("manage");
            }
        };
        ((AdminService) () -> {
            new Apple().eat();
            System.out.println("manage1");
        }).manage();
    }

    private int id = 10;

    public void outprint() {
        System.out.println("outer");
    }

    // 成员内部类
    public class Inner {
        public void inprint() {
            System.out.println("inner");
        }

        public void getId() {
            System.out.println(id);
        }
    }

    // 静态内部类
    public static class StaticInner {
        public StaticInner() {
            System.out.println("StaticInner");
        }

        public void staticInnerPrint() {
            System.out.println("StaticInner");
        }
    }

    // 局部内部类
    public void method() {
        class LocalInner {
            public void in() {
                System.out.println("localInner");
            }
        }
        LocalInner localInner = new LocalInner();
    }
}

class Apple {
    public void eat() {
        System.out.println("eat");
    }
}

interface UserService {
    void hello();

    void goodbye();
}

interface AdminService {
    void manage();
}
