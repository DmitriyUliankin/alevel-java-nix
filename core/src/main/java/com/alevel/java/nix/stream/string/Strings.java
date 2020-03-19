package com.alevel.java.nix.stream.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Strings {

    public void numbersInStringList(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("string 1 text");
        stringList.add("2 string 3 text");
        stringList.add("45");

        var numbers = stringList.stream()
                .map(x -> x.replaceAll("[^-?0-9]+", ""))
                .collect(Collectors.joining());
    }

}
