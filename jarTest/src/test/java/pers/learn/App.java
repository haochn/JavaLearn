package pers.learn;

import pers.learn.innerclass.Outer;

public class App {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.inprint();
        Outer.StaticInner staticInner = new Outer.StaticInner();

    }
}
