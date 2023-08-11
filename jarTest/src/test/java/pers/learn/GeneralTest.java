package pers.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GeneralTest {
    public static final String SEPERATOR_CHAR_REGEX_CHAR = "\\$\\{2C\\}";

    @Test
    public void replaceTest(){
        String colData="Duarte Francois:02/05/2022:ne plus rien ajouter dans ce câble, il sera utilisé pour raccoder la boucle des POP 1239; 904; 267 au CT67[CR][LF]Gillen Jeff:18/05/2022:ne plus rien ajouter dans ce câble, il sera utilisé pour raccoder la boucle des POP 1239; 904; 267 au CT67";
        if (!"".equals(colData)) {
            colData = colData.replaceAll(",", "\\${2C}");
            colData = colData.replaceAll(";", "\\${3C}");
        }
        System.out.println(colData);
        colData = "Duarte Francois:02/05/2022:ne plus rien ajouter dans ce c?ble${2C} il sera utilis?? pour raccoder la boucle des POP 1239${3C} 904${3C} 267 au CT67[CR][LF]Gillen Jeff:18/05/2022:ne plus rien ajouter dans ce c?ble${2C} il sera utilis?? pour raccoder la boucle des POP 1239${3C} 904${3C} 267 au CT67";
        colData = colData.replaceAll(SEPERATOR_CHAR_REGEX_CHAR, ",");
        colData = colData.replaceAll("\\$\\{3C}", ";");
        System.out.println(colData);
    }

    @Test
    public void differentSet(){

        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        HashMap<String, String> map3 = new HashMap<>();
        HashMap<String, String> map4 = new HashMap<>();
        HashMap<String, String> map5 = new HashMap<>();

        map1.put("link_id","111");
        map2.put("link_id","222");
        map2.put("type","222");
        map3.put("link_id","333");
        map3.put("type","333");
        map4.put("link_id","333");
        map5.put("link_id","444");

        List<Map> list1=new ArrayList<>();
        list1.add(map1);
        list1.add(map2);
        list1.add(map3);

        List<Map> list2=new ArrayList<>();
        list2.add(map4);
        list2.add(map5);


//        System.out.println("====求交集===");
//
//        List<Integer> list=list1.stream().filter(t->list2.contains(t)).collect(Collectors.toList());
//        list.stream().forEach(System.out::println);




        System.out.println("====求差集===");
        List<Object> linkIds = list2.stream().map(t -> t.get("link_id")).collect(Collectors.toList());
//        System.out.println(linkIds);

        list1 = list1.stream().filter(t -> !linkIds.contains(t.get("link_id"))).collect(Collectors.toList());

//        list1=list1.stream().filter(t-> !list2.contains(t)).collect(Collectors.toList());
        System.out.println(list1);
    }
}
