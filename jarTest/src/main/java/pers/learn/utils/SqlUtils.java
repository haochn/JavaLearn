package pers.learn.utils;

import java.util.List;

/**
 * 用于组装sql
 */
public class SqlUtils {
    private static final String inSingleQuotation = "1";
    private static final char questionMark = '?';

    /**
     * 替换掉sql中的问号
     *
     * @param sql
     * @param params param是一个长度为2的数组，param[0]是替换值，param[1]是"1"时，表示使用单引号将替换值引起来
     * @return
     */
    public static String replaceQuestionMark(String sql, List<String[]> params) {
        char[] chars = sql.toCharArray();
        StringBuffer result = new StringBuffer();
        int paramIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (questionMark == chars[i]) {
                String[] param = params.get(paramIndex);
                paramIndex++;
                if (param.length > 1 && inSingleQuotation.equals(param[1])) {
                    result.append('\'');
                    result.append(param[0]);
                    result.append('\'');
                }
                else {
                    result.append(param[0]);
                }
            }
            else {
                result.append(chars[i]);
            }
        }
        return result.toString();
    }
}
