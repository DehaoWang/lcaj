package com.lcaj.lc75;

import static algorithms.util.ArrayMethods.*;

/**
 * Created by wangdehao on 18/11/15.
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        printArray(nums);
        sortColors(nums);
        printArray(nums);

        int[] nums2 = {2, 0, 1};
        printArray(nums2);
        sortColors(nums2);
        printArray(nums2);

    }

    public static void sortColors(int[] nums) {
        // NOTE: only 3 colors: dutch national flag
        // https://en.wikipedia.org/wiki/Dutch_national_flag_problem

        int i = 0, j = 0, n = nums.length - 1;
        // easy to generate bug
        while (j <= n) {
            if (nums[j] > 1) {
                // swap & modify
                swap(nums, n, j);
                n--;
            } else if (nums[j] < 1) {
                // deal with meat 1 then 0
                swap(nums, i, j);
                i++;
                j++;
            } else {
                j++;
            }
        }
    }

}
