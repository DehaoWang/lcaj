package com.lcaj.lc33;

import algorithms.binarysearch.BinarySearch;
import algorithms.utils.ArrayUtils;

/**
 * Created by wangdehao on 18/10/28.
 */
public class SearchedInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums2 = {0, 0, 1, 0, 0, 0};
        int target = 5;
        int target2 = 1;

//        System.out.println(binarySearch(nums, target));
//        System.out.println(ArrayMethods.binarySearch(nums, target));
        System.out.println(ArrayUtils.binarySearchRotated(nums2, target2));
        System.out.println(binarySearchRotated(nums2, target2));

    }

    public static int binarySearch(int[] nums, int target) {
        return binarySearchRecursive(nums, 0, nums.length - 1, target);
    }

    public static int binarySearchRecursive(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int p = (l + r) / 2;
        int pivot = nums[p];
        if (target == pivot) {
            return p;
        } else if (target < pivot) {
            return binarySearchRecursive(nums, l, p - 1, target);
        } else if (target > pivot) {
            return binarySearchRecursive(nums, p + 1, r, target);
        }
        return -1;
    }

    public static int binarySearchRotatedRecursive(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int p = (l + r) / 2;
        int pivot = nums[p];
        if (target == pivot) {
            return p;
        } else if (target < pivot) {
            return binarySearchRotatedRecursive(nums, 0, p - 1, target);
        } else if (target > pivot) {
            return binarySearchRotatedRecursive(nums, p + 1, r, target);
        }
        return -1;
    }

    public static int binarySearchRotated(int[] nums, int target){
        return BinarySearch.binarySearchRotated(nums, target);
    }


}
