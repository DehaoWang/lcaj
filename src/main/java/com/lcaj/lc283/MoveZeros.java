package com.lcaj.lc283;

import com.lcaj.util.ArrayMethods;
/**
 * Created by wangdehao on 19/5/28.
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 3, 12},
                {0, 0, 5},
                {1, 0, 3, 0, 12}
        };
        for (int[] nums : matrix) {
//            ArrayMethods.printArray(nums);
            moveZeroes(nums);
            ArrayMethods.printArray(nums);
        }
    }

    public static void moveZeroesDFP(int[] nums) {
        // inspired by lc75 sort colors - dutch flag problem
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] == 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r--;
            } else {
                l++;
            }
        }
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len = nums.length;
        int l = 0;
        int r = 1;
        while (r < len) {
            if (nums[l] == 0 && nums[r] == 0) {
                // just r++;
            } else if (nums[l] == 0 && nums[r] != 0) {
                // swap
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            } else {
                l++;
            }
            r++;
        }
    }
}
