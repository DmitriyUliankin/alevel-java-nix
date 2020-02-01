package com.alevel.java.nix.array.multiplicity;

import com.alevel.java.nix.array.printer.Printer;

import java.util.Arrays;

public class FindNum {
    public int[] findNum(int[] arr) {

        //int num = Scanner.getNum();
        int num = 5;

        int[] newarr = Arrays.stream(arr).filter(i -> i % num == 0).toArray();

        Printer.print(newarr);

        return newarr;
    }
}
