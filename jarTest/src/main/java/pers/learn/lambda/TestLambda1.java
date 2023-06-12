package pers.learn.lambda;

public class TestLambda1 {

    // 静态内部类
    static class AbcImpl2 implements Abc {

        @Override
        public void lambda() {
            System.out.println("abcImpl2");
        }
    }

    public static void main(String[] args) {
        new AbcImpl().lambda();
        new AbcImpl2().lambda();

        // 局部内部类
        class AbcImpl3 implements Abc {
            @Override
            public void lambda() {
                System.out.println("abcImpl3");
            }
        }
        new AbcImpl3().lambda();

        // 匿名内部类
        new Abc() {
            @Override
            public void lambda() {
                System.out.println("abcImpl4");
            }
        }.lambda();

        Abc abdImpl5 = () -> System.out.println("lambda");
        abdImpl5.lambda();

        Runnable lambda = () -> {
            System.out.println("lambda");
        };

    }
}

interface Abc {
    void lambda();
}

class AbcImpl implements Abc {

    @Override
    public void lambda() {
        System.out.println("abcImpl");
    }
}
