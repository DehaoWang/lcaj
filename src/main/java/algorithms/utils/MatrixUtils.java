package algorithms.utils;

/**
 * Created by wangdehao on 18/11/4.
 */
public class MatrixUtils {
    public static void printMatrix(char[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrix(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(String.format("%-4s", matrix[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMatrix(double[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrix(boolean[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(String.format("%-6s", matrix[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }
}
