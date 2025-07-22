class Solution {
    public int[][] merge(int[][] intervals ) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for(int i=1; i<intervals.length; i++){
            int[] last = merged.get(merged.size()-1);
            int[] curr = intervals[i];
            if(last[1] >= curr[0]){
                last[1] = Math.max(curr[1], last[1]);
            }else{
                merged.add(curr);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}