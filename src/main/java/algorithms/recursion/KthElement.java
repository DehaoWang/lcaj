package algorithms.recursion;

import algorithms.util.ArrayMethods;

import static algorithms.recursion.QuickSort.partitionL;

public class KthElement {
    //COMPLETE QuickSort Solution
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 2, 7, 1, 3, 5, 2, 4};
        System.out.println(getKthLargest(nums, 5));
        System.out.println(getKthSmallest(nums, 1));
    }

    public static int getKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int getKthSmallest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    public static int quickSelect(int[] nums, int left, int right, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (left == right) {
            return nums[left];
        }
        if (left < right) {
            int m = partitionL(nums, left, right);
//            System.out.println("m=" + m + ", k=" + k);
//            ArrayMethods.printArray(nums);
            if (m == k) {
                return nums[m];
            } else if (m < k) {
                return quickSelect(nums, m + 1, right, k);
            } else {
                return quickSelect(nums, left, m - 1, k);
            }
        }
        return -1;
    }
}
