package leetcode.lc242;

import algorithms.utils.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdehao on 19/5/5.
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagramSort("anagram", "nagaram"));
        System.out.println(isAnagramU("anagram", "nagaram"));

        System.out.println(isAnagram("anagra", "nagaram"));
        System.out.println(isAnagramSort("anagra", "nagaram"));
        System.out.println(isAnagramU("anagra", "nagaram"));


        System.out.println(isAnagram("anagrm", "nagaram"));
        System.out.println(isAnagramSort("anagrm", "nagaram"));
        System.out.println(isAnagramU("anagrm", "nagaram"));

    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> recipe = new HashMap<>();
        // read s
        char[] sArray = s.toCharArray();
        for (char c : sArray) {
            if (!recipe.containsKey(c)) {
                recipe.put(c, 0);
            }
            recipe.put(c, recipe.get(c) + 1);
        }
        // read t
        char[] tArray = t.toCharArray();
        for (char c : tArray) {
            if (!recipe.containsKey(c)) {
                return false;
            } else {
                recipe.put(c, recipe.get(c) - 1);
            }
        }
        // check
        for (Integer cnt : recipe.values()) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramSort(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        if (sArray.length != tArray.length) {
            return false;
        } else {
            for (int i = 0; i < sArray.length; i++) {
                if (sArray[i] != tArray[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isAnagramU(String s, String t) {
        if (s.equals(t)) {
            return false;
        }
        Map<Character, Integer> sMap = StringUtils.getStrMap(s);
        Map<Character, Integer> tMap = StringUtils.getStrMap(t);

        return StringUtils.cover(sMap, tMap) && StringUtils.cover(tMap, sMap);
    }
}