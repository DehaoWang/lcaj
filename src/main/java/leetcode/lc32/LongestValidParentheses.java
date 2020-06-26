package leetcode.lc32;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String[] tests = {
                "(()", ")()())", "(()",
                "()(()"
        };
        for (String test : tests) {
            System.out.println("Stack Approach: " + longestValidParentheses(test));
            System.out.println("Scan Approach:" + longestValidParenthesesTwoWayScan(test));
        }
    }

    public static int longestValidParentheses(String s) {
        // transformed from valid parentheses
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static int longestValidParenthesesTwoWayScan(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left < right) {
                left = 0;
                right = 0;
            } else if (left == right) { // important
                maxLen = Math.max(maxLen, right * 2);
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left > right) {
                left = 0;
                right = 0;
            } else if (left == right) { // important
                maxLen = Math.max(maxLen, left * 2);
            }
        }
        return maxLen;
    }
}
