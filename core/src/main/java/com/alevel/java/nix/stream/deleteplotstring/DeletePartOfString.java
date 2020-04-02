package com.alevel.java.nix.stream.deleteplotstring;

import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DeletePartOfString {

    public List<String> deleteStringPart(Collection<String> strings, Pattern pattern) {
        return strings.stream()
                .map(s -> pattern.matcher(s).replaceAll(""))
                .collect(Collectors.toList());
    }

}
