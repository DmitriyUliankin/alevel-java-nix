package com.alevel.java.nix.array.extremtest;

import com.alevel.java.nix.array.finder.findextrem.FindExtrem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExtremTest {

    private FindExtrem findE;

    @BeforeEach
    void setUp() {
        findE = new FindExtrem();
    }

    @Test
    public void extremTest() {
        int[] integers = {8, 5, 1, 0, -4, 16, -9, -15, 7, 11, -10, 0};

        int min = findE.findMin(integers);
        int max = findE.findMax(integers);

        assertEquals(-15, min);
        assertEquals(16, max);
    }
}
