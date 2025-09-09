class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // If duplicate found in current window
            if (window.contains(nums[i])) {
                return true;
            }

            // Add current number to window
            window.add(nums[i]);

            // Maintain window size <= k
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}
