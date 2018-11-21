package com.lcaj.lc79;

/**
 * Created by wangdehao on 18/11/21.
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));

        char[][] board2 = {
                {'a'}
        };
        System.out.println(exist(board2, "a"));

    }


    public static boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        char[] letters = word.toCharArray();
        if (letters.length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[m][n];
        for (int k = 0; k < m * n; k++) {
            // find start
            int i = k / n;
            int j = k % n;
//          backtracking find next
//            if (existWithStart(board, letters, 0, i, j, visited)) {
            if (existWithStartSimple(board, letters, 0, i, j, visited)) {
                return true;
            }
        }
        return false;
    }


    // without dealing with visit problem: deprecated
    private static boolean existWithStart(char[][] board, char[] letters, int idx, int i, int j, boolean[][] visited) {
//        System.out.println("i = " + i + ", j = " + j + ", idx = " + idx);
        if (idx == letters.length) {
            return true;
        }
        // go left
        else {
            if (j > 0 && board[i][j - 1] == letters[idx]) {
                if (existWithStart(board, letters, idx + 1, i, j - 1, visited)) {
                    return true;
                }
            }
            // go right
            if (j < board[0].length - 1 && board[i][j + 1] == letters[idx]) {
                if (existWithStart(board, letters, idx + 1, i, j + 1, visited)) {
                    return true;
                }
            }
            // go up
            if (i > 0 && board[i - 1][j] == letters[idx]) {
                if (existWithStart(board, letters, idx + 1, i - 1, j, visited)) {
                    return true;
                }
            }
            // go down
            if (i < board.length - 1 && board[i + 1][j] == letters[idx]) {
                if (existWithStart(board, letters, idx + 1, i + 1, j, visited)) {
                    return true;
                }
            }
            return false;
        }

    }


    // from lc discuss
    // TODO: 18/11/21 BACKTRACKING IMPLEMENTATION?
    private static boolean existWithStartSimple(char[][] board, char[] letters, int idx, int i, int j, boolean[][] visited) {
        if (idx == letters.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (board[i][j] != letters[idx]) {
            return false;
        }
        visited[i][j] = true;
        // go left
        boolean result = existWithStartSimple(board, letters, idx + 1, i - 1, j, visited)
                || existWithStartSimple(board, letters, idx + 1, i + 1, j, visited)
                || existWithStartSimple(board, letters, idx + 1, i, j - 1, visited)
                || existWithStartSimple(board, letters, idx + 1, i, j + 1, visited);
        if (result) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
