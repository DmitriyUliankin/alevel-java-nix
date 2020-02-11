package com.alevel.java.nix.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZigZagConversionTest {

    ZigZagConversion solution = new ZigZagConversion();

    @Test
    public void zigZagTest() {
        String string = "PAYPALISHIRING";
        int B = 3;
        String actual = solution.convert(string, B);
        String expected = "PAHNAPLSIIGYIR";
        assertEquals(expected, actual);

        string = "ABCD";
        B = 2;
        actual = solution.convert(string, B);
        expected = "ACBD";
        assertEquals(expected, actual);
    }
}