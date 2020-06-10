package algorithms.sort;

import algorithms.utils.ArrayUtils;

public class SortColors {
    public static void main(String[] args) {
//        int[] nums = {0, 0, 2, 1, 1, 2};
//        int[] nums = {0, 0, 2, 1, 1, 2, 1, 0, 2, 0, 1, 0, 1, 2, 2, 0, 2, 1, 1};
        int[] nums = {2, 0, 1};

        sortColors(nums);
        ArrayUtils.printArray(nums);
    }

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int l = 0;
        int r = nums.length - 1;
        int p = 0;
        while (p <= r) {
            if (nums[p] == 0) {
                ArrayUtils.swap(nums, p, l);
                p++;
                // there is no 2 on the left
                l++;
            } else if (nums[p] == 2) {
                ArrayUtils.swap(nums, p, r);
                r--;
                // we may have a 0 by swapping
            } else {
                p++;
            }
        }
    }
}
