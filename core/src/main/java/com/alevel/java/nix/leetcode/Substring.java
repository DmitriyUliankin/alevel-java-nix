package com.alevel.java.nix.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Substring {

    private String output = "";

    String getUniqueCharacterSubstring(String input) {
        int length = input.length();
        if (length == 0) {
            return input;
        }
        Map<Character, Integer> visited = new HashMap<>();
        for (int start = 0, end = 0; end < length; end++) {
            char current = input.charAt(end);
            if (visited.containsKey(current)) {
                start = Math.max(visited.get(current) + 1, start);
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            visited.put(current, end);
        }
        return output;
    }

    public static void main(String[] args) {
        Substring substring = new Substring();
        substring.getUniqueCharacterSubstring("abca");
    }
}
