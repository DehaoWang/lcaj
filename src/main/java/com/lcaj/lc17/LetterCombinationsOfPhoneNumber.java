package com.lcaj.lc17;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wangdehao on 18/4/27.
 */
public class LetterCombinationsOfPhoneNumber {
    public static Map<String, List<String>> num2Strings = new HashMap<>();
    static {
        num2Strings.put("2", Arrays.asList("a", "b", "c"));
        num2Strings.put("3", Arrays.asList("d", "e", "f"));
        num2Strings.put("4", Arrays.asList("g", "h", "i"));
        num2Strings.put("5", Arrays.asList("j", "k", "l"));
        num2Strings.put("6", Arrays.asList("m", "n", "o"));
        num2Strings.put("7", Arrays.asList("p", "q", "r", "s"));
        num2Strings.put("8", Arrays.asList("t", "u", "v"));
        num2Strings.put("9", Arrays.asList("w", "x", "y", "z"));
    }
    public static void main(String[] args){
        String[] testS = {
//                "23",
                "2356",
//                "3174"
        };
        for(int i = 0; i < testS.length; i++){
            String digits = testS[i];
            System.out.println(String.format("origin=%-10s, combination=%s", digits, letterCombinationsRecursive(digits)));
        }

    }

    // put into 2d-array, then traverse
    public static List<String> letterCombinations2D(String digits) {

        String[][] matrix = getMatrixFromDigits(digits);

        printMatrix(matrix);

        List<String> lc = getCombinationsFromMatrix(matrix);

        return lc;
    }

    public static String[][] getMatrixFromDigits(String digits){
        int len = digits.length();
        String[][] matrix = new String[4][len];
        for(int col = 0; col < digits.length(); col++){
            String num = digits.charAt(col)+"";
            List<String> strings = num2Strings.get(num);
            if(strings == null){
                continue;
            }
            for(int row = 0; row < strings.size(); row++){
                matrix[row][col] = strings.get(row);
            }
        }
        return matrix;
    }

    public static List<String> getCombinationsFromMatrix(String[][] matrix) {
        List<String> lc = new ArrayList<>();
//        for()
        return null;
    }

    public static void printMatrix(String[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static List<String> letterCombinationsRecursive(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        if(digits.length() == 1){
            String c = digits.charAt(0)+"";
            return num2Strings.get(c);
        }
        List<String> fullStrs = new ArrayList<>();
        String head = digits.charAt(0)+"";
        List<String> headStrs = num2Strings.get(head);
        List<String> restStrs = letterCombinationsRecursive(digits.substring(1));
        System.out.println("head="+headStrs);
        System.out.println("rest="+restStrs);
        if(restStrs == null){
            return headStrs;
        }

        for(String h: headStrs){
            for(String r: restStrs){
                fullStrs.add(h+r);
            }
        }
        return fullStrs;
    }
}
