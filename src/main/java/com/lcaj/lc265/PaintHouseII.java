package com.lcaj.lc265;

import com.lcaj.lc256.PaintHouse;
import com.lcaj.util.MatrixMethods;

/**
 * Created by wangdehao on 19/5/14.
 */
public class PaintHouseII {
    public static void main(String[] args) {
        int[][] costs = {
                {17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}
        };

        int[][] costs2 = {
                {7, 6, 2},
        };

        int[][] costs3 = {
                {1, 5, 3},
                {2, 9, 4},
        };


        int[][] costs4 = {
                {16, 9, 20, 8},
                {8, 18, 8, 12},
                {1, 16, 2, 5},
                {3, 4, 16, 3},
                {3, 16, 9, 8},
                {6, 14, 18, 13},
                {13, 2, 4, 19},
                {15, 12, 13, 7},
                {5, 5, 2, 14},
                {9, 17, 12, 6},
                {17, 14, 6, 17},
                {14, 3, 19, 11},
                {6, 19, 12, 1},
                {7, 2, 12, 12},
                {9, 4, 1, 11}
        };
//        System.out.println(minCostIInoExtraSpace(costs));
//        System.out.println(minCostIInoExtraSpace(costs2));
//        System.out.println(minCostIInoExtraSpace(costs3));
        System.out.println(minCostIInoExtraSpace(costs4));
    }

    public static int minCostII(int[][] costs) {
        return PaintHouse.minCostDP(costs);
    }

    public static int minCostIInoExtraSpace(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int m = costs.length;
        int n = costs[0].length;
        int minCost = Integer.MAX_VALUE;
        int minCost2;
        if (m == 1) {
            for (int j = 0; j < n; j++) {
                minCost = Math.min(minCost, costs[0][j]);
            }
            return minCost;
        }
        // no extra space: modification on costs

        // transitional equation design:
        // min using col is MIN among the sum of this val and next line without using col

        int min1 = -1;
        int min2 = -1;
        for (int i = 0; i < m; i++) {
            // transitional equation
            int lastMin1 = min1;
            int lastMin2 = min2;
            min1 = min2 = -1;

            minCost = Integer.MAX_VALUE;
            minCost2 = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i != 0) {
                    if (j != lastMin1) {
                        costs[i][j] += costs[i - 1][lastMin1];
                    } else {
                        costs[i][j] += costs[i - 1][lastMin2];
                    }
                }
                if (costs[i][j] < minCost) {
                    min2 = min1;
                    min1 = j;
                    minCost2 = minCost;
                    minCost = costs[i][j];
                } else if (costs[i][j] < minCost2) {
                    min2 = j;
                    minCost2 = costs[i][j];
                }
            }
        }
        return minCost;
    }
}
