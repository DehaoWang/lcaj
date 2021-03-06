package algorithms.dynamicprogramming;

import algorithms.utils.MatrixUtils;

import java.util.ArrayList;

public class Knapsack {
    public static void main(String[] args) {
        int[][] weightsList = {
                {2, 1, 3},
                {5, 4, 7, 2, 6},
                {2, 3, 4, 5}
        };
        int[][] valuesList = {
                {4, 2, 3},
                {12, 3, 10, 3, 6},
                {16, 19, 23, 28}
        };
        int[] maxWeights = {4, 15, 7};
        for (int i = 0; i < weightsList.length; i++) {
            System.out.println(knapsackDP(weightsList[i], valuesList[i], maxWeights[i]));
        }
    }

    public static int knapsackDP(int[] weights, int[] values, int maxWeight) {
        int n = weights.length;
        int[][] dp = new int[n + 1][maxWeight + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int w = 1; w < maxWeight + 1; w++) {
                // decision on item 'i-1'
                int pred = dp[i - 1][w];
                int left = w - weights[i - 1];
                // cannot take dp[i-1][w]
                if (left < 0) {
                    dp[i][w] = pred;
                } else {
                    dp[i][w] = Math.max(pred, values[i - 1] + dp[i - 1][left]);
                }
            }
        }
        MatrixUtils.printMatrix(dp);
        return dp[n][maxWeight];
    }
}
