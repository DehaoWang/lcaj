package com.lcaj.lc266;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangdehao on 19/5/27.
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        String[] strs = {
                "code",
                "aab",
                "carerac",
                "aabb",
                "abdg",
        };
        for (String s : strs) {
            System.out.println(canPermutePalindrome(s));
        }

//        System.out.println(1 ^ 3 ^ 3);
//        char x = 'f';
//        System.out.println((char)(x - 4));
    }

    public static boolean canPermutePalindrome(String s) {
//        return canPermutePalindromeMap(s);
        return canPermutePalindromeBit(s);
//        return true;
    }

    private static boolean canPermutePalindromeBit(String s) {
        char[] chars = s.toCharArray();
        Set<Character> characterSet = new HashSet<>();
        int b = 0;
        for (char c : chars) {
            characterSet.add(c);
            b = b ^ c;
        }
        System.out.println(characterSet);
        System.out.println((char) b);
        return b == 0 || characterSet.contains((char) b);
    }


    public static boolean canPermutePalindromeMap(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int counter = 0;
        for (char c : chars) {
            Integer i = map.get(c);
            if (i == null || i == 0) {
                map.put(c, 1);
                counter++;
            } else if (i == 1) {
                map.put(c, 0);
                counter--;
            }
        }
        return counter == 0 || counter == 1;
    }

}
