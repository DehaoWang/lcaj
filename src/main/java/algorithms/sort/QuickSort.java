package algorithms.sort;

import algorithms.utils.ArrayUtils;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 2, 7, 1, 3, 5, 2, 4};
//        int[] nums = {4, 5, 6, 2, 7, 1, 3};
//        int[] nums = {4, 4, 4, 2, 7, 4, 4};
//        int[] nums = {4, 4, 4, 4, 4, 4, 4};


        ArrayUtils.printArray(nums);
        quickSort(nums, 0, nums.length - 1);
        ArrayUtils.printArray(nums);
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        if (left < right) {
            int m = ArrayUtils.partitionL(nums, left, right);
            quickSort(nums, left, m - 1);
            quickSort(nums, m + 1, right);
        }
    }
}
