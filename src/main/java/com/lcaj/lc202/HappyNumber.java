package com.lcaj.lc202;

/**
 * Created by wangdehao on 19/4/15.
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(getBitSqSum(132));
        System.out.println(getBitSqSum(100));
        System.out.println(getBitSqSum(19));

        for (int i = 0; i < 100; i++) {
            System.out.println("i = " + i + ", isHappy = " + isHappy(i));
        }
    }

    // TLE
    public static boolean isHappyIntuitive(int n) {

        int bitSqSum = getBitSqSum(n);
        while (bitSqSum != 1) {
            bitSqSum = getBitSqSum(bitSqSum);
        }

        return bitSqSum == 1;
    }

    public static boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = getBitSqSum(slow);
            fast = getBitSqSum(fast);
            fast = getBitSqSum(fast);
        } while (slow != fast);
        if (slow == 1) {
            return true;
        } else {
            return false;
        }
    }


    private static int getBitSqSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
