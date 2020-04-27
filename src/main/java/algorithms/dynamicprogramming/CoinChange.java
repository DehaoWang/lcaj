package algorithms.dynamicprogramming;

public class CoinChange {
    public static void main(String[] args) {
        int amount = 41;
        int[] coins = {1, 2, 5};

        long t0 = System.currentTimeMillis();

        System.out.println(coinChangeDP(coins, amount));
        long t1 = System.currentTimeMillis();
        System.out.println("time used: " + (t1 - t0));

        System.out.println(coinChangeMemo(coins, amount));
        long t2 = System.currentTimeMillis();
        System.out.println("time used: " + (t2 - t1));

        System.out.println(coinChangeBF(coins, amount));
        long t3 = System.currentTimeMillis();
        System.out.println("time used: " + (t3 - t2));
    }


    public static int coinChangeBF(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        int min = amount;
        for (int coin : coins) {
            min = Math.min(min, 1 + coinChangeBF(coins, amount - coin));
        }
        return min;
    }

    public static int coinChangeMemo(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return updateMemo(coins, amount, memo);
    }

    private static int updateMemo(int[] coins, int n, int[] memo) {
        if (n <= 1) {
            return n;
        }
        if(memo[n] != 0){
            return memo[n];
        }
        int min = n;
        for (int coin : coins) {
            int left = n - coin;
            if (left < 0) {
                continue;
            }
            min = Math.min(min, 1 + updateMemo(coins, left, memo));
        }
        memo[n] = min;
        return memo[n];
    }

    public static int coinChangeDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int left = i - coin;
                if (left < 0) {
                    continue;
                } else {
                    min = Math.min(min, 1 + dp[left]);
                }
            }
            dp[i] = min;
        }
        return dp[amount];
    }
}
