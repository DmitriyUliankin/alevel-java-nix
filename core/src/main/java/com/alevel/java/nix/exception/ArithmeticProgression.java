package com.alevel.java.nix.exception;

public class ArithmeticProgression {

    private final int initial;
    private final int step;

    ArithmeticProgression(int initial, int step) throws ProgressionConfigurationException {
        if (step == 0) {
            throw new ProgressionConfigurationException("Step of progression can't be 0");
        } else {
            this.initial = initial;
            this.step = step;
        }
    }

    public int calculate(int n) throws ProgressionConfigurationException {
        if (n <= 0) {
            throw new ProgressionConfigurationException("Number of element of progress can't be negative or 0");
        } else if (step == 0) {
            throw new ProgressionConfigurationException("Step of progression can't be 0");
        } else {
            return (initial + (n - 1) * step);
        }
    }
}
