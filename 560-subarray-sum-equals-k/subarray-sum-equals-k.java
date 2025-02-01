class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1); // To handle the case when prefixSum itself is equal to k

        for (int num : nums) {
            prefixSum += num;

            // Check if there is a prefix sum that makes (prefixSum - k) exist in map
            if (sumMap.containsKey(prefixSum - k)) {
                count += sumMap.get(prefixSum - k);
            }

            // Store prefixSum frequency in the HashMap
            sumMap.put(prefixSum, sumMap.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
}