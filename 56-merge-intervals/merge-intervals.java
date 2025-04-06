class Solution {
    public int[][] merge(int[][] intervals) {
                if (intervals.length == 0) return new int[0][];
        
        // Step 1: Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> result = new ArrayList<>();
        
        // Step 2: Go through intervals
        for (int[] interval : intervals) {
            // If result is empty or no overlap
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                // Merge intervals
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }
        
        // Step 3: Convert result list to array
        return result.toArray(new int[result.size()][]);

        
    }
}