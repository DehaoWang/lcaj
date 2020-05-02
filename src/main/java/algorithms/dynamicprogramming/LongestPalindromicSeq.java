package algorithms.dynamicprogramming;

import algorithms.utils.MatrixUtils;

public class LongestPalindromicSeq {
    public static void main(String[] args) {
        System.out.println(longestPalindromicSeq("bbbab"));
        System.out.println(longestPalindromicSeq2("bbbab"));

    }

    // bbbab
    // dp(i, j): max length of seq from i to j
    // if si = sj : dp(i, j) = dp(i+1, j-1) + 2
    // else: dp(i, j) = max(dp(i+1, j), dp(i, j-1))
    public static int longestPalindromicSeq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        // diagonal visit
        for (int k = 0; k < len; k++) {
            for (int i = 0; i < len && i + k < len; i++) {
                int j = i + k;
                if (j == i) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    // no need
//                    if (j == i + 1) {
//                        dp[i][j] = 2;
//                    } else {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
//                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        MatrixUtils.printMatrix(dp);
        return dp[0][len - 1];
    }

    public static int longestPalindromicSeq2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        // backward visit
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        MatrixUtils.printMatrix(dp);
        return dp[0][len - 1];
    }
}
