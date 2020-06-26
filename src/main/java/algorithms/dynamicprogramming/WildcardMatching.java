package algorithms.dynamicprogramming;

import algorithms.utils.MatrixUtils;

public class WildcardMatching {
    // dp approach like edit distance, another approach is backtrack
    public static boolean isMatchDP(String s, String p) {
        if (s == null || p == null) {
            return false;
        } else if (s.length() == 0 && !(p.equals("*") || p.length() == 0)) {
            return false;
        }

        int lenS = s.length();
        int lenP = p.length();
        boolean[][] dp = new boolean[lenP + 1][lenS + 1];
        dp[0][0] = true;
        MatrixUtils.printMatrix(dp);
        for (int i = 1; i <= lenP; i++) {
            char cP = p.charAt(i - 1);
            dp[i][0] = p.charAt(i - 1) == '*' && dp[i - 1][0];
            for (int j = 1; j <= lenS; j++) {
                char cS = s.charAt(j - 1);
                if (cP == cS || cP == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (cP == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        MatrixUtils.printMatrix(dp);
        return dp[lenP][lenS];
    }
}
