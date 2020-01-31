package com.alevel.java.nix.array.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    public void bubbleSort() {
        int[] integers = new int[]{-15, -10, -9, -4, 0, 0, 1, 5, 7, 8, 11, 16};

        assertArrayEquals(integers,BubbleSort.bubbleSort(integers));
    }
}