package com.alevel.java.nix.array.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTest {

    @Test
    public void testTranspose() {
        int[][] matrix = {{1, 3, 5},
                {2, 4, 6}};
        Matrix matrixTranspose = new Matrix(matrix);
        matrixTranspose.transpose();

        assertEquals(1, matrixTranspose.get(0, 0));
        assertEquals(2, matrixTranspose.get(0, 1));
        assertEquals(3, matrixTranspose.get(1, 0));
        assertEquals(4, matrixTranspose.get(1, 1));
        assertEquals(5, matrixTranspose.get(2, 0));
        assertEquals(6, matrixTranspose.get(2, 1));
    }

}