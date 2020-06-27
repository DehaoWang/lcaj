package leetcode.lc54;

import algorithms.utils.ArrayUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdehao on 18/11/7.
 */
public class SpiralMatrix {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

//        System.out.println(spiralOrder(matrix));
        System.out.println(spiralOrderVisit(matrix1));
        System.out.println(spiralOrderLayer(matrix1));
        System.out.println(spiralOrderLayer2(matrix1));


    }

    public static final int[] R = {0, 1};
    public static final int[] D = {1, 0};
    public static final int[] L = {0, -1};
    public static final int[] U = {-1, 0};

    public static final int[][] DIRECTIONS = {
            R, D, L, U
    };

    public static int getNextDirection(int curDir) {
        return (curDir + 1) % DIRECTIONS.length;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int curDir = 0;
        int i = 0, j = 0;
        int h = matrix.length, w = matrix[0].length;
        int lb = 0, rb = w - 1;
        int ub = 0, db = h - 1;
        boolean[][] visited = new boolean[h][w];
        while (lb <= rb && ub <= db) {
            // move

//            if (i >= ub && i <= db && j >= lb && j <= rb) {
//                result.add(matrix[i][j]);
//                i += DIRECTIONS[curDir][0];
//                j += DIRECTIONS[curDir][1];
//            }
//            if (j == rb) {
//                rb--;
//                curDir = getNextDirection(curDir);
//            } else if (i == db) {
//                db--;
//                curDir = getNextDirection(curDir);
//            } else if (j == lb) {
//                lb++;
//                curDir = getNextDirection(curDir);
//            } else if (i == ub) {
//                ub++;
//                curDir = getNextDirection(curDir);
//            }
        }
        return result;
    }

    public static List<Integer> spiralOrderVisit(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int curDir = 0;
        int i = 0, j = 0;
        int h = matrix.length, w = matrix[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int k = 0; k < h * w; k++) {
            visited[i][j] = true;
            result.add(matrix[i][j]);
            int nextI = i + DIRECTIONS[curDir][0];
            int nextJ = j + DIRECTIONS[curDir][1];
            if (nextI >= 0 && nextI < h && nextJ >= 0 && nextJ < w && !visited[nextI][nextJ]) {
                i = nextI;
                j = nextJ;
            } else {
                curDir = getNextDirection(curDir);
                i += DIRECTIONS[curDir][0];
                j += DIRECTIONS[curDir][1];
            }
        }
        return result;
    }

    public static List<Integer> spiralOrderLayer(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        int h = matrix.length, w = matrix[0].length;
        int u = 0, d = h - 1;
        int l = 0, r = w - 1;

        while (l <= r && u <= d) {
            // go right
            for (int j = l; j <= r; j++) {
                result.add(matrix[u][j]);
            }
            // go down
            for (int i = u + 1; i <= d; i++) {
                result.add(matrix[i][r]);
            }
            if (l < r && u < d) { // important: final dir not in <left or up>
                // go left
                for (int j = r - 1; j >= l; j--) {
                    result.add(matrix[d][j]);
                }
                // go up
                for (int i = d - 1; i > u; i--) {
                    result.add(matrix[i][l]);
                }
            }
            l++;
            r--;
            u++;
            d--;
        }

        return result;
    }

    public static List<Integer> spiralOrderLayer2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        int h = matrix.length, w = matrix[0].length;
        int u = 0, d = h - 1;
        int l = 0, r = w - 1;
        int size = h * w;

        while (result.size() < size) {
            // go right
            for (int j = l; j <= r && result.size() < size; j++) {
                result.add(matrix[u][j]);
            }

            // go down
            for (int i = u + 1; i <= d && result.size() < size; i++) {
                result.add(matrix[i][r]);
            }
            // go left
            for (int j = r - 1; j >= l && result.size() < size; j--) {
                result.add(matrix[d][j]);
            }
            // go up
            for (int i = d - 1; i > u && result.size() < size; i--) {
                result.add(matrix[i][l]);
            }
            l++;
            r--;
            u++;
            d--;
        }

        return result;
    }
}
