package leetcode.lc174;

import algorithms.utils.MatrixUtils;

/**
 * Created by wangdehao on 19/4/11.
 */
public class DungeonGame {
    public static void main(String[] args) {
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        System.out.println(calculateMinimumHP(dungeon));
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        // types.dp-memo
        int m = dungeon.length;
        int n = dungeon[0].length;
        if (m <= 0 || n <= 0) {
            return 1;
        }
        if (m == 1 && n == 1) {
            return Math.max(1 - dungeon[m - 1][n - 1], 1);

        }
        int[][] memo = new int[m][n];
        // to keep alive
        memo[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

        MatrixUtils.printMatrix(memo);
        // fill 2 lines
        if (n > 1) {
            for (int j = n - 2; j >= 0; j--) {
                memo[m - 1][j] = Math.max(memo[m - 1][j + 1] - dungeon[m - 1][j], 1);
            }
        }
        MatrixUtils.printMatrix(memo);
        if (m > 1) {
            for (int i = m - 2; i >= 0; i--) {
                memo[i][n - 1] = Math.max(memo[i + 1][n - 1] - dungeon[i][n - 1], 1);
            }
        }
        MatrixUtils.printMatrix(memo);

        // types.dp
        if (m > 1 && n > 1) {
            for (int i = m - 2; i >= 0; i--) {
                for (int j = n - 2; j >= 0; j--) {
                    memo[i][j] = Math.max(-dungeon[i][j] + Math.min(memo[i + 1][j], memo[i][j + 1]), 1);
                }
            }
        }

        MatrixUtils.printMatrix(memo);

        return memo[0][0];
    }
}
