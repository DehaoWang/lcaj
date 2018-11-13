package com.lcaj.lc62;

/**
 * Created by wangdehao on 18/11/11.
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths(3, 2));

    }

    public static int uniquePaths(int m, int n) {
//        return uniquePathsDP(m, n);
        return uniquePathsMemo(m, n);
    }

    public static int uniquePathsDP(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        } else {
            return uniquePathsDP(m - 1, n) + uniquePathsDP(m, n - 1);
        }
    }

    public static int uniquePathsMemo(int m, int n) {
        int[][] memo = new int[m][n];

        memo[m - 1][n - 1] = 1;
        for (int i = 0; i < m; i++) {
            memo[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            memo[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }

        return memo[m - 1][n - 1];
    }

}
