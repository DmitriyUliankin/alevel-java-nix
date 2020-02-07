package com.alevel.java.nix.array.matrix;

public class Matrix {

    private int[][] array;

    public Matrix(int[][] arrayOfArrays) {
        array = new int[arrayOfArrays.length][arrayOfArrays[0].length];

        for (int r = 0; r < arrayOfArrays.length; r++) {
            System.arraycopy(arrayOfArrays[r], 0, array[r], 0, arrayOfArrays[r].length);
        }
    }

    public int get(int row, int column) {
        return array[row][column];
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int[] ints : array) {
            for (int anInt : ints) {
                res.append(anInt);
            }
        }
        return res.toString();
    }

    public void transpose() {
        int row = array.length;
        int column = array[0].length;

        int[][] transpose = new int[column][row];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                transpose[c][r] = array[r][c];
            }
        }
        array = transpose;
    }
}
