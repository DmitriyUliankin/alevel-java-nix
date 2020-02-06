package com.alevel.java.nix.array.findextrem;

import java.util.Arrays;

public class FindExtrem {
    public int findMax(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    public int findMin(int[] arr) {
        return Arrays.stream(arr).min().getAsInt();
    }
}
