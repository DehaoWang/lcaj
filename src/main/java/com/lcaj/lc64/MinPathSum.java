package com.lcaj.lc64;

import static com.lcaj.util.MatrixMethods.printMatrix;

/**
 * Created by wangdehao on 18/11/13.
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(minPathSum(grid));

    }

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] memo = new int[m][n];

        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            memo[i][0] = sum;
        }
        sum = 0;
        for (int j = 0; j < n; j++) {
            sum += grid[0][j];
            memo[0][j] = sum;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = (memo[i - 1][j] > memo[i][j - 1] ? memo[i][j - 1] : memo[i - 1][j]) + grid[i][j];
            }
        }
        return memo[m - 1][n - 1];
    }
}
