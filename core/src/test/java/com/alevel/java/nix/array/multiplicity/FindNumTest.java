package com.alevel.java.nix.array.multiplicity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindNumTest {

    private FindNum findN;
    private int num = 5;
    private int[] integers = {8, 5, 1, 0, -4, 16, -9, -15, 7, 11, -10, 0};

    @BeforeEach
    void setUp() {
        findN = new FindNum();
    }

    @Test
    public void findNumTest() {
        int[] actual = findN.findNum(integers);
        assertArrayEquals(Arrays.stream(integers).filter(i -> i % num == 0).toArray(), actual);
    }
}