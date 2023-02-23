package pers.learn.test;

import java.util.HashMap;

public class ConcatTest {

    public static void main(String[] args) {
        String s = "abc";
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        String concat = s.concat("#") + stringStringHashMap.get("1");
        System.out.println(concat);
    }


}
