package com.alevel.java.nix.bitshift;

public class NumOfBit {

    public long getBitsCountForPos(long number) {
        long counter = 0L;
        for (long i = 0; i < number; i++) {
            if (((number >> i) & 1) != 0) {
                counter++;
            }
        }
        System.out.println(counter);
        return counter;
    }

    public long getBitsCountForNeg(long number) {
        long negNumber = ~number;
        long counter = 0L;
        for (long i = 0; i < negNumber; i++) {
            if (((negNumber << i) & 1) == 1) {
                counter++;
            }
        }
        System.out.println(counter);
        return counter;
    }
}
