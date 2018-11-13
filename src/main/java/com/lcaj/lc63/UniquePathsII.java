package com.lcaj.lc63;

import static com.lcaj.util.MatrixMethods.printMatrix;

/**
 * Created by wangdehao on 18/11/12.
 */
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] grid1 = {
                {0, 0},
                {1, 1},
                {0, 0}
        };

        System.out.println(uniquePathsWithObstacles(grid));
        System.out.println(uniquePathsWithObstacles(grid1));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        boolean findObstacle = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0 && !findObstacle) {
                memo[i][0] = 1;
            } else {
                memo[i][0] = 0;
                findObstacle = true;
            }
        }
        findObstacle = false;
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 0 && !findObstacle) {
                memo[0][j] = 1;
            } else {
                memo[0][j] = 0;
                findObstacle = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    memo[i][j] = 0;
                } else {
                    memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
                }
            }
        }
        return memo[m - 1][n - 1];
    }
}
