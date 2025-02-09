class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long totalPairs = (long) nums.length * (nums.length - 1) / 2;
        long goodPairs = 0;

        for (int i = 0; i < nums.length; i++) {
            int diff = i - nums[i];
            if (map.containsKey(diff)) {
                goodPairs += map.get(diff);
            }
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }

        return totalPairs - goodPairs;
        
    }
}