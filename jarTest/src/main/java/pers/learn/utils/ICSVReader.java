package pers.learn.utils;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public interface ICSVReader extends Closeable {
    List<String> readNext() throws IOException;

    @Override
    void close() throws IOException;
}