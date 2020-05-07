package algorithms.utils;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {
    public static int simplePatternMatching(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return -1;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int i = 0, j = 0;
        while (i < charS.length && j < charT.length) {
            int k = i;
            while (k < i + charT.length) {
                if (charS[k] != charT[j]) {
                    break;
                } else {
                    k++;
                    j++;
                }
            }
            if (k == i + charT.length) {
                return i;
            }
            i++;
            j = 0;
        }
        return -1;
    }

    // if unequal, i goes back to next, j goes back to 0
    public static int simplePatternMatching2(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return -1;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int i = 0, j = 0;
        while (i < charS.length && j < charT.length) {
            if (charS[i] != charT[j]) {
                // modification
                i = i - j + 1;
                j = 0;
            } else {
                i++;
                j++;
            }
        }
        if (j == charT.length) {
            return i - j;
        }
        return -1;
    }

    // kmp: i stays, j goes back according to 'next'
    public static int kmpPatternMatching(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return -1;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int[] next = getNext(charT);
        ArrayUtils.printArray(next);
        int i = 0, j = 0;
        while (i < charS.length && j < charT.length) {
            if (j == -1 || charS[i] == charT[j]) {
                // modification
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == charT.length) {
            return i - j;
        }
        return -1;
    }

    private static int[] getNext(char[] charT) {
        int[] next = new int[charT.length];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < charT.length - 1) {
            if (j == -1 || charT[i] == charT[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static Map<Character, Integer> getStrMap(String t) {
        Map<Character, Integer> strMap = new HashMap<>();
        char[] ca = t.toCharArray();
        for (char c : ca) {
            strMap.put(c, strMap.getOrDefault(c, 0) + 1);
        }
        return strMap;
    }

    public static boolean cover(Map<Character, Integer> subMap, Map<Character, Integer> tMap) {
        if (subMap.size() < tMap.size()) {
            return false;
        }
        for (Character c : tMap.keySet()) {
            int tc = tMap.get(c);
            int sc = subMap.getOrDefault(c, 0);
            if (sc < tc) {
                return false;
            }
        }
        return true;
    }

    public static boolean unique(Map<Character, Integer> subMap) {
        for (Character c : subMap.keySet()) {
            if (subMap.get(c) > 1) {
                return false;
            }
        }
        return true;
    }
}
