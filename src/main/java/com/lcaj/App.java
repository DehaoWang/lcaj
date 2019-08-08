package com.lcaj;

import com.lcaj.util.ArrayMethods;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
//        com.lcaj.lc1.TwoSum.main(new String[0]);
//        com.lcaj.lc2.AddTwoNumbers.main(new String[0]);
//        com.lcaj.lc3.LongestSubstringWRC.main(new String[0]);
//        com.lcaj.lc4.MedianOfTwoSortedArrays.main(new String[0]);
//        com.lcaj.lc5.LongestPalindromicSubstring.main(new String[0]);
//        com.lcaj.lc6.ZigZagConversion.main(new String[0]);
//        com.lcaj.lc7.ReverseInteger.main(new String[0]);
//        com.lcaj.lc8.StringToInteger.main(new String[0]);
//        com.lcaj.lc9.PalindromeNumer.main(new String[0]);
//        com.lcaj.lc10.RegularExpressionMatching.main(new String[0]);
//        com.lcaj.lc11.ContainerWithMostWater.main(new String[0]);
//        com.lcaj.lc12.IntegerToRoman.main(new String[0]);
//        com.lcaj.lc13.RomanToInteger.main(new String[0]);
//        com.lcaj.lc14.LongestCommonPrefix.main(new String[0]);
//        com.lcaj.lc15.ThreeSum.main(new String[0]);
//        com.lcaj.lc16.ThreeSumClosest.main(new String[0]);
//        com.lcaj.lc17.LetterCombinationsOfPhoneNumber.main(new String[0]);
//        com.lcaj.lc18.FourSum.main(new String[0]);
//        com.lcaj.lc19.RemoveNthNodeFromEndOfList.main(new String[0]);
//        com.lcaj.lc20.ValidParentheses.main(new String[0]);


        Map<String, Integer> featureMap = new HashMap<>();
        featureMap.put("f0", 5);
        featureMap.put("f1", 1);
        featureMap.put("f2", 2);
        double[] denseArray = new double[featureMap.size()];
        int index = 0;
        for (Map.Entry<String, Integer> entry : featureMap.entrySet()) {
            denseArray[index++] = entry.getValue();
//            index++;
        }
        ArrayMethods.printArray(denseArray);


//        FileWriter fileWriter = new FileWriter("/Users/wangdehao/Documents/QCS/IntelligentStrategy/output.txt");
//        for (String key : featureMap.keySet()) {
//            fileWriter.append(key + " = " + featureMap.get(key) + "\n");
//        }
//        fileWriter.close();

        double t = 0.23;
        float f = (float) t;
        System.out.println(f);

        double originPred = 1.2;
        System.out.println(originPred < 0 ? 0 : (originPred > 1 ? 1 : originPred));
    }

}
