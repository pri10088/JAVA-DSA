class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // Store the maximum subarray sum
        int currentSum = 0; // Store the current subarray sum
        
        for (int num : nums) {
            currentSum += num; // Add the current element to the subarray sum
            maxSum = Math.max(maxSum, currentSum); // Update maxSum if needed
            
            if (currentSum < 0) { 
                currentSum = 0; // Reset current sum if it's negative
            }
        }
        
        return maxSum; // Return the maximum subarray sum
    }
}
