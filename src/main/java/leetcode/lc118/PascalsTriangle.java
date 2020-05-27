package leetcode.lc118;

import algorithms.utils.MatrixUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdehao on 18/12/3.
 */
public class PascalsTriangle {
    public static void main(String[] args) {

        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
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
        for (int k = 0; k < numRows; k++) {
            List<Integer> level = new ArrayList<>();
            for (int l = 0; l <= k; l++){
                level.add(pascalMatrix[l][k-l]);
            }
            result.add(level);
        }

        return result;
    }
}
