package com.lcaj.lc171;

/**
 * Created by wangdehao on 19/4/9.
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {

        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("C"));
        System.out.println(titleToNumber("Z"));
        System.out.println(titleToNumber("AA"));
    }

    public static int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len == 0) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < len; i++) {
            num = (chars[i] + 1 - 'A') + 26 * num;
        }

        return num;
    }
}
