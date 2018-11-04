package com.lcaj.lc36;

/**
 * Created by wangdehao on 18/10/28.
 */
public class ValidSudoku {

    // NOTES:
    // char to int, turn out to be ASCII!

    public static void main(String[] args) {
        char ct = '5';
        int it = (int) ct;
        System.out.println(it);
        char[][] board = {
                {6, 1, 2, 3, 4, 5, 7, 9, 8},
                {3, 4, 5, 7, 9, 8, 6, 1, 2},
                {7, 9, 8, 6, 1, 2, 3, 4, 5},
                {2, 6, 1, 5, 3, 4, 8, 7, 9},
                {8, 7, 9, 2, 6, 1, 5, 3, 4},
                {5, 3, 4, 8, 7, 9, 2, 6, 1},
                {1, 2, 6, 4, 5, 3, 9, 8, 7},
                {9, 8, 7, 1, 2, 6, 4, 5, 3},
                {4, 5, 3, 9, 8, 7, 1, 2, 6}
        };
        char[][] board2 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku(board2));

    }

    public static boolean isValidSudoku(char[][] board) {
        // use an array of occupancy, clear it after checking rows, cols and boxes

        boolean[] occupied = new boolean[9];
        if (!validRows(board, occupied)) {
            System.out.println(1);
            return false;
        }
        clearArrayOfOccupancy(occupied);

        if (!validCols(board, occupied)) {
            System.out.println(2);
            return false;
        }
        clearArrayOfOccupancy(occupied);

        if (!validBoxes(board, occupied)) {
            System.out.println(3);
            return false;
        }
        return true;
    }

    private static boolean validBoxes(char[][] board, boolean[] occupied) {
        // check boxes
        for (int k = 0; k < 9; k++) {
            int rs = 3 * (k / 3);
            int cs = 3 * (k % 3);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char c = board[rs + i][cs + j];
                    if (c == '.') {
                        continue;
                    }
                    int n = c - '0';
                    if (n > 9 || n < 1) {
                        return false;
                    }
                    if (occupied[n - 1]) {
                        return false;
                    } else {
                        occupied[n - 1] = true;
                    }
                }
            }
            clearArrayOfOccupancy(occupied);
        }
        return true;
    }

    private static boolean validCols(char[][] board, boolean[] occupied) {
        // check col
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int n = c - '0';
                if (n > 9 || n < 1) {
                    return false;
                }
                if (occupied[n - 1]) {
                    return false;
                } else {
                    occupied[n - 1] = true;
                }
            }
            clearArrayOfOccupancy(occupied);
        }
        return true;
    }

    private static boolean validRows(char[][] board, boolean[] occupied) {
        // check row
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int n = c - '0';
                if (n > 9 || n < 1) {
                    return false;
                }
                if (occupied[n - 1]) {
                    System.out.println(1.2);
                    return false;
                } else {
                    occupied[n - 1] = true;
                }
            }
            clearArrayOfOccupancy(occupied);
        }
        return true;
    }

    public static void clearArrayOfOccupancy(boolean[] occupied) {
        for (int i = 0; i < occupied.length; i++) {
            occupied[i] = false;
        }
    }
}
