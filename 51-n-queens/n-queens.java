import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');

        backtrack(0, n, 0, 0, 0, board, res);
        return res;
    }

    private void backtrack(int row, int n, int cols, int diag1, int diag2,
                           char[][] board, List<List<String>> res) {
        if (row == n) {
            List<String> sol = new ArrayList<>();
            for (char[] r : board) sol.add(new String(r));
            res.add(sol);
            return;
        }

        // bitmask of available positions for this row
        int available = ((1 << n) - 1) & ~(cols | diag1 | diag2);

        while (available != 0) {
            // pick the rightmost available position
            int pos = available & -available;
            int col = Integer.numberOfTrailingZeros(pos);

            // place queen
            board[row][col] = 'Q';

            // move to next row with updated masks
            backtrack(row + 1, n,
                      cols | pos,
                      (diag1 | pos) << 1,
                      (diag2 | pos) >> 1,
                      board, res);

            // backtrack
            board[row][col] = '.';

            // remove the rightmost bit and continue
            available &= (available - 1);
        }
    }
}
