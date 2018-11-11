package com.lcaj.lc55;

/**
 * Created by wangdehao on 18/11/11.
 */
public class JumpGame {


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums1 = {3, 2, 1, 0, 4};

        System.out.println(canJump(nums));
        System.out.println(canJump(nums1));
    }

    public static boolean canJump(int[] nums) {
        return canJumpRecursive(nums, 0);
    }

    public static boolean canJumpRecursive(int[] nums, int fromIdx) {
        if (fromIdx == nums.length - 1) {
            return true;
        }
        if (fromIdx > nums.length - 1) {
            return false;
        }
        int maxSteps = nums[fromIdx];
        for (int i = 1; i <= maxSteps; i++) {
            if (canJumpRecursive(nums, fromIdx + i)) {
                return true;
            }
        }
        return false;
    }
}
