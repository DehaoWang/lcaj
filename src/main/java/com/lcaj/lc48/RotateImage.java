package com.lcaj.lc48;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import static com.lcaj.util.MatrixMethods.printMatrix;

/**
 * Created by wangdehao on 18/11/4.
 */
public class RotateImage {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printMatrix(matrix);
    }

    public static void rotate90(int[][] matrix) {
        // first row -> last column
        int m = matrix.length;
        int n = matrix[0].length;


    }
}
