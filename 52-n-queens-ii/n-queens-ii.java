class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        backtrack(n, 0, 0, 0, 0);
        return count;
    }

    private void backtrack(int n, int row, int cols, int diag1, int diag2) {
        if (row == n) {
            count++;
            return;
        }

        // all available positions in this row
        int available = ((1 << n) - 1) & ~(cols | diag1 | diag2);

        while (available != 0) {
            // pick rightmost available position
            int pos = available & -available;
            available -= pos;

            backtrack(
                n,
                row + 1,
                cols | pos,
                (diag1 | pos) << 1,
                (diag2 | pos) >> 1
            );
        }
    }
}
