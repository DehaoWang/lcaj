package algorithms.dynamicprogramming;

public class FourKK {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
//            System.out.println(String.format("%15s(%2d) = %3d", "dp", i, maxA(i)));
//            System.out.println(String.format("%15s(%2d) = %3d", "dpMemo", i, maxDpMemo(i)));
            System.out.println(String.format("%15s(%2d) = %3d", "structuredDp", i, structuredDp(i)));
        }
    }

    public static int maxA(int N) {
        return maxDp(N, 0, 0);
    }

    public static int maxDp(int n, int curr, int cache) {
        if (n <= 0) {
            return curr;
        }
        int typeIn = maxDp(n - 1, curr + 1, cache);
        int ctrlAC = maxDp(n - 2, curr, curr);
        int ctrlV = maxDp(n - 1, curr + cache, cache);
        return Math.max(typeIn, Math.max(ctrlAC, ctrlV));
    }

    public static int maxDpMemo(int N) {
        int bigNum = 10000;
        int[][][] memo = new int[N + 1][bigNum][bigNum];
        return dpMemo(N, 0, 0, memo);
    }

    public static int dpMemo(int n, int curr, int cache, int[][][] memo) {
        if (n <= 0) {
            return curr;
        }
        if (memo[n][curr][cache] != 0) {
            return memo[n][curr][cache];
        } else {
            int typeIn = maxDp(n - 1, curr + 1, cache);
            int ctrlAC = maxDp(n - 2, curr, curr);
            int ctrlV = maxDp(n - 1, curr + cache, cache);
            memo[n][curr][cache] = Math.max(typeIn, Math.max(ctrlAC, ctrlV));
        }
        return memo[n][curr][cache];
    }

    public static int structuredDp(int N) {
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[N];
    }
}
