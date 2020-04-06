package com.alevel.java.nix.gallows.model;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public final class Model {

    private static final Random RANDOM = new Random();

    private ArrayList<String> letters = new ArrayList<>();

    private String[] dictionary;
    private String wordToFind;
    private char[] wordFound;
    private int mistakes = 0;

    public int getMistakes() {
        return mistakes;
    }

    public String getWordToFind() {
        return wordToFind;
    }

    public boolean isWordFound() {
        return wordToFind.contentEquals(new String(wordFound));
    }

    public void readFileFromClasspath() {
        var url = this.getClass().getResource("/words.txt");
        try {
            loadResource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void blankWord() {
        wordToFind = randomWordToFind();
        wordFound = new char[wordToFind.length()];
        Arrays.fill(wordFound, '_');
    }

    public void guessWord(String input) {
        if (!letters.contains(input)) {
            if (wordToFind.contains(input)) {
                var index = wordToFind.indexOf(input);
                while (index >= 0) {
                    wordFound[index] = input.charAt(0);
                    index = wordToFind.indexOf(input, index + 1);
                }
            } else {
                mistakes++;
            }
            letters.add(input);
        }
    }

    public String buildWordFound() {
        var builder = new StringBuilder();
        for (int i = 0; i < getWordFound(); i++) {
            builder.append(wordFound[i]);
            if (i < wordFound.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    private void loadResource(URL url) throws IOException {
        if (url != null) {
            var path = url.getPath();
            path = path.replaceFirst("^/(.:/)", "$1");
            var string = new String(Files.readAllBytes(Paths.get(path)));
            dictionary = string.split(",");
        } else {
            System.out.println("no resource found: " + "/words.txt");
        }
    }

    private String randomWordToFind() {
        return dictionary[RANDOM.nextInt(dictionary.length)];
    }

    private int getWordFound() {
        return wordFound.length;
    }

}
