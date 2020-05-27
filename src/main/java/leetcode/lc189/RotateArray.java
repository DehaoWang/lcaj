package leetcode.lc189;

import algorithms.utils.ArrayUtils;

/**
 * Created by wangdehao on 19/4/11.
 */
public class RotateArray {
    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 3, 4, 5, 6};
        ArrayUtils.printArray(nums);
        rotate(nums, 3);
        ArrayUtils.printArray(nums);
    }

    private static void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        k = k % len;
        ArrayUtils.reverseByIndices(nums, 0, len - 1);
        ArrayUtils.reverseByIndices(nums, 0, k - 1);
        ArrayUtils.reverseByIndices(nums, k, len - 1);
    }


    public static void rotateByMovIdx(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        k = k % len;
        int temp = 0;
        int temp2 = 0;
        int index = 0;
        int cnt = 0;
        temp = nums[index];
        while (cnt < len) {
            nums[index] = nums[(index + len - k) % len];
            System.out.println("index=" + index + ",temp=" + temp + ",from=" + (index + len - k) % len);
            index = (index + k) % len;
            temp2 = nums[index];
            nums[index] = temp;
            temp = temp2;
            cnt++;
            ArrayUtils.printArray(nums);
        }
        return;
    }
}
