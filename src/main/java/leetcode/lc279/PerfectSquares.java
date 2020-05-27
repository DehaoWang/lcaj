package leetcode.lc279;

import java.util.Arrays;

/**
 * Created by wangdehao on 19/5/28.
 */
public class PerfectSquares {
    public static void main(String[] args) {

        for (int i = 0; i < 15; i++) {
            System.out.println("i = " + i + ", numSquares = " + numSquares(i));
            System.out.println("i = " + i + ", numSquaresFast = " + numSquaresFast(i));
        }
    }

    public static int numSquares(int n) {
        if (n <= 1) {
            return n;
        }
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if (isSquare(i)) {
                memo[i] = 1;
                continue;
            }
            memo[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i / 2; j++) {
                // i = j + i-j
                int count = memo[j] + memo[i - j];
                memo[i] = Math.min(memo[i], count);
            }
        }
        return memo[n];
    }

    private static boolean isSquare(int i) {
        double sqrt = Math.sqrt(i);
        return sqrt == (int) sqrt;
    }

    public static int numSquaresFast(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
