class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        long goodPairs = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int diff = i - nums[i];

            // Count how many good pairs exist so far
            goodPairs += freq.getOrDefault(diff, 0);

            // Store the occurrence of the current difference
            freq.put(diff, freq.getOrDefault(diff, 0) + 1);
        }

        long totalPairs = (long) n * (n - 1) / 2;
        return totalPairs - goodPairs;
    }
}