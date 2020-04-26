package com.lcaj.lc155;

import java.util.Stack;

/**
 * Created by wangdehao on 19/3/4.
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    int min = Integer.MAX_VALUE;

    Stack<Integer> stack = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (min == stack.pop()) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        System.out.println(minStack.getMin());
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}
