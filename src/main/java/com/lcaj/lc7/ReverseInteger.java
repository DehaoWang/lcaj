package com.lcaj.lc7;

/**
 * Created by wangdehao on 18/4/20.
 */
public class ReverseInteger {
    public static void main(String[] args){

//        System.out.println(Integer.MAX_VALUE/2);
//        System.out.println(1534236469);
        System.out.println(reverse(1534236469));
//        System.out.println(reverse(534236469));


//        System.out.println(powerOfTwo(3));
//        System.out.println(powerOfTwo(10));
//        System.out.println(powerOfTwo(30)-1);

    }


    public static int reverse(int x){
        long r = 0;
        for(; x != 0; x /= 10) {
            r = r * 10 + x % 10;
            if(r > Integer.MAX_VALUE || r < Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int)r;
    }

    public static int powerOfTwo(int pow){
        int res = 1;
        for(int i = 0; i < pow; i++){
            res *= 2;
        }
        return res;
    }
}
