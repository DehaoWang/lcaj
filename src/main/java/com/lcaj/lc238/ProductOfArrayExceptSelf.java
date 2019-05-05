package com.lcaj.lc238;

import com.lcaj.util.ArrayMethods;

/**
 * Created by wangdehao on 19/4/24.
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int len = nums.length;
        int[] result = new int[len];

        int tmp = 1;
        for (int i = 0; i < len; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        tmp = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }

        return result;
    }
}
