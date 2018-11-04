package com.lcaj.lc37;

import java.util.ArrayList;
import java.util.List;

import static com.lcaj.lc36.ValidSudoku.isValidSudoku;
import static com.lcaj.util.MatrixMethods.printMatrix;

/**
 * Created by wangdehao on 18/10/28.
 */
public class SudokuSolver {

    // NOTES:
    // char to int, turn out to be ASCII!

    public static void main(String[] args) {

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
        printMatrix(board2);
        solveSudoku(board2);
        printMatrix(board2);
    }

    public static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        backtrackForSudoku(board);
    }

    private static boolean backtrackForSudoku(char[][] board) {

        for (int k = 0; k < 9 * 9; k++) {
            int i = k / 9;
            int j = k % 9;
            if (board[i][j] == '.') {
                for (char l = '1'; l <= '9'; l++) {
                    if (isValidSudokuLocal(board, i, j, l)) {
                        // use this value
                        board[i][j] = l;
                        if (backtrackForSudoku(board)) {
                            return true;
                        } else {
                            // back track
                            board[i][j] = '.';
                        }
                    }
                }
                return false;
            }
        }

        return true;
    }

    private static boolean isValidSudokuLocal(char[][] board, int row, int col, int c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false; //check row
            if (board[row][i] != '.' && board[row][i] == c) return false; //check column
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}
