package com.lcaj.lc69;

/**
 * Created by wangdehao on 18/11/14.
 */
public class SqrtX {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(mySqrt(i));
        }
        System.out.println(mySqrt(2147395600));

    }

    public static int mySqrt(int x) {
//        return mySqrtLin(x);
        return mySqrtLg(x);
    }

    private static int mySqrtLg(int x) {
        int l = 0;
        int r = x;
        if (x == 1) {
            return 1;
        }
        while (l < r - 1) {
            int mid = (l + r) / 2;
            // transform to get rid of boundary problem
            if (mid > x / mid) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }

    private static int mySqrtLin(int x) {
        int res = 0;
        for (int i = 0; i <= x; i++) {
            if (i * i < 0 || i * i > x) {
                break;
            } else {
                res = i;
            }
        }
        return res;
    }
}
