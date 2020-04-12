package types.dp;

import com.lcaj.util.MatrixMethods;

public class EggDrop {
    public static void main(String[] args) {
        int numOfEgg = 6;
        int level = (int) Math.pow(2, 7);
        // origin problem: get T by E & LEVEL
        long t0 = System.currentTimeMillis();

        int numOfTry = minTryTransformed(numOfEgg, level);
        System.out.println(numOfTry);
        long t1 = System.currentTimeMillis();
        System.out.println("time used: " + (t1 - t0));

        System.out.println(forwardDP(numOfEgg, level));
        long t2 = System.currentTimeMillis();
        System.out.println("time used: " + (t2 - t1));

        System.out.println(minTryBinary(numOfEgg, level));
        long t3 = System.currentTimeMillis();
        System.out.println("time used: " + (t3 - t2));

        System.out.println(minTry(numOfEgg, level));
        long t4 = System.currentTimeMillis();
        System.out.println("time used: " + (t4 - t3));


        // dual problem: get E by T & LEVEL
        int revNumOfEgg = minEgg(numOfTry, level);
        System.out.println(revNumOfEgg);

        // ESSENCE = forward problem: get LEVEL by T & E
        int maxEgg = Math.max(numOfEgg, revNumOfEgg);
        int l = getLevelByET(maxEgg, numOfTry);
        System.out.println(l);
        int[][] dp = getForwardDP(maxEgg, numOfTry);
        MatrixMethods.printMatrix(dp);
        // numOfEgg may not be same with revNumOfEgg: SHRINKAGE
        // because T is found by searching in dp left -> right
        // rev is determined by searching in dp bottom -> up
    }

    public static int minTry(int e, int level) {
        int[][] memo = new int[e + 1][level + 1];
        return minTryDP(e, level, memo);
    }

    public static int minTryDP(int e, int lv, int[][] memo) {
        if (e == 1) {
            return lv;
        } else if (lv == 0) {
            return 1;
        }
        if (memo[e][lv] != 0) {
            return memo[e][lv];
        }
        int res = lv;
        for (int i = 1; i <= lv; i++) {
            // try at i
            int broken = minTryDP(e - 1, i - 1, memo);
            int unbroken = minTryDP(e, lv - i, memo);
            res = Math.min(res, 1 + Math.max(broken, unbroken));
        }
        memo[e][lv] = res;
        return res;
    }

    public static int minTryBinary(int e, int level) {
        int[][] memo = new int[e + 1][level + 1];
        return minTryDPBinary(e, level, memo);
    }

    public static int minTryDPBinary(int e, int lv, int[][] memo) {
        if (e == 1) {
            return lv;
        } else if (lv == 0) {
            return 1;
        }
        if (memo[e][lv] != 0) {
            return memo[e][lv];
        }
        int res = lv;
//        for (int i = 1; i <= n; i++) {
//            // try at i
//            int broken = minTryDP(k - 1, i - 1, memo);
//            int unbroken = minTryDP(k, n - i, memo);
//            res = Math.min(res, 1 + Math.max(broken, unbroken));
//        }

        // based on above, notice that minTryDP is MONOTONOUS on n, so Binary Search can be applied
        int l = 1;
        int r = lv;
        while (l < r) {
            int m = l + (r - l) / 2;
            int broken = minTryDP(e - 1, m - 1, memo);
            int unbroken = minTryDP(e, lv - m, memo);
            if (broken < unbroken) {
                l = m + 1;
                res = Math.min(res, 1 + unbroken);
            } else {
                r = m - 1;
                res = Math.min(res, 1 + broken);
            }
        }
        memo[e][lv] = res;
        return res;
    }

    // transformed problem: dp(k, t) < N, t is # try
    public static int minTryTransformed(int e, int level) {
        int[][] dp = new int[e + 1][level + 1];

        int t = 0;
        while (dp[e][t] < level) {
            t++;
            for (int i = 1; i <= e; i++) {
                dp[i][t] = 1
                        + dp[i][t - 1]          // unbroken
                        + dp[i - 1][t - 1];     // broken
            }
            // related design see get Level by # eggs and # try : getLevelByET
        }
        return t;
    }

    public static int getLevelByET(int e, int t) {
        int[][] dp = new int[e + 1][t + 1];
        for (int j = 1; j <= t; j++) {
            for (int i = 1; i <= e; i++) {
                dp[i][j] = 1 + dp[i][j - 1] + dp[i - 1][j - 1];
            }
        }
//        MatrixMethods.printMatrix(dp);
        return dp[e][t];
    }

    public static int[][] getForwardDP(int e, int level) {
        int[][] dp = new int[e + 1][level + 1];
        for (int j = 1; j <= level; j++) {
            for (int i = 1; i <= e; i++) {
                dp[i][j] = 1 + dp[i][j - 1] + dp[i - 1][j - 1];
            }
        }
        return dp;
    }

    public static int forwardDP(int e, int level) {
        int[][] dp = getForwardDP(e, level);
        int t = 1;
        while (dp[e][t] < level) {
            t++;
        }
        return t;
//        for (int t = 1; t <= level; t++) {
//            if (dp[e][t] >= level) {
//                return t;
//            }
//        }
//        return 1;
    }

    // following up: given T and Level, how many eggs do we need? - DUAL PROBLEM
    public static int minEgg(int t, int level) {
        int[][] dp = new int[level + 1][t + 1];
//        MatrixMethods.printMatrix(dp);
        int e = 0;
        while (dp[e][t] < level) {
            e++;
            for (int j = 1; j <= t; j++) {
                dp[e][j] = 1 + dp[e - 1][j - 1] + dp[e][j - 1];
            }
        }
//        MatrixMethods.printMatrix(dp);
        return e;
    }
}
