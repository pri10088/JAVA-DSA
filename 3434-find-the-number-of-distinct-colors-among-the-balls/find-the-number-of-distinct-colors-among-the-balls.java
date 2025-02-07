import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballColors = new HashMap<>(); // Ball to color mapping
        Map<Integer, Integer> colorCount = new HashMap<>(); // Color frequency count
        Set<Integer> distinctColors = new HashSet<>(); // Unique colors tracker
        int n = queries.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0], color = queries[i][1];

            // Remove the previous color if ball already has one
            if (ballColors.containsKey(ball)) {
                int prevColor = ballColors.get(ball);
                colorCount.put(prevColor, colorCount.get(prevColor) - 1);
                
                // If no balls left with this color, remove it from distinct colors
                if (colorCount.get(prevColor) == 0) {
                    distinctColors.remove(prevColor);
                }
            }

            // Assign the new color to the ball
            ballColors.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            distinctColors.add(color);

            // Store the number of distinct colors
            result[i] = distinctColors.size();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int limit1 = 4;
        int[][] queries1 = {{1, 4}, {2, 5}, {1, 3}, {3, 4}};
        System.out.println(Arrays.toString(solution.queryResults(limit1, queries1))); 
        // Output: [1, 2, 2, 3]

        int limit2 = 4;
        int[][] queries2 = {{0, 1}, {1, 2}, {2, 2}, {3, 4}, {4, 5}};
        System.out.println(Arrays.toString(solution.queryResults(limit2, queries2))); 
        // Output: [1, 2, 2, 3, 4]
    }
}
