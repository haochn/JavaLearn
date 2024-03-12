package pers.learn.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleCSVReader implements ICSVReader {

    private BufferedReader reader;
    private char separator;
    private char quoteChar;
    private boolean inQuotes = false;

    public SimpleCSVReader(String filePath, char separator, char quoteChar) throws IOException {
        this.reader = new BufferedReader(new FileReader(filePath));
        this.separator = separator;
        this.quoteChar = quoteChar;
    }

    public SimpleCSVReader(String filePath) throws IOException {
        this(filePath, ',', '"');
    }

    @Override
    public List<String> readNext() throws IOException {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null || sb.length() > 0) {
            if (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (inQuotes) {
                        if (c == quoteChar) {
                            // 检查下一个字符是否也是引号字符（转义的引号）
                            if (i + 1 < line.length() && line.charAt(i + 1) == quoteChar) {
                                // 为转义的引号对添加一个单引号
                                sb.append(c);
                                i++; // 跳过下一个字符，因为它是转义引号的一部分
                            }
                            else {
                                // 引号结束
                                inQuotes = false;
                            }
                        }
                        else {
                            sb.append(c);
                        }
                    }
                    else {
                        if (c == quoteChar) {
                            // 开始引号
                            inQuotes = true;
                        }
                        else if (c == separator) {
                            // 分隔符，添加字段并重置StringBuilder
                            tokens.add(sb.toString());
                            sb = new StringBuilder();
                        }
                        else {
                            sb.append(c);
                        }
                    }
                }
            }

            if (!inQuotes) {
                // 如果不在引号内，表示我们已经完成了这行或者这部分的解析
                if (sb.length() > 0 || line != null) { // 确保添加最后一个字段
                    tokens.add(sb.toString());
                    sb.setLength(0); // 为下一行/字段重置StringBuilder
                }
                break; // 跳出循环并返回结果
            }
            else {
                // 如果在引号内，添加换行符以正确解析多行字段
                sb.append('\n');
            }
        }

        if (tokens.isEmpty() && line == null) {
            // 文件末尾
            return null;
        }

        return tokens;
    }

    @Override
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }
}


