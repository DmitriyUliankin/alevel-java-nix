package com.alevel.java.nix.stream.returnpalindrome;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ReturnPalindrome {

    private static boolean isPalindrome(String string) {
        int start = 0;
        int end = string.length() - 1;

        while (start < end) {
            if (string.charAt(start++) != string.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public List<String> findPalindrome(Collection<String> strings){
        return strings.stream()
                .flatMap(s -> Arrays.stream(s.split("")))
                .filter(ReturnPalindrome::isPalindrome)
                .collect(Collectors.toList());
    }

}
