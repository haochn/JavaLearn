package pers.learn.utils;


import java.io.*;
import java.nio.charset.StandardCharsets;

public class GenerateReference {
    public void main() throws IOException {
        String filePath = "C:/Users/HAO/Desktop/CNKI-20230128232157050.txt";
        BufferedReader fileReader = getFileReader(filePath);
        String line;
        while ((line = fileReader.readLine()) != null) {

            String[] split = line.split(":  ", 2);
            String output = "";
            while (!"".equals(line)) {
                if (split[1].contains("期刊")) {
                    String[] tmp = line.split(":  ", 2);
                    if (tmp[0].contains("Title")) {
                        output = "《" + tmp[1] + "》，";
                    }
                    if (tmp[0].contains("Author")) {
                        String[] authors = tmp[1].split(";");
                        String author = String.join(",", authors);
                        output = author + "：" + output;
                    }
                    if (tmp[0].contains("Source")) {
                        output = output + "载《" + tmp[1] + "》";
                    }
                    if (tmp[0].contains("Year")) {
                        output = output + tmp[1] + "年";
                    }
                    if (tmp[0].contains("Period")) {
                        output = output + "第" + tmp[1] + "期。";
                    }
                }
                line = fileReader.readLine();
            }
            if (!"".equals(output)) {
                System.out.println(output);
            }
        }
        fileReader.close();
    }

    private BufferedReader getFileReader(String path) throws FileNotFoundException {
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        return new BufferedReader(inputStreamReader);
    }
}
