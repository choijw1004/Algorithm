package Prog_프렌즈4블록;

class Solution {
    static char[][] cBoard;

    static public int erase(int m, int n) {
        boolean[][] marked = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char current = cBoard[i][j];
                if (current == '-') {
                    continue;
                }

                if (current == cBoard[i + 1][j] && current == cBoard[i][j + 1] && current == cBoard[i + 1][j + 1]) {

                    marked[i][j] = true;
                    marked[i + 1][j] = true;
                    marked[i][j + 1] = true;
                    marked[i + 1][j + 1] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (marked[i][j]) {
                    cBoard[i][j] = '-';
                    count++;
                }
            }
        }

        return count;
    }

    static public void drop(int m, int n) {
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (cBoard[i][j] == '-') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (cBoard[k][j] != '-') {
                            cBoard[i][j] = cBoard[k][j];
                            cBoard[k][j] = '-';
                            break;
                        }
                    }
                }
            }
        }
    }

    static public void makeCBoard(int m, int n, String[] board) {
        cBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            cBoard[i] = board[i].toCharArray();
        }
    }

    static public int solution(int m, int n, String[] board) {
        int totalErased = 0;

        makeCBoard(m, n, board);

        while (true) {
            int erased = erase(m, n);

            if (erased == 0) {
                break;
            }

            totalErased += erased;
            drop(m, n);
        }

        return totalErased;
    }
}
