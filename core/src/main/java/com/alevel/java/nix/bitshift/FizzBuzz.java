package com.alevel.java.nix.bitshift;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    private List<Integer> getNums(String string) {
        char[] charArray = string.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (char value : charArray) {
            int num = Character.getNumericValue(value);
            list.add(num);
        }
        return list;
    }

    public List<Integer> digitsInNumber(int number) {
        String string = Integer.toString(number);
        return getNums(string);
    }

    public List<Integer> digitsInNumberReverse(int number) {
        String string = Integer.toString(number);

        int strValue = Integer.parseInt(new StringBuilder(string).reverse().toString());

        String revValue = Integer.toString(strValue);

        return getNums(revValue);
    }

    public String fizzBuzz(int number) {

        if (number % 6 == 0) {
            return "fizzbuzz";
        } else if (number % 3 == 0) {
            return "buzz";
        } else if (number % 2 == 0) {
            return "fizz";
        }
        return String.valueOf(number);
    }
}