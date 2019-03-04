package com.lcaj.lc153;

/**
 * Created by wangdehao on 18/12/11.
 */
public class FindMinInRotatedSortedArray {
    public static void main(String[] args) {
        int[][] matrix = {
//                {4, 3, 1, 5, 2},
                {4, 5, 6, 7, 1, 2, 3},
                {2, 1},
        };
        for (int[] nums : matrix) {
            System.out.println(findMin(nums));
            System.out.println(findMinBin(nums));
        }
    }

    private static int findMinBin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] < nums[r]) {
            return nums[0];
        }
        int mid = 0;
        while (l < r - 1) {
            mid = (l + r) / 2;
            System.out.println("l=" + l + ",r=" + r + ",mid=" + mid);
            if (nums[l] < nums[r]) {
                // search in left
                r = mid;
            } else {
                // search in right
                l = mid;
            }
        }
        if (l == r - 1) {
            return Math.min(nums[l], nums[r]);
        }
        return nums[mid];
    }

    public static int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                continue;
            } else {
                min = nums[i + 1];
            }
        }

        return min;
    }
}
