package leetcode.lc239;

import algorithms.slidingwindow.MaxSlidingWindow;
import algorithms.utils.ArrayUtils;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        ArrayUtils.printArray(MaxSlidingWindow.maxSlidingWindow(nums, 3));
    }
}
