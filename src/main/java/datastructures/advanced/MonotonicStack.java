package datastructures.advanced;

import algorithms.utils.ArrayUtils;

import java.util.Stack;

public class MonotonicStack {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 3};
        ArrayUtils.printArray(nums);
        ArrayUtils.printArray(nextGreaterElementSimple(nums));
        ArrayUtils.printArray(nextGreaterElementCyclic(nums));
        ArrayUtils.printArray(dailyTemperatures(nums));
    }

    public static int[] nextGreaterElementSimple(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack();
        for (int i = nums.length - 1; i >= 0; i--) {    // 倒着往栈里放
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {   // 判定个子高矮
                stack.pop();    // 矮个起开，反正也被挡着了。。。
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();   // 这个元素身后的第一个高个
            stack.push(nums[i]);    // 进栈，接受身后的身高判定吧！
        }
//        System.out.println(stack);
        return ans;
    }

    public static int[] nextGreaterElementCyclic(int[] nums) {
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

    public static int[] dailyTemperatures(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack();
        for (int i = nums.length - 1; i >= 0; i--) {    // 倒着往栈里放
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {   // 判定索引
                stack.pop();    // 矮个起开，反正也被挡着了。。。
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;    // 索引间距
            stack.push(i);    // 索引
        }
//        System.out.println(stack);
        return ans;
    }
}
