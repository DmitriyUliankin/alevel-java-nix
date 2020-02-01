package com.alevel.java.nix.array.main;

import com.alevel.java.nix.array.findelem.FindExtrem;
import com.alevel.java.nix.array.multiplicity.FindNum;
import com.alevel.java.nix.array.printer.Printer;
import com.alevel.java.nix.array.sort.BubbleSort;

public class Main {

    private static FindExtrem findE;
    private static BubbleSort bubbleS;
    private static FindNum findN;

    public static void main(String[] args) {

        int[] arr = {8, 5, 1, 0, -4, 16, -9, -15, 7, 11, -10, 0};

        Printer.print(arr);

        System.out.println();
        System.out.println("Min value: " + findE.findMin(arr));
        System.out.println("Max value: " + findE.findMax(arr));

        bubbleS.bubbleSort(arr);
        Printer.print(arr);

        System.out.println();

        findN.findNum(arr);
    }
}
