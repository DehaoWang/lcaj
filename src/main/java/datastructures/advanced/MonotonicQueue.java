package datastructures.advanced;

import algorithms.utils.ArrayUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class MonotonicQueue {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        ArrayUtils.printArray(maxSlidingWindow(nums, 3));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        MonotonicQueue monoQ = new MonotonicQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                monoQ.push(nums[i]);
            } else {
                monoQ.push(nums[i]);
                ans[i - k + 1] = monoQ.max();
                monoQ.pop(nums[i - k + 1]);
            }
        }
        return ans;
    }

    private Deque<Integer> deque;

    public MonotonicQueue() {
        deque = new ArrayDeque<>();
    }

    public void push(int n) {
        while (!deque.isEmpty() && deque.peekLast() < n) {
            deque.pollLast();
        }
        deque.addLast(n);
    }

    public int max() {
        return deque.peekFirst();
    }

    public void pop(int n) {
        if (!deque.isEmpty() && deque.peekFirst() == n) {
            deque.pollFirst();
        }
    }
}
