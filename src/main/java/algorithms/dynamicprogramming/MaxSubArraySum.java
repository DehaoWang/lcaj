package algorithms.dynamicprogramming;

import algorithms.util.ArrayMethods;

import java.lang.reflect.Array;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, -6, 5, -12, 3, -5, 8};
        System.out.println(maxSubArraySum(nums));
        System.out.println(maxSubArraySumDP(nums));
        System.out.println(maxSubArraySumDPS(nums));
    }

    public static int maxSubArraySum(int[] nums) {
        int thisSum = 0;
        int maxSum = 0;

        for (int i = 0; i < nums.length; i++) {
            thisSum += nums[i];
            if (thisSum < 0) {
                thisSum = 0;
            }
            maxSum = thisSum > maxSum ? thisSum : maxSum;
        }
        return maxSum;
    }

    // dp(i) = max sum ended at i
    public static int maxSubArraySumDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = Math.max(0, dp[0]);
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
//        ArrayMethods.printArray(dp);
        return max;
    }

    public static int maxSubArraySumDPS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
//        int[] dp = new int[len];
//        dp[0] = nums[0];
        int max = 0;
        int curr = nums[0];
        for (int i = 1; i < len; i++) {
            if (curr < 0) {
                curr = 0;
            }
            curr += nums[i];
            max = Math.max(max, curr);
//            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
//            max = Math.max(max, dp[i]);
        }
//        ArrayMethods.printArray(dp);
        return max;
    }
}
