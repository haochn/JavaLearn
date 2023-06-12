package pers.learn.lambda;

import java.util.function.IntBinaryOperator;

public class TestLambda2 {
    public static void main(String[] args) {
        Aa lambdaAdd = (int a, int b) -> {
            return a + b;
        };
        lambdaAdd.add(2,4);

        Aa lambdaAdd2 = (a, b) -> a + b;
        lambdaAdd2.add(1, 2);
    }


}

interface Aa {
    int add(int a, int b);
}