package com.lcaj.lc256;

/**
 * Created by wangdehao on 19/5/14.
 */
public class PaintHouse {
    public static void main(String[] args) {
        int[][] costs = {
                {17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}
        };
        System.out.println(minCostGreedy(costs));
        System.out.println(minCostDP(costs));

        int[][] costs2 = {
                {7, 6, 2},
        };
        System.out.println(minCostGreedy(costs2));
        System.out.println(minCostDP(costs2));
    }

    public static int minCostDP(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int m = costs.length;
        int n = costs[0].length;
        int minCost = Integer.MAX_VALUE;
        if (m == 1) {
            for (int j = 0; j < n; j++) {
                minCost = Math.min(minCost, costs[0][j]);
            }
            return minCost;
        }
        int[][] memo = new int[m][n];
        // transitional equation design:
        // min using col is MIN among the sum of this val and next line without using col
        // init
        for (int j = 0; j < n; j++) {
            memo[0][j] = costs[0][j];
        }
        // fill other rows
        for (int i = 1; i < m; i++) {
            // transitional equation
            for (int j = 0; j < n; j++) {
                getMinByMatrix(memo, costs, i, j);
                if (i == m - 1) {
                    minCost = Math.min(minCost, memo[m - 1][j]);
                }
            }
        }
        return minCost;
    }

    private static void getMinByMatrix(int[][] memo, int[][] costs, int i, int j) {
        int minCost = Integer.MAX_VALUE;
        for (int k = 0; k < memo[0].length; k++) {
            if (k != j) {
                minCost = Math.min(minCost, memo[i - 1][k] + costs[i][j]);
            }
        }
        memo[i][j] = minCost;
    }

    public static int minCostGreedy(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int selectedCol = -1;
        int m = costs.length;
        int n = costs[0].length;
        int totalMinCost = 0;
        for (int i = 0; i < m; i++) {
            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (costs[i][j] < minCost && j != selectedCol) {
                    minCost = costs[i][j];
                    selectedCol = j;
                }
            }
            totalMinCost += costs[i][selectedCol];
        }

        return totalMinCost;
    }
}
