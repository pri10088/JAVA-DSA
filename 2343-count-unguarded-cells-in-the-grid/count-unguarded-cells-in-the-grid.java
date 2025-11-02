class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int EMPTY = 0, GUARD = 1, WALL = 2, GUARDED = 3;
        int[][] grid = new int[m][n];
        for (int[] g : guards) grid[g[0]][g[1]] = GUARD;
        for (int[] w : walls)  grid[w[0]][w[1]] = WALL;

        // Row sweeps
        for (int i = 0; i < m; i++) {
            boolean seenGuard = false;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == GUARD) {
                    seenGuard = true;
                } else if (grid[i][j] == WALL) {
                    seenGuard = false;
                } else if (seenGuard) {
                    grid[i][j] = GUARDED;
                }
            }
            seenGuard = false;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == GUARD) {
                    seenGuard = true;
                } else if (grid[i][j] == WALL) {
                    seenGuard = false;
                } else if (seenGuard) {
                    grid[i][j] = GUARDED;
                }
            }
        }

        // Column sweeps
        for (int j = 0; j < n; j++) {
            boolean seenGuard = false;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == GUARD) {
                    seenGuard = true;
                } else if (grid[i][j] == WALL) {
                    seenGuard = false;
                } else if (seenGuard) {
                    grid[i][j] = GUARDED;
                }
            }
            seenGuard = false;
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == GUARD) {
                    seenGuard = true;
                } else if (grid[i][j] == WALL) {
                    seenGuard = false;
                } else if (seenGuard) {
                    grid[i][j] = GUARDED;
                }
            }
        }

        // Count unguarded & empty
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == EMPTY) {
                    count++;
                }
            }
        }
        return count;
    }
}
