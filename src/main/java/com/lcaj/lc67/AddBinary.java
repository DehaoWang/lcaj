package com.lcaj.lc67;

import algorithms.util.ArrayMethods;

/**
 * Created by wangdehao on 18/11/13.
 */
public class AddBinary {
    public static void main(String[] args) {
        int t = 1;
//        System.out.println((char) ('0' + t));

        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));


        String a1 = "11";
        String b1 = "1";
        System.out.println(addBinary(a1, b1));

    }

    public static String addBinary(String a, String b) {

        char[] cA = a.toCharArray();
        char[] cB = b.toCharArray();
        int maxLen = (cA.length > cB.length ? cA.length : cB.length) + 1;
        char[] cS = new char[maxLen];
        ArrayMethods.reverseByIndices(cA, 0, cA.length - 1);
        ArrayMethods.reverseByIndices(cB, 0, cB.length - 1);

        int iA = 0, iB = 0, iS = 0;
        int carry = 0;
        while (iA < cA.length || iB < cB.length) {
            int dA = iA < cA.length ? cA[iA] - '0' : 0;
            int dB = iB < cB.length ? cB[iB] - '0' : 0;

            int dS = dA + dB + carry;

            if (dS <= 1) {
                cS[iS] = (char) (dS + '0');
                carry = 0;
            } else {
                cS[iS] = (char) (dS % 2 + '0');
                carry = 1;
            }
            if (iA < cA.length) {
                iA++;
            }
            if (iB < cB.length) {
                iB++;
            }
            iS++;
        }

        if (carry > 0) {
            cS[iS] = (char) (carry + '0');
        }
        ArrayMethods.reverseByIndices(cS, 0, cS.length - 1);

        String res = "";
        int firstIndex = carry > 0 ? 0 : 1;
        for (int i = firstIndex; i < cS.length; i++) {
            res += cS[i];
        }
        return res;
    }

}
