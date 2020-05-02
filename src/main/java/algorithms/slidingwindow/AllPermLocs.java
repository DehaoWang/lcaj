package algorithms.slidingwindow;

import algorithms.utils.SlidingWindowUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPermLocs {
    public static void main(String[] args) {
        String s = "cbaebabacdecabc";
        String t = "abc";
        System.out.println(findAllPermLocsSW(s, t));
    }

    public static List<Integer> findAllPermLocsSW(String s, String t) {
        List<Integer> locs = new ArrayList<>();
        int l = 0;
        int r = 0;
        Map<Character, Integer> tMap = SlidingWindowUtils.getStrMap(t);
        Map<Character, Integer> subMap = new HashMap<>();
        subMap.put(s.charAt(0), 1);
        while (r < s.length()) {
            // match: l++; else: r++
            if (!SlidingWindowUtils.cover(subMap, tMap)) {
                r++;
                if (r < s.length()) {
                    char cR = s.charAt(r);
                    subMap.put(cR, subMap.getOrDefault(cR, 0) + 1);
                }
            } else {
                if (r - l + 1 == t.length()) {
                    if (!s.substring(l, r + 1).equals(t)) {
                        locs.add(l);
                    }
                }
                char cL = s.charAt(l);
                subMap.put(cL, subMap.get(cL) - 1);
                l++;
            }
        }
        return locs;
    }
}
