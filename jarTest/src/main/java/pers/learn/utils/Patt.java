package pers.learn.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patt {


    //        private static final String REGEX = "(((\"[^\"]*\")|[^\",])*)(,|$)";
    private static final String REGEX = "\\G(?:^|,)(?:\"([^\"]*+(?:\"\"[^\"]*+)*+)\"|([^\",]*+))";
    private static final String INPUT =
            "86233268,86233263,2,Optical,1,2,3,Available,Reserved,\"REM Rack 19\"\" Indoor\",24773332[00000-0001#0001][00000-0012#0001][00000-0001#0001],M,65";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;
        String colData;
        while (m.find()) {
            count++;
            colData = m.group();
            System.out.println(colData);
            System.out.println("Match number " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
        }
    }

    public String convertLine(String srcLine, String separatorChar) {
        String regExp = getRegExp(separatorChar);
        String colData = "";

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(srcLine);
        StringBuffer convertLine = new StringBuffer();
        while (matcher.find()) {
            colData = matcher.group();
            colData = colData.trim();
//            if (colData.startsWith(separatorChar)) {
//                colData = colData.substring(1);
//                colData = colData.trim();
//            }
            if (colData.endsWith(separatorChar)) {
                colData = colData.substring(0,colData.length()-1);
                colData = colData.trim();
            }
            if (colData.startsWith("\"") && colData.endsWith("\"")) {
                colData = colData.substring(1, colData.length() - 1);
                if (isExisted("\"\"", colData)) {
                    colData = colData.replaceAll("\"\"", "\"");
                }
            }
            if (!"".equals(colData)) {
                colData = colData.replaceAll(",", "\\${2C}");
                colData = colData.replaceAll(";", "\\${3C}");

            }
            convertLine.append(separatorChar).append(colData);
        }
        String ret = convertLine.toString();
        if (ret.startsWith(separatorChar)) {
            ret = ret.substring(1);
        }
        if (!ret.endsWith(separatorChar)) {
            ret = ret.substring(0, convertLine.length() - 1);
        }
        return ret;
    }

    private boolean isExisted(String argChar, String convertString) {
        boolean blnReturnValue = false;
        if ((convertString.indexOf(argChar) >= 0) && (convertString.indexOf(argChar) <= convertString.length())) {
            blnReturnValue = true;
        }
        return blnReturnValue;
    }

    private String getRegExp(String separatorChar) {
        String strRegExp = "";
        /*strRegExp = "\"((" + SPECIAL_CHAR_A + "*[,\n 　])*(" + SPECIAL_CHAR_A + "*\"{2})*)*" + SPECIAL_CHAR_A
            + "*\"[ 　]*,[ 　]*" + "|" + SPECIAL_CHAR_B + "*[ 　]*,[ 　]*" + "|\"((" + SPECIAL_CHAR_A + "*[,\n 　])*("
            + SPECIAL_CHAR_A + "*\"{2})*)*" + SPECIAL_CHAR_A + "*\"[ 　]*" + "|" + SPECIAL_CHAR_B + "*[ 　]*";*/
//        strRegExp = "(((\"[^\"]*\")|[^\"" + separatorChar + "])*)(" + separatorChar + "|$)";
//        "\\G(?:^|,)(?:\"([^\"]*+(?:\"\"[^\"]*+)*+)\"|([^\",]*+))"
        strRegExp = "\\G(?:^|" + separatorChar + ")(?:\"([^\"]*+(?:\"\"[^\"]*+)*+)\"|([^\"" + separatorChar + "]*+))";
//        strRegExp ="([\"]*)([\"]*)(,|$)";
        strRegExp="\\G(?:\"([^\"]*+(?:\"\"[^\"]*+)*+)\"|([^\"" + separatorChar + "]*+))(?:" + separatorChar + "|$)";
        return strRegExp;
    }

}
