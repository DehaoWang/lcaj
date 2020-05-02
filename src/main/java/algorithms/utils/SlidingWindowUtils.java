package algorithms.utils;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowUtils {
    public static Map<Character, Integer> getStrMap(String t) {
        Map<Character, Integer> strMap = new HashMap<>();
        char[] ca = t.toCharArray();
        for (char c : ca) {
            strMap.put(c, strMap.getOrDefault(c, 0) + 1);
        }
        return strMap;
    }

    public static boolean cover(Map<Character, Integer> subMap, Map<Character, Integer> tMap) {
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
