package pers.learn;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.Test;
import pers.learn.utils.GenerateReference;
import pers.learn.utils.Opencsv;
import pers.learn.utils.SqlUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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
        String diameter = "4";
        float d = Float.valueOf(diameter) / 10;
        System.out.println(d);

        GenerateReference generateReference = new GenerateReference();
        generateReference.main();
    }

    @Test
    public void sqlUtilsTest(){
        String midTable = "im_syn_defacto_port";
        String pipeInstId = "231012104066390229";
        HashSet<String> defactoIdsSet = new HashSet<>();

        defactoIdsSet.add("111");
        defactoIdsSet.add("111");
        defactoIdsSet.add("2");
        defactoIdsSet.add("3");

//
//        StringBuffer sql = new StringBuffer();
//        sql.append("select tb.ID_IN_NMS from ? tb where PIPE_INST_ID >? and HANDLE_STATE ='3S' and exists (select 1 from ? tb2 where tb.ID_IN_NMS = tb2.ID_IN_NMS and PIPE_INST_ID = ? and HANDLE_STATE='4S') " +
//                "union all " +
//                "select tb.ID_IN_NMS from ? tb where PIPE_INST_ID >? and HANDLE_STATE ='3S' and exists (select 1 from ? tb2 where tb.ID_IN_NMS = tb2.ID_IN_NMS and PIPE_INST_ID = ? and HANDLE_STATE='4S') ");
//
//        List<String[]> params = new ArrayList<>();
//        params.add(new String[]{midTable});
//        params.add(new String[]{pipeInstId, "1"});
//        params.add(new String[]{midTable, "0"});
//        params.add(new String[]{pipeInstId, "1"});
//        params.add(new String[]{midTable + "_his", "0"});
//        params.add(new String[]{pipeInstId, "1"});
//        params.add(new String[]{midTable, "0"});
//        params.add(new String[]{pipeInstId, "1"});
//
//        String s = SqlUtils.replaceQuestionMark(sql.toString(), params);
//
//        System.out.println(s);


        StringBuffer sb = new StringBuffer();
        sb.append("update ? tb set tb.HANDLE_STATE ='3S',tb.MODIFY_DATE =sysdate() where PIPE_INST_ID =? ");
        List<String[]> params = new ArrayList<>();
        params.add(new String[]{midTable});
        params.add(new String[]{pipeInstId,"1"});

        String condition = defactoIdsSet.stream().map(n -> "?").collect(Collectors.joining(",", " and ID_IN_NMS in (", ")"));
        sb.append(condition);
        defactoIdsSet.forEach(defactoId -> params.add(new String[]{defactoId,"1"}));

        String sql = SqlUtils.replaceQuestionMark(sb.toString(), params);
        System.out.println(sql);
    }
}
