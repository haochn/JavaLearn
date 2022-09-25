package pers.learn;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.Test;
import pers.learn.utils.Opencsv;

import java.io.IOException;

public class UtilsTest {
    @Test
    public void testCsv() throws CsvValidationException, IOException {
        Opencsv opencsv = new Opencsv();
        opencsv.testcsv();
    }
}
