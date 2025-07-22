class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> merged = new ArrayList<>();

        for(int[] interval : intervals){
            if(merged.isEmpty()|| merged.get(merged.size() -1)[1] < interval[0] ){
                merged.add(interval);
            }else{
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);

            }
        }

        return merged.toArray(new int[merged.size()][]);

    }
}

-------------------------------------------------------------------------------------------------
    import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        // Step 2: Merge
        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.get(merged.size() - 1);
            int[] curr = intervals[i];

            if (curr[0] <= last[1]) {
                // Overlapping
                last[1] = Math.max(last[1], curr[1]);
            } else {
                // No overlap
                merged.add(curr);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
