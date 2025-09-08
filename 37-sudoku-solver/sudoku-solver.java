class Solution {
    public void solveSudoku(char[][] board) {
        // bit masks for rows, cols and 3x3 boxes
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        // list of empty cell positions
        java.util.List<int[]> empties = new java.util.ArrayList<>();

        // initialize masks and collect empty cells
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.' || board[r][c] == '0') {
                    empties.add(new int[]{r, c});
                } else {
                    int d = board[r][c] - '1'; // 0..8
                    int bit = 1 << d;
                    rows[r] |= bit;
                    cols[c] |= bit;
                    boxes[(r / 3) * 3 + (c / 3)] |= bit;
                }
            }
        }

        // backtracking DFS
        dfs(board, 0, empties, rows, cols, boxes);
    }

    private boolean dfs(char[][] board, int idx,
                        java.util.List<int[]> empties,
                        int[] rows, int[] cols, int[] boxes) {
        if (idx == empties.size()) return true; // solved

        // Choose the cell
        int r = empties.get(idx)[0];
        int c = empties.get(idx)[1];
        int b = (r / 3) * 3 + (c / 3);

        // mask of digits already used in row/col/box
        int used = rows[r] | cols[c] | boxes[b];

        // try digits 1..9
        for (int d = 0; d < 9; d++) {
            int bit = 1 << d;
            if ((used & bit) == 0) {
                // place digit
                board[r][c] = (char) ('1' + d);
                rows[r] |= bit;
                cols[c] |= bit;
                boxes[b] |= bit;

                // recurse
                if (dfs(board, idx + 1, empties, rows, cols, boxes)) return true;

                // backtrack
                board[r][c] = '.';
                rows[r] &= ~bit;
                cols[c] &= ~bit;
                boxes[b] &= ~bit;
            }
        }

        // no valid digit -> backtrack
        return false;
    }
}
