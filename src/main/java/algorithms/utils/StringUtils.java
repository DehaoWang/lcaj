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

    public static String arr2Str(int[] arr) {
        String res = "";
        for (int i : arr) {
            res += i;
        }
        return res;
    }

    public static String copy(String str) {
        String copy = "";
        for (Character c : str.toCharArray()) {
            copy += c;
        }
        return copy;
    }

    public static String reverseByIndices(String str, int l, int r) {
        String rev = "";
        char[] chars = str.toCharArray();
        ArrayUtils.reverseByIndices(chars, l, r);
        for (char c : chars) {
            rev += c;
        }
        return rev;
    }

    public static String manacherPalindromicTesting(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        String str = addBoundaries(s, '#');
        int sLen = 2 * len + 1;
        int maxLen = 1;

        int start = 0;
        for (int i = 0; i < sLen; i++) {
            int curLen = centerSpread(str, i);
            if (curLen > maxLen) {
                maxLen = curLen;
                start = (i - maxLen) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private static int centerSpread(String s, int center) {
        // left = right 的时候，此时回文中心是一个空隙，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是任意一个字符，回文串的长度是偶数
        int len = s.length();
        int i = center - 1;
        int j = center + 1;
        int step = 0;
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            step++;
        }
        return step;
    }


    /**
     * 创建预处理字符串
     *
     * @param s      原始字符串
     * @param divide 分隔字符
     * @return 使用分隔字符处理以后得到的字符串
     */
    private static String addBoundaries(String s, char divide) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        if (s.indexOf(divide) != -1) {
            throw new IllegalArgumentException("参数错误，您传递的分割字符，在输入字符串中存在！");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(divide);
            stringBuilder.append(s.charAt(i));
        }
        stringBuilder.append(divide);
        return stringBuilder.toString();
    }
}
