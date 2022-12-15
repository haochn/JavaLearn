package pers.learn;

import org.junit.Test;

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
}
