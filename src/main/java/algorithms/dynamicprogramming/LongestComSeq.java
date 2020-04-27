package algorithms.dynamicprogramming;

import algorithms.util.MatrixMethods;

public class LongestComSeq {
    public static void main(String[] args) {
        System.out.println(longestComSeq("abcde", "ace"));
    }

    // abcde, ace
    // if s(i-1) = t(j-1): dp(i,j) = dp(i-1,j-1)+1
    // else: dp(i,j) = max(dp(i-1, j), dp(i, j-1))
    public static int longestComSeq(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return 0;
        }
        int lenS = s.length();
        int lenT = t.length();
        int[][] dp = new int[lenS + 1][lenT + 1];
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenT; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        MatrixMethods.printMatrix(dp);
        return dp[lenS][lenT];
    }

    //////////
    public static int longestComSeqLC(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        int lenS = text1.length();
        int lenT = text2.length();
        int[][] dp = new int[lenS + 1][lenT + 1];
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenT; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[lenS][lenT];
    }
}
