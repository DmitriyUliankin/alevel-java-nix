package com.alevel.csvmapper.parser;

import com.alevel.csvmapper.table.Row;
import com.alevel.csvmapper.table.Table;

import java.io.*;

public final class FileParser implements Parser<File> {

    @Override
    public Table parse(File target) {
        try (var reader = new BufferedReader(new FileReader(target))) {
            var header = reader.readLine();
            var table = new Table(Row.parseLine(header));
            String string;
            while ((string = reader.readLine()) != null) {
                table.addRow(Row.parseLine(string));
            }
            return table;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
