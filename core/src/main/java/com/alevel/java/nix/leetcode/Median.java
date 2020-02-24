package com.alevel.java.nix.leetcode;

import java.util.Arrays;

public class Median {
    public double findMedianSortedArrays(int[] firstArray, int[] secondArray) {
        if (firstArray == null || secondArray == null) {
            throw new IllegalArgumentException();
        }
        if (firstArray.length == 0 || secondArray.length == 0) {
            return 0;
        }
        if (!isSorted(firstArray)) {
            Arrays.sort(firstArray);
        }
        if (!isSorted(secondArray)) {
            Arrays.sort(secondArray);
        }
        if (firstArray.length > secondArray.length) {
            return findMedianSortedArrays(secondArray, firstArray);
        }
        int x = firstArray.length;
        int y = secondArray.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : firstArray[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : firstArray[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : secondArray[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : secondArray[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    private static boolean isSorted(int[] array) {
        int[] newArray = Arrays.copyOf(array, array.length);
        Arrays.sort(newArray);
        return Arrays.equals(array, newArray);
    }
}
