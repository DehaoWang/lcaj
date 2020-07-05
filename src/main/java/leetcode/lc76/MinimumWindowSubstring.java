package leetcode.lc76;

import algorithms.utils.StringUtils;

import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        int l = 0, r = 0, minLen = Integer.MAX_VALUE;
        String res = "";
        char[] sArr = StringUtils.getStrArr(s.substring(l, r + 1));
        char[] tArr = StringUtils.getStrArr(t);
        while (r < s.length()) {
            if (satisfied(sArr, tArr)) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                char cl = s.charAt(l);
                sArr[cl - 'A']--;
                l++;
            } else {
                r++;
                if (r < s.length()) {
                    char cr = s.charAt(r);
                    sArr[cr - 'A']++;
                }
            }
        }

        return res;
    }

    public static boolean satisfied(char[] sArr, char[] tArr) {
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] < tArr[i]) {
                return false;
            }
        }
        return true;
    }
}
