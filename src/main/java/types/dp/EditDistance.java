package types.dp;

import com.lcaj.util.MatrixMethods;

public class EditDistance {
    public static void main(String[] args) {
        String[] sourceList = {
                "horse",
                "intention"
        };
        String[] targetList = {
                "ros",
                "execution"
        };
        for (int i = 0; i < sourceList.length; i++) {
            System.out.println(minDistanceDP(sourceList[i], targetList[i]));
        }
    }

    public static int minDistanceDP(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int[][] dp = new int[lenS + 1][lenT + 1];
        for (int i = 1; i <= lenS; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= lenT; j++) {
            dp[0][j] = j;
        }
//        MatrixMethods.printMatrix(dp);
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenT; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + multiMin(
                            dp[i - 1][j - 1],   // modify
                            dp[i - 1][j],       // delete
                            dp[i][j - 1]        // insert
                    );
                }
            }
        }
//        MatrixMethods.printMatrix(dp);
        return dp[lenS][lenT];
    }

    public static int multiMin(int i, int i1, int i2) {
        return Math.min(Math.min(i, i1), i2);
    }
}
