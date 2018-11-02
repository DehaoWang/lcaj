package com.lcaj.lc31;

/**
 * Created by wangdehao on 18/5/7.
 */
public class NextPermutation {


    public static void main(String[] args) {
        //    1,2,3 → 1,3,2
        //    3,2,1 → 1,2,3
        //    1,1,5 → 1,5,1
        int[][] nums = {
                {1, 2, 3},
                {3, 2, 1},
                {1, 1, 5}
        };
        for (int i = 0 ; i < nums.length; i++) {
            nextPermutation(nums[i]);
            printNums(nums[i]);
        }

    }


    public static void printNums(int[] nums) {
        for (int i : nums) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
