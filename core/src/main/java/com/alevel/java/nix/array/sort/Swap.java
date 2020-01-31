package com.alevel.java.nix.array.sort;

public class Swap {
    protected static void swap(int[] array, int i) {
        int temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;
    }
}
