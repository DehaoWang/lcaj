package algorithms.faq;

import algorithms.utils.ArrayUtils;

public class SetMismatch {
    public static void main(String[] args) {
        int[] errNums = {1, 2, 3, 4, 5, 7, 5};
        ArrayUtils.printArray(findErrorNums(errNums));
    }

    public static int[] findErrorNums(int[] nums) {
        int dup = -1;
        int mis = -1;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                dup = Math.abs(nums[i]);
            } else {
                nums[index] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                mis = i + 1;
            }
        }
        return new int[]{dup, mis};
    }
}
