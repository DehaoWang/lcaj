package com.lcaj.lc198;

import com.lcaj.lc213.HouseRobberII;

/**
 * Created by wangdehao on 19/4/12.
 */
public class HouseRobber {
    public static void main(String[] args) {

        int[][] houses = {
                {1, 2, 3, 1},
                {2, 7, 9, 3, 1},
                {1, 2, 1, 1},
        };
        for (int[] house : houses) {
            System.out.println(rob(house));
            System.out.println(rob2(house));
            System.out.println(HouseRobberII.robInRange(house, 0, house.length - 1));
//            System.out.println(robGreedy(house));
        }
    }

    public static int rob(int[] nums) {
        // types.dp-memo
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (len == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        }
        // len > 3 scenario: memo[i] means max gold when taking i
        int[] memo = new int[len];
        memo[len - 1] = nums[len - 1];
        memo[len - 2] = nums[len - 2];
        memo[len - 3] = Math.max(nums[len - 1] + nums[len - 3], nums[len - 2]);
//        ArrayMethods.printArray(memo);
        for (int i = nums.length - 4; i >= 0; i--) {
            memo[i] = nums[i] + Math.max(memo[i + 2], memo[i + 3]);
        }

        return Math.max(memo[0], memo[1]);
    }

    public static int rob2(int[] nums) {
        // types.dp-memo
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // len > 2 scenario: memo[i] means max gold when starting at i
        int[] memo = new int[len];
        memo[len - 1] = nums[len - 1];
        memo[len - 2] = Math.max(nums[len - 1], nums[len - 2]);
        for (int i = nums.length - 3; i >= 0; i--) {
            memo[i] = Math.max(nums[i] + memo[i + 2], memo[i + 1]);
        }

        return memo[0];
    }

    public static int robGreedy(int[] nums) {

        int sum = 0;
        int curr = 0;
        while (curr < nums.length - 1) {
            if (nums[curr] < nums[curr + 1]) {
                // rob i+1
                sum += nums[curr + 1];
//                System.out.println("next: sum=" + sum);
                curr += 3;
            } else {
                // rob i
                sum += nums[curr];
//                System.out.println("now: sum=" + sum);
                curr += 2;
            }
//            System.out.println("curr=" + curr);
        }
        if (curr < nums.length) {
            // rob i
            sum += nums[curr];
        }
        return sum;
    }
}
