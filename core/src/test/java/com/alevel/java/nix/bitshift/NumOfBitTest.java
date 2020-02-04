package com.alevel.java.nix.bitshift;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumOfBitTest {

    private static NumOfBit numOfBit;

    private long number1 = 0b0000_0000_0000_0000_0000_0000_0000_0110_0110_0001_1100_0011_0000_1111_1110_0110L;
    private long number2 = 0L;
    private long number3 = 7L;
    private long number4 = ~number3;

    @BeforeEach
    void setUp() {
        numOfBit = new NumOfBit();
    }

    @Test
    public void numOfBits() {
        assertEquals(numOfBit.getBitsCountForPos(number1), 7709056128L);
        assertEquals(numOfBit.getBitsCountForPos(number2), 0);
        assertEquals(numOfBit.getBitsCountForNeg(number2), 0);
        assertEquals(numOfBit.getBitsCountForPos(number3), 3);
        assertEquals(numOfBit.getBitsCountForNeg(number4), 1);
    }
}