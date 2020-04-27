package algorithms.dynamicprogramming;

import java.util.PriorityQueue;

public class StockOperations {
    public static void main(String[] args) {
        // test p1
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit1BF(nums));
        System.out.println(maxProfit1Transformed(nums));
        System.out.println(maxProfit1TransformedSE(nums));

        // test p2
        System.out.println(maxProfit2TransformedSE(nums));

        int[] nums3 = {3, 3, 5, 0, 0, 3, 1, 4};
//        System.out.println(maxProfit3TransformedSE(nums3));
        System.out.println(maxProfit3DP(nums3));

    }
    // Problem template: nums indicates the price at different dates

    // PROBLEM 1: 1 transaction
    public static int maxProfit1BF(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] > max) {
                    max = nums[j] - nums[i];
                }
            }
        }
        return max;
    }

    public static int maxProfit1TransformedSE(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return Math.max(nums[1] - nums[0], 0);
        }
        int len = nums.length;
        int max = nums[1] - nums[0];
        int curr = nums[1] - nums[0];
        for (int i = 2; i < len; i++) {
            if (curr < 0) {
                curr = 0;
            }
            curr += nums[i] - nums[i - 1];
            max = Math.max(max, curr);
        }
        max = Math.max(0, max);
        return max;
    }

    public static int maxProfit1Transformed(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int len = nums.length;
        int[] diffNums = new int[len - 1];
        for (int i = 1; i < nums.length; i++) {
            diffNums[i - 1] = nums[i] - nums[i - 1];
        }
//        ArrayMethods.printArray(diffNums);
        return maxSubArray(diffNums);
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curr < 0) {
                curr = 0;
            }
            curr += nums[i];
            max = Math.max(max, curr);
        }
        // problem specified: neg -> 0
        max = Math.max(0, max);
        return max;
    }

    // PROBLEM 2: unlimited transactions
    public static int maxProfit2TransformedSE(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return Math.max(nums[1] - nums[0], 0);
        }
        int len = nums.length;
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                max += nums[i] - nums[i - 1];
            }
        }
        max = Math.max(0, max);
        return max;
    }

    // PROBLEM 3: 2 transactions

    // WRONG IMPLEMENTATION:
    public static int maxProfit3TransformedSE(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return Math.max(nums[1] - nums[0], 0);
        }
        int len = nums.length;
        int max = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(2);
        for (int i = 1; i < len; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                priorityQueue.offer(nums[i] - nums[i - 1]);
                if (priorityQueue.size() > 2) {
                    priorityQueue.poll();
                }
            }
        }
        System.out.println(priorityQueue.size());
        for (Integer i : priorityQueue) {
            max += i;
        }
        return max;
    }

    // dp(i, k, s)
    // i: date, k: #transactions, s: state 0-empty 1-full
    // dp(i, k, 0) = max( dp(i-1, k, 0), dp(i-1, k, 1) + p[i] )
    // dp(i, k, 1) = max( dp(i-1, k, 1), dp(i-1, k-1, 1) - p[i] )
    public static int maxProfit3DP(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return Math.max(nums[1] - nums[0], 0);
        }
        int len = nums.length;
        int numTx = 3;
        int states = 2;
        int[][][] dp = new int[len][numTx][states];
        // base case settings

        // state transition
        for (int i = 1; i < len; i++) {
            for (int k = 1; k < numTx; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + nums[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - nums[i]);
            }
        }
        return dp[len - 1][numTx - 1][0];
    }
}
