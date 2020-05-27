package leetcode.lc139;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdehao on 18/12/7.
 */
public class WordBreak {
    public static void main(String[] args) {

        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak("leetcode", dict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
//        return wordBreakBF(s, 0, wordDict);
        return wordBreakDP(s, wordDict);
    }

    private static boolean wordBreakDP(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
//                    break;
                }
            }
        }

        return dp[s.length()];
    }

    private static boolean wordBreakBF(String s, int start, List<String> wordDict) {
        if (start == s.length()) {
            return true;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String left = s.substring(start, i);
            if (wordDict.contains(left) && wordBreakBF(s, i, wordDict)) {
                return true;
            }
//            System.out.println("left = " + left + ", right = " + right);
        }
        return false;
    }


}
