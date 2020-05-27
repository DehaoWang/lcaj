package leetcode.lc119;

import algorithms.utils.MatrixUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdehao on 18/12/3.
 */
public class PascalsTriangleII {
    public static void main(String[] args) {

        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        int numRows = rowIndex + 1;
        // build matrix
        int[][] pascalMatrix = new int[numRows][numRows];
        // set ones
        for (int i = 0; i < numRows; i++) {
            pascalMatrix[i][0] = 1;
        }
        for (int j = 0; j < numRows; j++) {
            pascalMatrix[0][j] = 1;
        }
        // fill in
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numRows; j++) {
                if (i + j >= numRows) {
                    continue;
                }
                pascalMatrix[i][j] = pascalMatrix[i - 1][j] + pascalMatrix[i][j - 1];
            }
        }
        MatrixUtils.printMatrix(pascalMatrix);
        // build matrix: sum = k
        List<Integer> level = new ArrayList<>();
        for (int l = 0; l <= rowIndex; l++) {
            level.add(pascalMatrix[l][rowIndex - l]);
        }

        return level;
    }

}
