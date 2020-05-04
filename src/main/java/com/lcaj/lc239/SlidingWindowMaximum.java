package com.lcaj.lc239;

import algorithms.utils.ArrayUtils;
import datastructures.advanced.MonotonicQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        ArrayUtils.printArray(MonotonicQueue.maxSlidingWindow(nums, 3));
    }
}
