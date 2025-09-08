import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // sets to track columns and diagonals
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>(); // row - col
        Set<Integer> diag2 = new HashSet<>(); // row + col

        backtrack(0, n, board, cols, diag1, diag2, solutions);
        return solutions;
    }

    private void backtrack(int row, int n, char[][] board,
                           Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2,
                           List<List<String>> solutions) {
        if (row == n) {
            // Found a solution, convert board to list of strings
            List<String> config = new ArrayList<>();
            for (char[] r : board) {
                config.add(new String(r));
            }
            solutions.add(config);
            return;
        }

        for (int col = 0; col < n; col++) {
            // check if placing queen here is safe
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }

            // place queen
            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            // recurse to next row
            backtrack(row + 1, n, board, cols, diag1, diag2, solutions);

            // backtrack (remove queen)
            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
}
