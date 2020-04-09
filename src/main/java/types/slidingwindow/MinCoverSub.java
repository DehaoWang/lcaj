package types.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinCoverSub {
    public static void main(String[] args) {
        String s = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXADOBECODEBANCAABC";
        String t = "ABCC";

        long t0 = System.currentTimeMillis();

        System.out.println(minCoverSubBF(s, t));
        long t1 = System.currentTimeMillis();
        System.out.println("time used: " + (t1 - t0));

        System.out.println(minCoverSubSW(s, t));
        long t2 = System.currentTimeMillis();
        System.out.println("time used: " + (t2 - t1));
    }

    public static String minCoverSubBF(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        Map<Character, Integer> tMap = getStrMap(t);
        int min = Integer.MAX_VALUE;
        String minSub = "";
        for (int i = 0; i <= lenS - lenT; i++) {
            for (int j = i + lenT; j <= lenS; j++) {
                String sub = s.substring(i, j);
                Map<Character, Integer> subMap = getStrMap(sub);
                if (cover(subMap, tMap)) {
                    if (j - i < min) {
                        min = j - i;
                        minSub = sub;
                    }
                }
            }
        }
        return minSub;
    }

    private static Map<Character, Integer> getStrMap(String t) {
        Map<Character, Integer> strMap = new HashMap<>();
        char[] ca = t.toCharArray();
        for (char c : ca) {
            strMap.put(c, strMap.getOrDefault(c, 0) + 1);
        }
        return strMap;
    }

    private static boolean cover(Map<Character, Integer> subMap, Map<Character, Integer> tMap) {
        for (Character c : tMap.keySet()) {
            int tc = tMap.get(c);
            int sc = subMap.getOrDefault(c, 0);
            if (sc < tc) {
                return false;
            }
        }
        return true;
    }

    public static String minCoverSubSW(String s, String t) {
        int lenS = s.length();
        Map<Character, Integer> tMap = getStrMap(t);
        int min = Integer.MAX_VALUE;
        String minSub = "";
        int l = 0;
        int r = 0;
        Map<Character, Integer> subMap = new HashMap<>();
        subMap.put(s.charAt(0), 1);
        while (r < lenS) {
            // match: l++; else: r++;
            if (!cover(subMap, tMap)) {
                r++;
                if (r < lenS) {
                    char cr = s.charAt(r);
                    subMap.put(cr, subMap.getOrDefault(cr, 0) + 1);
                }
            } else {
                if (r - l + 1 < min) {
                    min = Math.min(min, r - l + 1);
                    minSub = s.substring(l, r + 1);
                }
                char cl = s.charAt(l);
                l++;
                subMap.put(cl, subMap.get(cl) - 1);
            }
        }
        return minSub;
    }
}
