package com.lcaj.lc739;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; i--) {    // 倒着往栈里放
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {   // 判定索引
                stack.pop();    // 矮个起开，反正也被挡着了。。。
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;    // 索引间距
            stack.push(i);    // 索引
        }
//        System.out.println(stack);
        return ans;
    }
}
