package com.alevel.java.nix.leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        int length = strings.length;
        String longestCommonPrefix = strings[0];
        int lengthCommonPrefix=longestCommonPrefix.length();
        for (int i = 1; i < length; i++) {
            int counter = 0;
            String currentString = strings[i];
            int lengthCurrent=currentString.length();
            while (counter < lengthCommonPrefix &&
                    counter < lengthCurrent &&
                    longestCommonPrefix.charAt(counter) == currentString.charAt(counter)) {
                counter++;
            }
            if (counter == 0) {
                return "";
            }
            longestCommonPrefix = longestCommonPrefix.substring(0, counter);
        }
        return longestCommonPrefix;
    }
}
