class Solution {
    public int jump(int[] nums) {
        int jumps = 0;         // Count of jumps made
        int curEnd = 0;        // Farthest point reachable in current jump
        int curFarthest = 0;   // Farthest point reachable overall so far

        // We stop at nums.length - 2 because we don't need to jump from the last index
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]); // Track max reach

            // When we've come to the end of the range of our current jump
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest; // Extend range for the next jump
            }
        }

        return jumps;
    }
}
