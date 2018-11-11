package com.lcaj.lc50;

/**
 * Created by wangdehao on 18/11/5.
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(myPow(2, 4));
        System.out.println(myPow(2, -4));
        System.out.println(myPow(0, 0));
        System.out.println(myPow(0, 2));
        System.out.println(myPow(0, -2));

        System.out.println(myPowDNC(2, 4));
        System.out.println(myPowDNC(2, -3));
        System.out.println(myPowDNC(2, -4));
        System.out.println(myPowDNC(0, 0));
        System.out.println(myPowDNC(0, 2));
        System.out.println(myPowDNC(0, -2));

    }

    public static double myPow(double x, int n) {
        double res = 1;
        if (x == 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (n > 0) {
            for (int i = 0; i < n; i++) {
                res *= x;
            }
        } else {
            for (int i = 0; i < -n; i++) {
                res *= x;
            }
            return 1 / res;
        }
        return res;
    }

    public static double myPowDNC(double x, int n) {
        if (x == 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else {
            // not fast enough
//            return myPowDNC(x, n / 2) * myPowDNC(x, n / 2) * myPowDNC(x, n % 2);
            // fast implementation
            double half = myPowDNC(x, n / 2);
            if (n % 2 == 0) {
                return half * half;
            } else if (n > 0) {
                return half * half * x;
            } else {
                return half * half / x;
            }
        }
    }
}
