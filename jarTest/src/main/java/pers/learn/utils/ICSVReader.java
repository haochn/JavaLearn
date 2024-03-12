package pers.learn.utils;

import java.io.IOException;
import java.util.List;

public interface ICSVReader {
    List<String> readNext() throws IOException;
}