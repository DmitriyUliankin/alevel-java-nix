package com.alevel.java.nix.exception;

public class Main {

    public static void main(String[] args) {

        int initial = 0;
        int step = 1;
        int n = 1;

        try {
            ArithmeticProgression arithmeticProgression = new ArithmeticProgression(initial, step);
            arithmeticProgression.calculate(n);
        } catch (ProgressionConfigurationException e) {
            e.printStackTrace();
        }
    }
}
