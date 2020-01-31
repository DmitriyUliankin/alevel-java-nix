package com.alevel.java.nix.array.sort;

public class BubbleSort {
    public int[] bubbleSort(int[] array) {
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    Swap.swap(array, i);
                    sorted = false;
                }
            }
        }
        return array;
    }
}
