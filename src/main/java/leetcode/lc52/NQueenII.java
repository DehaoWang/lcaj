package leetcode.lc52;

public class NQueenII {
    public static void main(String[] args) {
        System.out.println(totalNQueens(8));
    }

    public static int totalNQueens(int n) {
        initBoard(n);
        backtrack(0);
        return count;
    }

    private static void initBoard(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = B;
            }
        }
    }

    private static int count = 0;
    private static char[][] board;
    private static final char Q = 'Q';
    private static final char B = '.';

    private static void backtrack(int r) {
        int height = board.length;
        int width = board[0].length;
        if (r == height) {
            // res.add(getBoardString(board));
            count++;
            return;
        }
        for (int c = 0; c < width; c++) {
            if (!validPos(r, c)) {
                continue;
            }
            board[r][c] = Q;
            backtrack(r + 1);
            board[r][c] = B;
        }
    }

    public static boolean validPos(int r, int c) {
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
}
