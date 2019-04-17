package com.lcaj.lc213;

/**
 * Created by wangdehao on 19/4/16.
 */
public class HouseRobberII {
    public static void main(String[] args) {

    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        return Math.max(robInRange(nums, 0, len - 2), robInRange(nums, 1, len - 1));
    }

    public static int robInRange(int[] nums, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + nums[j];
            exclude = Math.max(i, e);
        }
        return Math.max(include, exclude);
    }
}
