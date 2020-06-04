package algorithms.slidingwindow;

import algorithms.utils.ArrayUtils;
import datastructures.advanced.xifo.MonotonicQueue;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        ArrayUtils.printArray(maxSlidingWindow(nums, 3));
        ArrayUtils.printArray(minSlidingWindow(nums, 3));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        return maxSlidingWindowBool(nums, k, true);
    }

    public static int[] minSlidingWindow(int[] nums, int k) {
        return maxSlidingWindowBool(nums, k, false);
    }

    public static int[] maxSlidingWindowBool(int[] nums, int k, boolean max) {
        int[] ans = new int[nums.length - k + 1];
        MonotonicQueue monoQ = new MonotonicQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                if (max) {
                    monoQ.pushMax(nums[i]);
                } else {
                    monoQ.pushMin(nums[i]);
                }
            } else {
                if (max) {
                    monoQ.pushMax(nums[i]);
                } else {
                    monoQ.pushMin(nums[i]);
                }
                ans[i - k + 1] = monoQ.minimax();
                monoQ.pop(nums[i - k + 1]);
            }
        }
        return ans;
    }
}
