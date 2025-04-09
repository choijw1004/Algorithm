package BOJ_9663_NQueen;
import java.util.*;

public class Main {
    static int ans;
    static int n;

    private static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j]) return false;
        }

        return true;
    }

    private static void backTracking(int row, boolean[][] board) {
        if (row == n) {
            ans++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                backTracking(row + 1, board);
                board[row][col] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = 0;
        boolean[][] board = new boolean[n][n];

        backTracking(0, board);
        System.out.println(ans);
    }
}
