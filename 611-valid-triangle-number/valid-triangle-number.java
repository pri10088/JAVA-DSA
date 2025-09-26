import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);   // Sort the array
        int n = nums.length;
        int count = 0;

        // Fix the largest side nums[k]
        for (int k = n - 1; k >= 2; k--) {
            int left = 0, right = k - 1;

            // Two-pointer check for pairs (left, right)
            while (left < right) {
                if (nums[left] + nums[right] > nums[k]) {
                    // If nums[left] + nums[right] > nums[k],
                    // then all elements from left..(right-1) with nums[right] are valid
                    count += (right - left);
                    right--; // move to smaller right
                } else {
                    left++;  // need bigger sum, move left forward
                }
            }
        }
        return count;
    }
}
