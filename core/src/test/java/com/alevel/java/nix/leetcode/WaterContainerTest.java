package com.alevel.java.nix.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaterContainerTest {

    private WaterContainer wc = new WaterContainer();

    @Test
    void returnMax() {
        assertEquals(0, wc.maxWater(new int[]{-1}));
        assertEquals(0, wc.maxWater(null));
        assertEquals(0, wc.maxWater(new int[]{0, 0, 0}));
        assertEquals(10, wc.maxWater(new int[]{0, 1, -1, 2, 1, 10, 15}));
        assertEquals(25, wc.maxWater(new int[]{0, 5, 3, 8, 1, 10, 15}));
    }
}