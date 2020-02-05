package com.alevel.java.nix.bitshift;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    private static FizzBuzz fb = new FizzBuzz();

    private List<Integer> getNum(String string) {
        char[] charArray = string.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (char value : charArray) {
            int num = Character.getNumericValue(value);
            list.add(num);
        }
        return list;
    }

    private String fizzBuzz(int num) {
        if (num % 6 == 0) {
            return "fizzbuzz";
        } else if (num % 3 == 0) {
            return "buzz";
        } else if (num % 2 == 0) {
            return "fizz";
        }
        return String.valueOf(num);
    }

    public void getFizzBuzz(int number) {
        while (number != 0) {
            int value = number % 10;
            number /= 10;
            fb.fizzBuzz(value);
        }
    }


    public List<Integer> digitsInNumber(int number) {
        String string = Integer.toString(number);
        return getNum(string);
    }

    public List<Integer> digitsInNumberReverse(int number) {
        String string = Integer.toString(number);

        int strValue = Integer.parseInt(new StringBuilder(string).reverse().toString());

        String revValue = Integer.toString(strValue);

        return getNum(revValue);
    }

    public static void main(String[] args) {
        fb.digitsInNumber(123_456);
        fb.getFizzBuzz(123_456);
    }
}