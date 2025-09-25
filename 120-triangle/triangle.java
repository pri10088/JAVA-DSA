import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1]; // extra space for easy boundary handling

        // start from the bottom row
        for (int row = n - 1; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
            }
        }
        return dp[0]; // top element after processing
    }
}
