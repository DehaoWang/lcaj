package com.lcaj.lc724;

public class FindPivotIndex {
    public static void main(String[] args) {

    }

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return 0;
        } else if (nums.length == 2) {
            if (nums[0] == 0) {
                return 1;
            } else if (nums[1] == 0) {
                return 0;
            }
        }

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        if (leftSum == rightSum) {
            return 0;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i + 1];
            if (leftSum == rightSum) {
                return i + 1;
            }
        }
        return -1;
    }
}
