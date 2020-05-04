package datastructures.advanced;

import algorithms.utils.ArrayUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class MonotonicQueue {
    public static void main(String[] args) {
        Deque deque = new ArrayDeque();
        for (int i = 0; i < 6; i++) {
            deque.addLast(i);
        }
        System.out.println(deque);
        deque.pollLast();
        System.out.println(deque);
        System.out.println(deque.peekLast());
        System.out.println(deque.peekFirst());

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

    public MonotonicQueue() {
        dq = new ArrayDeque<>();
    }

    private Deque<Integer> dq;

    public void push(int n) {
        while (!dq.isEmpty() && dq.peekLast() < n) {
            dq.pollLast();
        }
        dq.addLast(n);
    }

    public int max() {
        return dq.peekFirst();
    }

    public void pop(int n) {
        if (!dq.isEmpty() && dq.peekFirst() == n) {
            dq.pollFirst();
        }
    }

}
