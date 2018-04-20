package com.lcaj.lc5;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangdehao on 18/4/11.
 */
public class LongestPalindromicSubstring {

    public static int low;
    public static int maxLen;
    /**
     * test cases
     */

    public static void main(String[] args){

        compare("cbbd");
        compare("a");
        compare("ab");
        compare("aaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    public static void compare(String s){
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromeGS(s));
    }

    /**
     * algorithm
     */

    // submitted
    public static String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        // make char 2 index,
        Map<Character, Set<Integer>> char2Index = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            Set<Integer> indexSet = char2Index.get(c);
            if(indexSet == null){
                indexSet = new HashSet<>();
                char2Index.put(c, indexSet);
            }
            indexSet.add(i);
        }

        int max = 0;
        String lps = ""+s.charAt(0);
//        System.out.println(char2Index);
        for(Character c: char2Index.keySet()){
            Set<Integer> indexSet = char2Index.get(c);
            if(indexSet.size() > 1){
                for(int x: indexSet){
                    for(int y: indexSet){
                        if(x < y){
                            String testS = s.substring(x, y+1);
//                            System.out.println("x="+x+",y="+y+",testS="+testS);
                            if(isPalindrome(testS)){
                                if(testS.length() > max){
                                    max = testS.length();
                                    lps = testS;
                                }
                            }
                        }
                    }
                }
            }
        }
        return lps;
    }

    private static boolean isPalindrome(String testS) {
        int i = 0, j = testS.length()-1;
        while(i < j){
            if(testS.charAt(i) != testS.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }

    // good solutions:
    public static String longestPalindromeGS(String s) {
        low = 0;
        maxLen = 0;

        if(s.length() < 2){
            return s;
        }
        for(int i = 0; i < s.length(); i++){
            extandPalindrome(s, i, i);
            extandPalindrome(s, i, i+1);
        }

        return s.substring(low, low+maxLen);
    }

    private static void extandPalindrome(String s, int m, int n) {
        while(m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)){
            m--;
            n++;
        }
        if(n-1-m > maxLen){
            maxLen = n-1-m;
            low = m+1;
        }
    }

}
