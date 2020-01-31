package com.alevel.java.nix.array.extremtest;

import com.alevel.java.nix.array.findelem.FindExtrem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExtremTest {

    private FindExtrem findE;

    @Test
    public void extremTest() {
        int[] integers = {8, 5, 1, 0, -4, 16, -9, -15, 7, 11, -10, 0};

        int min = findE.findMin(integers);
        int max = findE.findMax(integers);

        assertEquals(-15, min);
        assertEquals(16, max);
    }
}
