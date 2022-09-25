package pers.learn.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class Opencsv {

    public void testcsv() throws IOException, CsvValidationException {
        CSVReader reader = new CSVReaderBuilder(new FileReader("C:\\Users\\HAO\\Desktop\\1.csv")).build();
        String[] nextLine;
        int i = 0;
        while ((nextLine = reader.readNext()) != null) {
            for (String s : nextLine) {
                System.out.print(++i);
                System.out.print(":");
                System.out.println(s);
            }
            i = 0;
            System.out.println("-------------");
        }
    }
}
