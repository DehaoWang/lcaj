package leetcode.lc20;

import java.util.Stack;

/**
 * Created by wangdehao on 18/4/28.
 */
public class ValidParentheses {
    public static void main( String[] args ) {
        String[] testS = {
                "()",
                "()[]{}",
                "(]",
                "{[)]",
                "{[]}",
                ""
        };
        for(String s :testS){
            System.out.println(String.format("s=%s, isValid=%b", s, isValid(s)));
        }

    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else if(c == ')' || c == ']' || c == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                else {
                    char l = stack.pop();
                    if(! isValidPair(l, c)){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    // auxiliary method
    public static boolean isValidPair(char l, char r){
        if(l == '(' && r == ')'){
            return true;
        }
        if(l == '[' && r == ']'){
            return true;
        }
        if(l == '{' && r == '}'){
            return true;
        }
        return false;
    }
}
