package algorithms.twopointers;

public class LongestPalindromicSub {
    public static void main(String[] args) {
        System.out.println(longestPalindromicSub("babad"));
        System.out.println(longestPalindromicSub("cbbd"));

//        System.out.println(longestPalindromicSub2("babad"));
        System.out.println(longestPalindromicSub2("cbbd"));
    }

    public static String longestPalindromicSub(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public static String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }

    static int lo = 0;
    static int hi = 0;
    static int maxLen = 0;

    public static String longestPalindromicSub2(String s) {
        for (int i = 0; i < s.length(); i++) {
            palindrome2(s, i, i);
            palindrome2(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    public static void palindrome2(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // l+1, r-1
        if (r - l - 1 > maxLen) {
            lo = l + 1;
            maxLen = r - l - 1;
        }
    }
}
