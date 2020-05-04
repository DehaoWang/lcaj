package datastructures.advanced;

import algorithms.utils.ArrayUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class MonotonicQueue {

    private Deque<Integer> deque;

    public MonotonicQueue() {
        deque = new ArrayDeque<>();
    }

    public void pushMin(int n) {
        while (!deque.isEmpty() && deque.peekLast() > n) {
            deque.pollLast();
        }
        deque.addLast(n);
    }

    public void pushMax(int n) {
        while (!deque.isEmpty() && deque.peekLast() < n) {
            deque.pollLast();
        }
        deque.addLast(n);
    }

    public int minimax() {
        return deque.peekFirst();
    }

    public void pop(int n) {
        if (!deque.isEmpty() && deque.peekFirst() == n) {
            deque.pollFirst();
        }
    }
}
