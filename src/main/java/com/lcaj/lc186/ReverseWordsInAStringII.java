package com.lcaj.lc186;

import algorithms.utils.ArrayUtils;

/**
 * Created by wangdehao on 19/4/11.
 */
public class ReverseWordsInAStringII {
    public static void main(String[] args) {
        char[] str = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        ArrayUtils.printArray(str);
        reverseWords(str);
        ArrayUtils.printArray(str);
        char[] str1 = {'t','h','e',' '};
        reverseWords(str1);
        ArrayUtils.printArray(str1);
    }

    public static void reverseWords(char[] str) {
        // step 1: reverse words one by one
        int l = 0, r = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                r = i - 1;
                ArrayUtils.reverseByIndices(str, l, r);
                l = i + 1;
            }
        }
        ArrayUtils.reverseByIndices(str, l, str.length - 1);
        ArrayUtils.printArray(str);
        // step 2: reverse whole sentence
        ArrayUtils.reverseByIndices(str, 0, str.length - 1);
    }

}
