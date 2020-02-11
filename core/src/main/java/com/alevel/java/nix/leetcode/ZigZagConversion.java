package com.alevel.java.nix.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    private int[] indices;

    public String convert(String string, int numRows) {
        if (numRows <= 0) {
            return "incorrect";
        } else if (numRows == 1) {
            return string;
        }

        constructIndices(numRows);

        int index = 0;
        int length = string.length();
        List<StringBuilder> strs = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            strs.add(new StringBuilder());
        }
        for (int i = 0; i < length; i++) {
            if (index == indices.length) {
                index = 0;
            }
            int j = indices[index];
            strs.get(j).append(string.charAt(i));
            index++;
        }
        return String.join("", strs);
    }

    private void constructIndices(int length) {
        indices = new int[length + length - 2];
        int index = 0;
        for (int i = 0; i < length; i++) {
            indices[index++] = i;
        }
        for (int i = 0; i < length - 2; i++) {
            indices[index++] = length - 2 - i;
        }
    }
}
