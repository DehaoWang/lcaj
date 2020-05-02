package algorithms.dynamicprogramming;

public class EggDrop {
    public static void main(String[] args) {

        int numOfEgg = 6;
//        int level = (int) Math.pow(2, 8);
        int level = 1000;

//        System.out.println(Math.log(level) / Math.log(2));

        // origin problem: get T by E & LEVEL
        long t0 = System.currentTimeMillis();

        // ULTIMATE TESTS
        int numOfTryE = getTryMathBinaryByEL(numOfEgg, level);
        System.out.println(numOfTryE);
        long t8 = System.currentTimeMillis();
        System.out.println("time used: " + (t8 - t0));

        int numOfTry = getTryMathByEL(numOfEgg, level);
        System.out.println(numOfTry);
        long t7 = System.currentTimeMillis();
        System.out.println("time used: " + (t7 - t8));

        System.out.println(forwardDP(numOfEgg, level));
        long t1 = System.currentTimeMillis();
        System.out.println("time used: " + (t1 - t7));

        System.out.println(minTryTransformed(numOfEgg, level));
        long t2 = System.currentTimeMillis();
        System.out.println("time used: " + (t2 - t1));

        System.out.println(minTryBinary(numOfEgg, level));
        long t3 = System.currentTimeMillis();
        System.out.println("time used: " + (t3 - t2));

        System.out.println(minTry(numOfEgg, level));
        long t4 = System.currentTimeMillis();
        System.out.println("time used: " + (t4 - t3));

        // dual problem: get E by T & LEVEL
        System.out.println("#Try = " + numOfTry + ", Level = " + level);
        int revNumOfEgg = minEgg(numOfTry, level);
        System.out.println("#Egg rev = " + revNumOfEgg);
        System.out.println("#Egg ori = " + numOfEgg);
        int revNumOfEggMath = getEggMathByTL(numOfTry, level);
        System.out.println("#Egg rev math = " + revNumOfEggMath);

        // numOfEgg may not be same with revNumOfEgg: SHRINKAGE
        // because T is found by searching in dp left -> right
        // rev is determined by searching in dp bottom -> up

        // ESSENCE = forward problem: get LEVEL by T & E
        int maxEgg = Math.max(numOfEgg, revNumOfEgg);
        int l = getLevelByET(maxEgg, numOfTry);
        System.out.println("GetByET Level: " + l);
        int l2 = getLevelMathByET(maxEgg, numOfTry);
        System.out.println("GetByETMath Level: " + l2);


//        int[][] dp = getForwardDP(maxEgg, numOfTry);
//        MatrixMethods.printMatrix(dp);
//
//        int[][] dpMath = getForwardDPMath(maxEgg, numOfTry);
//        MatrixMethods.printMatrix(dpMath);


        // comparing math and dp
//        int e = 6;
//        int t = 12;
//        int[][] dpMathComp = getForwardDPMath(e, t);
//        long t5 = System.currentTimeMillis();
//        System.out.println("time used: " + (t5 - t4));
//        int[][] dpComp = getForwardDP(e, t);
//        long t6 = System.currentTimeMillis();
//        System.out.println("time used: " + (t6 - t5));


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
        return dp[e][t];
    }

    public static int[][] getForwardDP(int e, int t) {
        int[][] dp = new int[e + 1][t + 1];
        for (int j = 1; j <= t; j++) {
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

    public static int[][] getForwardDPMath(int e, int t) {
        int[][] dp = new int[e + 1][t + 1];
        // based on state transform: dp(e, t) = 1 + dp(e, t - 1) + dp(e - 1,t - 1)
        // g(e, t) = dp(e, t) - dp(e - 1, t - 1)
        // g(e, t) = g(e, t - 1) + g(e - 1, t - 1)
        // g(e, t) = Combination(t, e)     <--->   C(t, e) = C(t - 1, e) + C(t - 1, e - 1)
        // dp(e, t) = Sum(g(k, t)), enumerating k from 1 to E

        for (int i = 1; i <= e; i++) {
            for (int j = 1; j <= t; j++) {
                // test Combination
//                dp[i][j] = getCombination(j, i);

                // combination sum, a little bit slow
//                int sum = 0;
//                for (int k = 1; k <= i; k++) {
//                    sum += getCombination(j, k);
//                }
//                dp[i][j] = sum;

                // refined: multiply by binomial coefficient
                dp[i][j] = getLevelMathByET(i, j);
            }
        }
        return dp;
    }

    // C(n, m)
    public static int getCombination(int n, int m) {
        if (m == 0 || m > n || n == 0) {
            return 0;
        } else if (m == 1) {
            return n;
        }
        long up = 1;
        long down = 1;
        for (int k = 1; k <= Math.min(n - m, m); k++) {
            down *= k;
            up *= n + 1 - k;
        }
        return (int) (up / down);
    }

    // following up: given T and Level, how many eggs do we need? - DUAL PROBLEM
    public static int minEgg(int t, int level) {
        int[][] dp = new int[level + 1][t + 1];
        int e = 0;
        while (dp[e][t] < level) {
            e++;
            for (int j = 1; j <= t; j++) {
                dp[e][j] = 1 + dp[e - 1][j - 1] + dp[e][j - 1];
            }
        }
        return e;
    }

    // Math behind the problem: In T times of try, eggs break at most E times
    // so the result is Sum(C(T, k)), enumerating k from 1 to E
    // ULTIMATE SOLUTION

    // method 0: get Level by Egg & Try
    public static int getLevelMathByET(int e, int t) {
        int level = 0;
        int r = 1;
        for (int k = 1; k <= e; k++) {
            // some times wrong!
//            r *= (j + 1 - k) / k;
            r *= t + 1 - k;
            r /= k;
            level += r;
        }
        return (int) level;
    }

    // method 0.P: get Level by Egg & Try -- patch
    public static int getLevelMathByETPatch(int e, int t, int n) {
        int res = 0;
        int r = 1;
        for (int k = 1; k <= e; k++) {
            // some times wrong!
//            r *= (j + 1 - k) / k;
            r *= t + 1 - k;
            r /= k;
            res += r;
            // problem: go off bound, any other solutions?
            if (res >= n) {
                break;
            }
        }
        return res;
    }

    // method 1: get Try By Egg & Level
    public static int getTryMathByEL(int e, int level) {
        int t = 0;
        while (getLevelMathByET(e, t) < level) {
            t++;
        }
        return t;
    }

    // method 1.F: get Try By Egg & Level Final: binary search & lower bound pruning
    public static int getTryMathBinaryByEL(int e, int level) {
        // lower bound pruning
        int unlimitedTry = (int) Math.ceil(logTwo(level + 1));
        if (e >= unlimitedTry) {
            return unlimitedTry;
        }
        // binary search
        int l = 1;
        int r = level;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (getLevelMathByETPatch(e, m, level) < level) {
//            if (getLevelMathByET(e, m) < level) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static double logTwo(int n) {
        return Math.log(n) / Math.log(2);
    }

    // method 2: get Try By Egg & Level
    public static int getEggMathByTL(int t, int level) {
        int e = 0;
        while (getLevelMathByET(e, t) < level) {
            e++;
        }
        return e;
    }

    // method 2.F: get Try By Egg & Level Final: binary search √ & lower bound pruning X ?
    // TODO: 2020-04-13 refinement
}
