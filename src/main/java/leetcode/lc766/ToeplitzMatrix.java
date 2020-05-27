package leetcode.lc766;

import java.util.HashMap;
import java.util.Map;

public class ToeplitzMatrix {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 3},
        };
        System.out.println(isToeplitzMatrix(matrix));
        System.out.println(isToeplitzMatrixForFollowUps(matrix));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
//        [1,2,3,4],
//        [5,1,2,3],
//        [9,5,1,2]

        int h = matrix.length;
        int w = matrix[0].length;
        for (int i = 0; i < h - 1; i++) {
            int first = matrix[i][0];
            for (int k = i + 1; k < h && k - i < w; k++) {
                int next = matrix[k][k - i];
                if (next != first) {
                    return false;
                }
            }
        }
        for (int j = 0; j < w - 1; j++) {
            int first = matrix[0][j];
            for (int k = j + 1; k < w && k - j < h; k++) {
                int next = matrix[k - j][k];
                if (next != first) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isToeplitzMatrixForFollowUps(int[][] matrix) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (map.containsKey(i - j)) {
                    if (matrix[i][j] != map.get(i - j)) {
                        return false;
                    }
                } else {
                    map.put(i - j, matrix[i][j]);
                }
            }
        }
        return true;
    }
}
