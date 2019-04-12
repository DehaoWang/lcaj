package com.lcaj.lc186;

import com.lcaj.util.ArrayMethods;

/**
 * Created by wangdehao on 19/4/11.
 */
public class ReverseWordsInAStringII {
    public static void main(String[] args) {
        char[] str = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        ArrayMethods.printArray(str);
        reverseWords(str);
        ArrayMethods.printArray(str);
        char[] str1 = {'t','h','e',' '};
        reverseWords(str1);
        ArrayMethods.printArray(str1);
    }

    public static void reverseWords(char[] str) {
        // step 1: reverse words one by one
        int l = 0, r = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                r = i - 1;
                ArrayMethods.reverseByIndices(str, l, r);
                l = i + 1;
            }
        }
        ArrayMethods.reverseByIndices(str, l, str.length - 1);
        ArrayMethods.printArray(str);
        // step 2: reverse whole sentence
        ArrayMethods.reverseByIndices(str, 0, str.length - 1);
    }

}
