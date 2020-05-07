package algorithms.backtrack;

import java.util.LinkedList;
import java.util.List;

public class NQueens {
    private int[][] board;

    public NQueens(int[][] board) {
        this.board = board;
    }

    public NQueens() {

    }

    public static void main(String[] args) {
//        int[][] sampleBoard = {
//                {0, 1, 0},
//                {0, 0, 1},
//                {1, 0, 0}
//        };
//        NQueens nQueens1 = new NQueens(sampleBoard);
//        System.out.println(nQueens1.isValid());

        int n = 5;
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.generateNNQueens(n));
    }

    public int generateNNQueens(int n) {
        board = new int[n][n];
        List<String> res = new LinkedList<>();
        backtrack(res, board, 0);
        for (String boardString : res) {
            System.out.println(boardString);
        }
        return res.size();
    }

    private void backtrack(List<String> res, int[][] board, int r) {
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
            board[r][c] = 1;
            backtrack(res, board, r + 1);
            board[r][c] = 0;
        }
    }

//    public boolean isValid() {
//        return isValidHor() && isValidVer() && isValidDiaTL2BR() && isValidDiaTR2BL();
//    }
//
//    public boolean isValidHor() {
//        // horizontally check
//        int height = board.length;
//        int width = board[0].length;
//        for (int i = 0; i < height; i++) {
//            int count = 0;
//            for (int j = 0; j < width; j++) {
//                if (board[i][j] == 1) {
//                    count++;
//                }
//            }
//            if (count > 1) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean isValidVer() {
//        // vertically check
//        int height = board.length;
//        int width = board[0].length;
//        for (int j = 0; j < height; j++) {
//            int count = 0;
//            for (int i = 0; i < width; i++) {
//                if (board[i][j] == 1) {
//                    count++;
//                }
//            }
//            if (count > 1) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean isValidDiaTL2BR() {
//        // Diagonally check: TopLeft - BottomRight
//        int height = board.length;
//        int width = board[0].length;
//        for (int i = 0; i < height; i++) {
//            // i, 0
//            int count = 0;
//            for (int k = 0; i + k < height && k < width; k++) {
//                if (board[i + k][k] == 1) {
//                    count++;
//                }
//            }
//            if (count > 1) {
//                return false;
//            }
//        }
//
//        for (int j = 0; j < width; j++) {
//            // 0, j
//            int count = 0;
//            for (int k = 0; k < height && j + k < width; k++) {
//                if (board[k][j + k] == 1) {
//                    count++;
//                }
//            }
//            if (count > 1) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean isValidDiaTR2BL() {
//        // Diagonally check: TopRight - BottomLeft
//        int height = board.length;
//        int width = board[0].length;
//        for (int i = 0; i < height; i++) {
//            // i, 0
//            int count = 0;
//            for (int k = 0; i - k >= 0 && k < width; k++) {
//                if (board[i - k][k] == 1) {
//                    count++;
//                }
//            }
//            if (count > 1) {
//                return false;
//            }
//        }
//
//        for (int j = 0; j < width; j++) {
//            // size-1, j
//            int count = 0;
//            for (int k = 0; height - 1 - k >= 0 && j + k < width; k++) {
//                if (board[height - 1 - k][j + k] == 1) {
//                    count++;
//                }
//            }
//            if (count > 1) {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean validPos(int[][] board, int r, int c) {
        int width = board[0].length;
        // column
        for (int k = 0; r - k >= 0; k++) {
            if (board[r - k][c] == 1) {
                return false;
            }
        }
        // top left
        for (int k = 0; r - k >= 0 && c - k >= 0; k++) {
            if (board[r - k][c - k] == 1) {
                return false;
            }
        }
        // top right
        for (int k = 0; r - k >= 0 && c + k < width; k++) {
            if (board[r - k][c + k] == 1) {
                return false;
            }
        }
        return true;
    }

    public String getBoardString(int[][] board) {
        int height = board.length;
        int width = board[0].length;
        String s = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                s += board[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }
}
