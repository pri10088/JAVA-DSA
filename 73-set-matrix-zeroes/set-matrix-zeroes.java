class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // Step 1: Check if first row or first column has a zero
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 2: Use first row and column as markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark row
                    matrix[0][j] = 0; // Mark column
                }
            }
        }

        // Step 3: Set cells to zero based on markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: Set first row and first column to zero if needed
        if (firstRowZero) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
