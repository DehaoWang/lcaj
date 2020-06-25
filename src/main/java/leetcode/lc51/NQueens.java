package leetcode.lc51;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {

        System.out.println(solveNQueens(8).size());
    }

    public static List<List<String>> solveNQueens(int n) {
        initBoard(n);
        List<List<String>> result = new ArrayList<>();

        backtrack(result, 0);
        return result;
    }

    private static void initBoard(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = B;
            }
        }
    }

    private static char[][] board;
    private static final char Q = 'Q';
    private static final char B = '.';

    private static void backtrack(List<List<String>> res, int r) {
        int height = board.length;
        int width = board[0].length;
        if (r == height) {
            res.add(getBoardString(board));
            return;
        }
        for (int c = 0; c < width; c++) {
            if (!validPos(board, r, c)) {
                continue;
            }
            board[r][c] = Q;
            backtrack(res, r + 1);
            board[r][c] = B;
        }
    }

    public static boolean validPos(char[][] board, int r, int c) {
        int width = board[0].length;
        // column
        for (int k = 0; r - k >= 0; k++) {
            if (board[r - k][c] == Q) {
                return false;
            }
        }
        // top left
        for (int k = 0; r - k >= 0 && c - k >= 0; k++) {
            if (board[r - k][c - k] == Q) {
                return false;
            }
        }
        // top right
        for (int k = 0; r - k >= 0 && c + k < width; k++) {
            if (board[r - k][c + k] == Q) {
                return false;
            }
        }
        return true;
    }

    public static List<String> getBoardString(char[][] board) {
        List<String> res = new ArrayList<>();
        int height = board.length;
        int width = board[0].length;
        for (int i = 0; i < height; i++) {
            String s = "";
            for (int j = 0; j < width; j++) {
                s += board[i][j];
            }
            res.add(s);
        }
        return res;
    }
}