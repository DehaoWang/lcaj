package com.lcaj.lc503;

import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack();
        for (int i = nums.length * 2 - 1; i >= 0; i--) {    // 倒着往栈里放
            int actIdx = i % nums.length;
            while (!stack.isEmpty() && stack.peek() <= nums[actIdx]) {   // 判定个子高矮
                stack.pop();    // 矮个起开，反正也被挡着了。。。
            }
            ans[actIdx] = stack.isEmpty() ? -1 : stack.peek();   // 这个元素身后的第一个高个
            stack.push(nums[actIdx]);    // 进栈，接受身后的身高判定吧！
        }
//        System.out.println(stack);
        return ans;
    }
}
