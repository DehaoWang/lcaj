package com.lcaj.lc150;

import com.lcaj.util.ArrayMethods;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] notations = {
//                "21+",
//                "21+3*",
//                "93/",
                "493/+"
        };
        for (String notation : notations) {
            System.out.println(evalRPN(notation.split("")));
//            System.out.println(evalRPNrec(notation.split("")));
        }


    }

//    static Set<String> operators = new HashSet<String>();
//
//    static {
//        operators.add("+");
//        operators.add("-");
//        operators.add("*");
//        operators.add("/");
//    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                // pop 2 numbers, execute then push
                int num0 = stack.pop();
                int num1 = stack.pop();
                int result = execute(num0, num1, s);
                stack.push(result);
            } else {
                // push
                Integer n = Integer.parseInt(s);
                stack.push(n);
            }
        }
        return stack.pop();
    }

    private static int execute(int num0, int num1, String s) {
        if (s.equals("+")) {
            return num1 + num0;
        } else if (s.equals("-")) {
            return num1 - num0;
        } else if (s.equals("*")) {
            return num1 * num0;
        } else if (s.equals("/")) {
            return num1 / num0;
        } else {
            return 0;
        }
    }

    public static int evalRPNrec(String[] tokens) {
//        index = tokens.length - 1;
        return helper(tokens, tokens.length - 1);
    }


    // bug for "493/+"
    public static int helper(String[] tokens, int index) {
        String token = tokens[index];
        if (index <= 1) {
            return Integer.valueOf(token);
        }
//        System.out.println("index = " + index);
        int a = helper(tokens, index - 1);
        System.out.println("a = " + a);
        int b = helper(tokens, index - 2);
        System.out.println("b = " + b);

        switch (token) {
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            case "/":
                return b / a;
            default:
                return Integer.valueOf(token);
        }
    }
}
