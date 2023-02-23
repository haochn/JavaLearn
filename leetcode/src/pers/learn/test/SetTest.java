package pers.learn.test;

import pers.learn.forSet.MyHashMap;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {

        Set<Map<String, String>> cacheMigCircuitSet = Collections.synchronizedSet(new HashSet<>());

        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        map1.put("test","test");
        map1.put("A","A");
        map2.put("A","A");
        map2.put("test","test");
        map2.put("","");
        System.out.println(map2.hashCode());
        System.out.println(map1.hashCode());
        System.out.println(map1.equals(map2));

        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();
        hashMaps.add(map1);
        hashMaps.add(map2);
        ArrayList<HashMap<String, String>> maps = new ArrayList<>();
        maps.add(map1);
        maps.add(map2);

        cacheMigCircuitSet.add(map1);
        cacheMigCircuitSet.add(map2);
        cacheMigCircuitSet.addAll(hashMaps);
        cacheMigCircuitSet.addAll(maps);

        System.out.println(cacheMigCircuitSet);
    }
}
