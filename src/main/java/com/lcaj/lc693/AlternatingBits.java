package com.lcaj.lc693;

public class AlternatingBits {
    public static void main(String[] args) {

        System.out.println(hasAlternatingBits(4));
    }

    public static boolean hasAlternatingBits(int n) {
        int r = n % 2;
        n = n / 2;
        while (n > 0) {
            if (r == n % 2) {
                return false;
            } else {
                r = n % 2;
                n = n / 2;
            }
        }
        return true;
    }
}
