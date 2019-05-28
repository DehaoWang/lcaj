package com.lcaj.lc280;

import com.lcaj.util.ArrayMethods;

/**
 * Created by wangdehao on 19/5/28.
 */
public class WiggleSort {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 5, 2, 1, 6, 4},
                {16, 16, 5},
                {14, 3, 19}
        };
        for (int[] nums : matrix) {
            ArrayMethods.printArray(nums);
            wiggleSort(nums);
            ArrayMethods.printArray(nums);
        }
    }

    public static void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i + 1])
                    || (i % 2 != 0 && nums[i] < nums[i + 1])) {
                // swap
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }
}
