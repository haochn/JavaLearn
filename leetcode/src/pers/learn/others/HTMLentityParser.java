package pers.learn.others;

import java.util.HashMap;
import java.util.Map;

public class HTMLentityParser {
    /**
     * 1410. HTML 实体解析器
     * 「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。
     * <p>
     * HTML 里这些特殊字符和它们对应的字符实体包括：
     * <p>
     * 双引号：字符实体为 &quot; ，对应的字符是 " 。
     * 单引号：字符实体为 &apos; ，对应的字符是 ' 。
     * 与符号：字符实体为 &amp; ，对应对的字符是 & 。
     * 大于号：字符实体为 &gt; ，对应的字符是 > 。
     * 小于号：字符实体为 &lt; ，对应的字符是 < 。
     * 斜线号：字符实体为 &frasl; ，对应的字符是 / 。
     * 给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。
     *
     * @param text
     * @return
     */
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>(16);
        StringBuffer result = new StringBuffer();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");

        for (int i = 0; i < text.length(); i++) {
            if ('&' == text.charAt(i)) {
                StringBuffer tmp = new StringBuffer().append('&');
                boolean flag = false;
                for (int j = 1; j < 7 && j < text.length() - i; j++) {
                    if (map.containsKey(tmp.append(text.charAt(i + j)).toString())) {
                        result.append(map.get(tmp.toString()));
                        flag = true;
                        i += j;
                        break;
                    }
                }
                if (!flag) {
                    result.append('&');
                }
            }
            else {
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        HTMLentityParser htmLentityParser = new HTMLentityParser();
        String s = htmLentityParser.entityParser("&&gt;");
        System.out.println(s);
    }
}
