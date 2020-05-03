package algorithms.recursion;

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




    // buggy
    public static int partitionL2(int[] nums, int left, int right) {
//        System.out.println("left=" + left + ", right=" + right);
//        ArrayMethods.printArray(nums);
        int l = left;
        int r = right;
        int pivot = nums[left];
        while (l <= r) {
            // important: if using L as pivot, justify R first, vise versa
            while (l <= r && nums[r] > pivot) {
                r--;
            }
            while (l <= r && nums[l] < pivot) {
                l++;
            }
//            System.out.println("l=" + l + ", r=" + r);
            if (l <= r) {
                ArrayUtils.swap(nums, l, r);
                l++;
                r--;
            }
//            ArrayMethods.printArray(nums);
        }
        // important: use swap instead of assignment
        ArrayUtils.swap(nums, left, l);
        return l;
    }
}
