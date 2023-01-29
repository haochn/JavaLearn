package pers.learn;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.Test;
import pers.learn.utils.GenerateReference;
import pers.learn.utils.Opencsv;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UtilsTest {

    public void test() {
        try {
            Class<?> portSynClass = Class.forName("com.im.ap.defactopost.syn.DefactoPortSynInventery");
            Object portSynClassInstance = portSynClass.newInstance();
            Method clearCurMaxSeqMap = portSynClass.getMethod("clearCurMaxSeqMap");
            clearCurMaxSeqMap.invoke(portSynClassInstance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testCsv() throws CsvValidationException, IOException {
        Opencsv opencsv = new Opencsv();
        opencsv.testcsv();
    }

    @Test
    public void testGenerateReference() throws IOException {
        GenerateReference generateReference = new GenerateReference();
        generateReference.main();
    }
}
