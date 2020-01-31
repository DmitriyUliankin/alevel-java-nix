package com.alevel.java.nix.array.extremtest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ExtremTest {
    @Test
    public void ExtremTest() {
        int[] integers = {8, 5, 1, 0, -4, 16, -9, -15, 7, 11, -10, 0};

        int min = Arrays.stream(integers)
                .min()
                .getAsInt();
        int max = Arrays.stream(integers)
                .max()
                .getAsInt();

        assertEquals(-15, min);
        assertEquals(16, max);
    }
}
