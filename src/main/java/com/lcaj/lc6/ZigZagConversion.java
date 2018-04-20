package com.lcaj.lc6;

/**
 * Created by wangdehao on 18/4/11.
 */
public class ZigZagConversion {

    private static boolean debug = false;


    /**
     * test cases
     */

//    P   A   H   N
//    A P L S I I G
//    Y   I   R


//    "PAYPALISHIRING"
//            3
    public static void main(String[] args){

//        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
//        System.out.println(convert("PAYPALISHIRING", 6));
//        System.out.println(convert("PAYPALISHIRING", 1));
//        System.out.println(convert("", 1));
////        System.out.println(convert("A", 3));
//
//        for(int i = 0; i < 20; i++){
//            System.out.println("i="+i+", width="+getWidthByLenAndHeight(i, 1));
//        }


        System.out.println(convert("PAYPALISHIRING", 3));
    }

    /**
     * algorithm
     */

    // submitted
    public static String convert(String s, int numRows) {
        int len = s.length();
//        int width1 = (len / (2*numRows)) * numRows + 1;
//        int width2 = 2*len / numRows + 1;
//        int width3 = (len / (2 * (numRows-1)) + 1) * (numRows-1);

        if(numRows == 1){
            return s;
        }

        int width = getWidthByLenAndHeight(len, numRows);

        String[][] matrix = new String[numRows][width];

        boolean backwards = false;
        int i = 0, j = 0;
        for(int k = 0; k < len; k++){
            if(debug){
                System.out.println(String.format("before: i=%d, j=%d, k=%d, backwards=%b",i, j, k, backwards));
            }

            matrix[i][j] = s.charAt(k)+"";
            if(debug){
                printMatrix(matrix);
            }
            if(!backwards && i < numRows-1){
                i++;
            }
            else if(backwards && i > 0){
                i--;
                j++;
            }
            if(i == 0 || i == numRows-1){
                backwards = !backwards;
            }
            if(debug){
                System.out.println(String.format("after : i=%d, j=%d, k=%d, backwards=%b",i, j, k, backwards));
            }
        }
        String result = printMatrix(matrix);

        return result;

    }

    private static int getWidthByLenAndHeight(int len, int numRows) {
        if(numRows == 1){
            return len;
        }
        return (len / (2 * (numRows-1)) + 1) * (numRows-1);
    }

    public static String printMatrix(String[][] matrix){
        String s = "";
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if( matrix[i][j] != null){
                    s += matrix[i][j];
                    System.out.print(matrix[i][j]+" ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        return s;
    }

    // good solutions: use value2Index to find complement
    public String convertGS(String s, int numRows) {
        return "";

    }

}
