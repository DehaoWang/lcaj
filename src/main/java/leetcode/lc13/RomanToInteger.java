package leetcode.lc13;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdehao on 18/4/23.
 */
public class RomanToInteger {

    private static int[] stairs = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static Map<Character, Integer> romanStr2Num = new HashMap<>();
    static {
        romanStr2Num.put('I', 1);
        romanStr2Num.put('V', 5);
        romanStr2Num.put('X', 10);
        romanStr2Num.put('L', 50);
        romanStr2Num.put('C', 100);
        romanStr2Num.put('D', 500);
        romanStr2Num.put('M', 1000);
    }

    public static void main(String[] args){
        String[] testRoman = {"III", "IV", "IX", "LVIII", "MCMXCIV"};
        for(String testR: testRoman){
            System.out.println(String.format("testR=%-10s, int=%d", testR, romanToInt(testR)));
        }


    }

    // go from back
    public static int romanToInt(String s){
        if(s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int num = romanStr2Num.get(chars[len-1]);
        for(int i = len-2; i >= 0; i--){
            if(romanStr2Num.get(chars[i]) < romanStr2Num.get(chars[i+1])){
                num -= romanStr2Num.get(chars[i]);
            }
            else {
                num += romanStr2Num.get(chars[i]);
            }
        }

        return num;
    }
}
