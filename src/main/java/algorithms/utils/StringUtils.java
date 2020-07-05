package algorithms.utils;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {
//    public static int simplePatternMatching(String s, String t) {
//        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
//            return -1;
//        }
//        char[] charS = s.toCharArray();
//        char[] charT = t.toCharArray();
//        int i = 0, j = 0;
//        while (i < charS.length && j < charT.length) {
//            int k = i;
//            while (k < i + charT.length) {
//                if (charS[k] != charT[j]) {
//                    break;
//                } else {
//                    k++;
//                    j++;
//                }
//            }
//            if (k == i + charT.length) {
//                return i;
//            }
//            i++;
//            j = 0;
//        }
//        return -1;
//    }

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
//        ArrayUtils.printArray(next);
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

    public static int rkPatternMatching(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        int h = 1;

        int tHashcode = rkHashCode(t);
        int sHashcode = rkHashCode(s.substring(0, tLen));

//        int tHashcode = 0;
//        int sHashcode = 0;
//        for (int i = 0; i < tLen; i++) {
//            tHashcode = (base * tHashcode + t.charAt(i)) % mod;
//            sHashcode = (base * sHashcode + s.charAt(i)) % mod;
//        }

        for (int i = 0; i < tLen - 1; i++) {
            h = (h * base) % mod;
        }

        for (int i = 0; i <= sLen - tLen; i++) {
            if (sHashcode == tHashcode && s.substring(i, i + tLen).equals(t)) {
                return i;
            } else {
                if (i < sLen - tLen) {
                    sHashcode = (base * (sHashcode - s.charAt(i) * h) + s.charAt(i + tLen)) % mod;
                }
                if (sHashcode < 0) {
                    sHashcode += mod;
                }
            }
        }

        return -1;
    }

    private static int base = 256;
    private static int mod = 101;

    public static int rkHashCode(String t) {
        int hc = 0;
        for (int i = 0; i < t.length(); i++) {
            hc = (hc * base + t.charAt(i)) % mod;
        }
        return hc;
    }

    public static Map<Character, Integer> getStrMap(String t) {
        Map<Character, Integer> strMap = new HashMap<>();
        char[] ca = t.toCharArray();
        for (char c : ca) {
            strMap.put(c, strMap.getOrDefault(c, 0) + 1);
        }
        return strMap;
    }

    public static String getAnagramEncoding(String t) {
        int[] count = new int[26];
        for (char c : t.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            sb.append('#');
            sb.append(count[i]);
        }
        return sb.toString();
    }

    static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
            71, 73, 79, 83, 89, 97, 101};

    public static int myHashCode(String s) {
//        System.out.println(primes.length);
        int hash = 1;
        for (char c : s.toCharArray()) {
            hash *= primes[c - 'a'];
        }
        return hash;
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


        // 数组 p 记录了扫描过的回文子串的信息
        int[] p = new int[sLen];

        // 双指针，它们是一一对应的，须同时更新
        int maxRight = 0;
        int center = 0;

        // 当前遍历的中心最大扩散步数，其值等于原始字符串的最长回文子串的长度
        int maxLen = 1;
        // 原始字符串的最长回文子串的起始位置，与 maxLen 必须同时更新
        int start = 0;

        for (int i = 0; i < sLen; i++) {

            if (i < maxRight) {
                int mirror = 2 * center - i;
                // 这一行代码是 Manacher 算法的关键所在，要结合图形来理解
                p[i] = Math.min(maxRight - i, p[mirror]);
            }

            // 下一次尝试扩散的左右起点，能扩散的步数直接加到 p[i] 中
            int left = i - (1 + p[i]);
            int right = i + (1 + p[i]);

            // left >= 0 && right < sLen 保证不越界
            // str.charAt(left) == str.charAt(right) 表示可以扩散 1 次
            while (left >= 0 && right < sLen && str.charAt(left) == str.charAt(right)) {
                p[i]++;
                left--;
                right++;

            }
            // 根据 maxRight 的定义，它是遍历过的 i 的 i + p[i] 的最大者
            // 如果 maxRight 的值越大，进入上面 i < maxRight 的判断的可能性就越大，这样就可以重复利用之前判断过的回文信息了
            if (i + p[i] > maxRight) {
                // maxRight 和 center 需要同时更新
                maxRight = i + p[i];
                center = i;
            }
            if (p[i] > maxLen) {
                // 记录最长回文子串的长度和相应它在原始字符串中的起点
                maxLen = p[i];
                start = (i - maxLen) / 2;
            }

            // origin approach
//            int curLen = centerSpread(str, i);
//            if (curLen > maxLen) {
//                maxLen = curLen;
//                start = (i - maxLen) / 2;
//            }
        }
        return s.substring(start, start + maxLen);
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

    public static char[] getStrArr(String s) {
        char[] arr = new char[26];
        for (char c : s.toCharArray()) {
            arr[c - 'A']++;
        }
        return arr;
    }
}
