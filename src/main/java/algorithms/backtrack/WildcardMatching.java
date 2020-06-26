package algorithms.backtrack;

public class WildcardMatching {
    // backtrack approach, another approach is dp
    public static boolean isMatchBackTrack(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int pLen = p.length(), sLen = s.length();
        int pStar = -1, sStar = -1;
        int pIdx = 0, sIdx = 0;

        while (sIdx < sLen) {
            if (pIdx < pLen && (p.charAt(pIdx) == s.charAt(sIdx) || p.charAt(pIdx) == '?')) {
                pIdx++;
                sIdx++;
            } else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                pStar = pIdx;
                sStar = sIdx;
                pIdx++;
            } else if (sStar >= 0) { // backtrack: pIdx and sIdx both go back to previous matching
                pIdx = pStar + 1;
                sIdx = sStar + 1;
                sStar = sIdx;
            } else {
                return false;
            }
        }
        while (pIdx < pLen && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        return pIdx == pLen;
    }
}
