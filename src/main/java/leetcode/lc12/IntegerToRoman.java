package leetcode.lc12;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdehao on 18/4/23.
 */
public class IntegerToRoman {

    // use array for indexing
    private static Map<Integer, String> num2RomanStr = new HashMap<>();
    static {
        num2RomanStr.put(1, "I");
        num2RomanStr.put(5, "V");
        num2RomanStr.put(10, "X");
        num2RomanStr.put(50, "L");
        num2RomanStr.put(100, "C");
        num2RomanStr.put(500, "D");
        num2RomanStr.put(1000, "M");

        num2RomanStr.put(4, "IV");
        num2RomanStr.put(9, "IX");
        num2RomanStr.put(40, "XL");
        num2RomanStr.put(90, "XC");
        num2RomanStr.put(400, "CD");
        num2RomanStr.put(900, "CM");
    }

    private static int[] stairs = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args){
        int[] testInt = {0, 3, 4, 9, 58, 100, 1994};
        for(int testI: testInt){
            System.out.println(String.format("int=%-3d, roman=%s", testI, intToRoman(testI)));
        }

        for(int i = 0; i < 199; i++){
            System.out.println(String.format("int=%-3d, roman=%s", i, intToRoman(i)));
        }


    }

    public static String intToRoman(int num){
        String roman = "";
        int index = 0;
        while(num > 0){
            int level = stairs[index];
            int r = num % level;
            int q = num / level;
            for(int i = q; i > 0; i--){
                roman += romans[index];
            }
            num = r;

            index++;
//            System.out.println(String.format("r=%d, q=%d, num=%d, roman=%s", r, q, num, roman));
        }

        return roman;
    }
}
