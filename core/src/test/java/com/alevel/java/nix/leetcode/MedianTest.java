package com.alevel.java.nix.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianTest {

    private Median median;
    private int[] firstArray;
    private int[] secondArray;

    @BeforeEach
    private void newMedian() {
        median = new Median();
    }

    @Test
    public void nullCheckShouldThrowException() {
        firstArray = null;
        secondArray = null;
        try {
            median.findMedianSortedArrays(firstArray, secondArray);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Test
    public void shouldSort() {
        firstArray = new int[]{1, 2, 3, 4, 5};
        secondArray = new int[]{4, 3, 5, 2, 1};
        assertEquals(3, median.findMedianSortedArrays(firstArray, secondArray));

        firstArray = new int[]{7, 6, 5, 4, 3, 2, 1};
        secondArray = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertEquals(5, median.findMedianSortedArrays(firstArray, secondArray));

        firstArray = new int[]{5, 4, 6, 3, 2, 7, 1};
        secondArray = new int[]{2, 3, 4, 8, 7, 6, 1, 10, 5, 9};
        assertEquals(5, median.findMedianSortedArrays(firstArray, secondArray));

        firstArray = new int[]{-1, -2, -3, -4, -5};
        secondArray = new int[]{0, -2, -3, 1};
        assertEquals(-2, median.findMedianSortedArrays(firstArray, secondArray));
    }

    @Test
    public void shouldReturnZero(){
        firstArray = new int[]{};
        secondArray = new int[]{};
        assertEquals(0, median.findMedianSortedArrays(firstArray, secondArray));
    }
}