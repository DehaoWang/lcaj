package leetcode.lc44;


import algorithms.utils.MatrixUtils;

public class WildcardMatching {
    public static void main(String[] args) {
        String[][] tests = {
                {"aa", "a"},
//                {"aa", "*"},
//                {"cb", "?a"},
                {"adceb", "*a*b"},
//                {"acdcb", "a*c?b"}
        };
        for (String[] test : tests) {
            System.out.println(isMatchDP(test[0], test[1]));
            System.out.println(isMatchBacktrack(test[0], test[1]));
        }
    }

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

    public static boolean isMatchBacktrack(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int pLen = p.length(), sLen = s.length();
        int pStar = -1, sStar = -1;
        int pIdx = 0, sIdx = 0;

        while (sIdx < sLen) {
            if (pIdx < pLen && (p.charAt(pIdx) == s.charAt(sIdx) || p.charAt(pIdx) == '?')) {
                pIdx++;
                sIdx++;
            } else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                pStar = pIdx;
                sStar = sIdx;
                pIdx++;
            } else if (sStar >= 0) { // backtrack: pIdx and sIdx both go back to previous matching
                pIdx = pStar + 1;
                sIdx = sStar + 1;
                sStar = sIdx;
            } else {
                return false;
            }
        }
        while (pIdx < pLen && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        return pIdx == pLen;
    }
}
