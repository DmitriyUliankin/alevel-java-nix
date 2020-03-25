package com.alevel.java.nix.io.stringreader;

import java.io.*;
import java.util.StringJoiner;

public class ReadByString {

    public void readString(CharSequence sequence) {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(
                "core/src/main/java/com/alevel/java/nix/io/files/sample.txt"))) {
            var stringJoiner = new StringJoiner(", ");
            String reader;
            while ((reader = inputStream.readLine()) != null) {
                if (reader.contains(sequence)) {
                    stringJoiner.add(reader);
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
