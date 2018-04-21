package com.lcaj.lc9;

/**
 * Created by wangdehao on 18/4/21.
 */
public class PalindromeNumer {
    public static void main(String[] args){
        int[] testI = {121, -121, 10};
        for(int i = 0; i < testI.length; i++){
            System.out.println(String.format("origin=%-20d, isPalindrome=%b", testI[i], isPalindrome(testI[i])));
        }
    }

    public static boolean isPalindrome(int x){
        int r = 0;
        int y = x;
        while(x > 0){
            r = 10 * r + x % 10;
            x = x / 10;
        }
        System.out.println(String.format("y=%d, r=%d", y, r));
        return r == y;
    }
}
