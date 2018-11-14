package com.lcaj.lc70;

/**
 * Created by wangdehao on 18/11/14.
 */
public class ClimbingStairs {
    public static void main(String[] args) {

        System.out.println(climbStairs(44));
    }

    public static int climbStairs(int n) {
//        return climbStairsRecursive(n);
        return climbStairsMemo(n);
    }

    private static int climbStairsMemo(int n) {
        if(n <= 2){
            return n;
        }
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        for(int i = 3; i < n + 1; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

    public static int climbStairsRecursive(int n) {
        if (n <= 2) {
            return n;
        } else {
            return climbStairs(n-1) + climbStairs(n-2);
        }
    }
}
