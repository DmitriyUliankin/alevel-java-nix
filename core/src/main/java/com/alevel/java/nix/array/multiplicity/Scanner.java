package com.alevel.java.nix.array.multiplicity;

public class Scanner {
    protected static int getNum() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Enter number of multiples we will look for: ");
        return sc.nextInt();
    }
}
