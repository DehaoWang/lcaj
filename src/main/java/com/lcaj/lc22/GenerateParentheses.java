package com.lcaj.lc22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.lcaj.lc20.ValidParentheses.isValid;


/**
 * Created by wangdehao on 18/4/28.
 */
public class GenerateParentheses {
    public static void main( String[] args ) {

        for(int i = 0; i < 4; i++){
            System.out.println(String.format("i=%d, ps=%s", i, generateParenthesisBF(i)));
        }

    }

    // TODO: 18/4/28 Better Algorithm
    public static List<String> generateParenthesis(int n) {


        return null;
    }


    // beat 1.34%

    public static List<String> generateParenthesisBF(int n){
        List<String> res = new ArrayList<>();
        int len = 2 * n;
        for(int i = 0; i < Math.pow(2, len); i++){
            StringBuilder sb = new StringBuilder();
            int count = len;
            // easy to make mistake
            int num = i;
            while(count > 0){
                int r = num % 2;
                if(r == 0){
                    sb.append(')');
                }
                else {
                    sb.append('(');
                }
                num /= 2;
                count--;
            }
            String test = sb.toString();
            if(isValid(test)){
                res.add(test);
            }
        }
        return res;
    }

    public static List<String> generateParenthesisRecursive(int n) {
        List<String> res = new ArrayList<>();

        if(n == 1){
            return Arrays.asList("()");
        }

        if(n > 1){
            List<String> ps = generateParenthesis(n - 1);

        }

        return null;
    }



}
