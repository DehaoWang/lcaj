package com.lcaj.lc28;

/**
 * Created by wangdehao on 18/5/3.
 */
public class ImplementStrStr {

    public static void main( String[] args ) {
        String[][] m = {
                {"hello", "ll"},
                {"aaaaa", "bba"},
                {"davidwang", "idw"},
                {"aaa", "aaaaa"},
                {"aaabc", "abc"},
        };
        for(String[] s: m){
            System.out.println(s[0]+" .index of "+s[1]+"="+strStr(s[0], s[1]));
        }

    }

    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }

        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        for(int i = 0; i < hay.length-nee.length+1; i++){
            boolean diff = false;
            for(int j = 0; j < nee.length && !diff; j++){
                if(hay[i+j] != nee[j]){
                    diff = true;
                }
            }
            if(!diff){
                return i;
            }
        }

        return -1;
    }
}
