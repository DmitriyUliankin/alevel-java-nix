package com.alevel.java.nix.array.findelem;

import java.util.Arrays;

public class FindExtrem {
    public static int findMax(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    public static int findMin(int[] arr) {
        return Arrays.stream(arr).min().getAsInt();
    }
}
