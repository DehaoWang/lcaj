package com.lcaj.lc209;

import com.lcaj.util.ArrayMethods;

import java.util.Arrays;

/**
 * Created by wangdehao on 19/4/16.
 */
public class MinSizeSubarraySum {
    public static void main(String[] args) {
        int[][] m = {
                {2, 3, 1, 2, 4, 3},
                {6},
                {6, 2, 6, 4, 5},
                {1, 2, 6, 4, 5, 8},
                {1, 2, 6, 3, 4, 5, 6},
        };
        for (int[] nums : m) {
            System.out.println("BF=" + minSubArrayLenBf(7, nums) + ", LIN=" + minSubArrayLen(7, nums));
        }

    }

    public static int minSubArrayLen(int s, int[] nums) {
        // 2 pointers
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = nums[0];
        while (i < len && j < len) {
            if (sum >= s) {
                minLen = Math.min(j - i + 1, minLen);
                i++;
                sum -= nums[i - 1];
            } else {
                j++;
                if (j < nums.length) {
                    sum += nums[j];
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static int minSubArrayLenBf(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // start with i (time complexity = n2)
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    minLen = Math.min(j - i + 1, minLen);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


}
