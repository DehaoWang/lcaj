package leetcode.lc10;

/**
 * Created by wangdehao on 18/4/21.
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {

        String[][] strs = {
                {"aab", "c*a*b"},
        };
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i][0];
            String p = strs[i][1];
            System.out.println(String.format("s=%-10s, p=%-10s, match=%b", s, p, isMatch(s, p)));
        }
    }

//    '.' Matches any single character.
//    '*' Matches zero or more of the preceding element.

//    public static boolean isMatch(String s, String p){
//        int i = 0, j = 0;
//        while (i < s.length() && j < p.length()){
//            char cs = s.charAt(i);
//            char cp = p.charAt(j);
//            if(cs != cp && cp != '*' && cp != '.'){
//                return false;
//            }
//        }
//
//        return true;
//    }

    // recursive solution
    public static boolean isMatch(String s, String p){

        if(p.isEmpty()){
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if(p.length() >= 2 && p.charAt(1) == '*'){
            // deal with head leading: move p
            boolean headRepeatType = isMatch(s, p.substring(2));
            // deal with first match : move s
            boolean firstMatchType = firstMatch && isMatch(s.substring(1), p);
            return headRepeatType || firstMatchType;
        }
        else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
