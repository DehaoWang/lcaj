package algorithms.slidingwindow;

import algorithms.utils.SlidingWindowUtils;

import java.util.HashMap;
import java.util.Map;

public class MaxUniqueSub {
    public static void main(String[] args) {
        String[] tests = {
                "abcabcbb",
                "bbbbb",
                "pwwkew"
        };
        for (String s : tests) {
            System.out.println(s + " : " + maxUniqueSubSW(s));
        }
    }

    public static int maxUniqueSubSW(String s) {
        int maxLen = 1;
        int l = 0;
        int r = 0;
        Map<Character, Integer> subMap = new HashMap<>();
        subMap.put(s.charAt(0), 1);
        while (r < s.length()) {
            // match: r++; else: l++
            if (SlidingWindowUtils.unique(subMap)) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                }
                r++;
                if (r < s.length()) {
                    char cR = s.charAt(r);
                    subMap.put(cR, subMap.getOrDefault(cR, 0) + 1);
                }
            } else {
                char cL = s.charAt(l);
                subMap.put(cL, subMap.get(cL) - 1);
                l++;
            }
        }
        return maxLen;
    }
}
