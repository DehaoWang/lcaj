package leetcode.lc84;

import algorithms.utils.MatrixUtils;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        // dp: i for left, j for right
        int len = heights.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = heights[i];
        }

        int[][] minInRange = getMinInRange(heights);
        MatrixUtils.printMatrix(minInRange);

        for (int k = 1; k < len; k++) {
            for (int i = 0; i + k < len; i++) {
                dp[i][i + k] = stf(i, k, dp, minInRange, heights);
            }
        }
        return dp[0][len - 1];
    }

    public static int[][] getMinInRange(int[] heights) {
        int len = heights.length;
        int[][] min = new int[len][len];
        for (int i = 0; i < len; i++) {
            min[i][i] = heights[i];
        }
        for (int k = 1; k < len; k++) {
            for (int i = 0; i + k < len; i++) {
                min[i][i + k] = Math.min(min[i + 1][i + k], min[i][i + k - 1]);
            }
        }
        return min;
    }

    public static int stf(int i, int k, int[][] dp, int[][] minInRange, int[] heights) {
        return 0;
    }
}
