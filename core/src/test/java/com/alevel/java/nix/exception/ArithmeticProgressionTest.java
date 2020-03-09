package com.alevel.java.nix.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticProgressionTest {

    private ArithmeticProgression arithmeticProgression;
    private int initial = 0;
    private int step = 0;

    @BeforeEach
    public void initialize() {
        try {
            arithmeticProgression = new ArithmeticProgression(initial, step);
        } catch (ProgressionConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldThrowException() {
        assertThrows(ProgressionConfigurationException.class, () -> arithmeticProgression.calculate(0));
    }
}