package algorithms.dynamicprogramming;

public class Fibonacci {
    public static void main(String[] args) {
        int target = 45;

        long t0 = System.currentTimeMillis();

        System.out.println(fibDP(target));
        long t1 = System.currentTimeMillis();
        System.out.println("time used: " + (t1 - t0));

        System.out.println(fibMemo(target));
        long t2 = System.currentTimeMillis();
        System.out.println("time used: " + (t2 - t1));

        System.out.println(fibBF(target));
        long t3 = System.currentTimeMillis();
        System.out.println("time used: " + (t3 - t2));
    }

    public static int fibBF(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return fibBF(n - 1) + fibBF(n - 2);
        }
    }

    public static int fibMemo(int n) {
        int[] memo = new int[n + 1];
        return updateMemo(n, memo);
    }

    public static int updateMemo(int n, int[] memo) {
        if (n <= 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = updateMemo(n - 1, memo) + updateMemo(n - 2, memo);
        return memo[n];
    }

    public static int fibDP(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
