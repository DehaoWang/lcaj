package com.lcaj.lc168;

import com.lcaj.lc8.StringToInteger;

/**
 * Created by wangdehao on 19/4/8.
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {

        for (int i = 0; i < 701; i++) {

            System.out.println(i + ":" + convertToTitle(i));
        }
    }

    public static String convertToTitle(int n) {
        String result = "";
        while (n > 0) {
            // convert to 0-25 range
            n--;
            int i = n % 26;
            result = (char) ('A' + i) + result;
            n = n / 26;
        }
        return result;
    }

}
