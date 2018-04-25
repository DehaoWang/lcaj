package com.lcaj.lc14;

/**
 * Created by wangdehao on 18/4/24.
 */
public class LongestCommonPrefix {
    public static void main(String[] args){
        String[][] strs = {
                {"flower", "flow", "flight"},
                {"dog", "racecar", "car"},
                {"father", "mother", "me"},
        };
        for(int i = 0; i < strs.length; i++){
            String[] testStrs = strs[i];
            System.out.println(String.format("lcp=%s", longestCommonPrefix(testStrs)));
        }
    }

    public static String longestCommonPrefix(String[] strs){
        if(strs.length == 0){
            return "";
        }
        int index = 0;
        char c;
        boolean terminate = false;
        while(!terminate){
            c = ' ';
            for(int i = 0; i < strs.length; i++){
                if(index >= strs[i].length()){
                    terminate = true;
                }
                else {
                    char t = strs[i].charAt(index);
                    System.out.println(String.format("index=%d, i=%d, c=%s, t=%s, str=%s", index, i, c, t, strs[i]));
                    if(t != c && i == 0){
                        c = t;
                    }else if(t != c && i > 0){
                        terminate = true;
                    }
                }
            }
            index++;
        }
        return strs[0].substring(0, index-1);
    }
}
