import java.util.*;

public class Solution { // Rename to "Solution"
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); // Step 1: Sort the array
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) { // First element
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate values

            for (int j = i + 1; j < n - 2; j++) { // Second element
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicate values

                int left = j + 1, right = n - 1; // Two pointers
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right]; // Use long to prevent overflow
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        // Skip duplicate values
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;

                    } else if (sum < target) {
                        left++; // Increase sum
                    } else {
                        right--; // Decrease sum
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        System.out.println(solution.fourSum(nums1, target1)); // Output: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]

        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        System.out.println(solution.fourSum(nums2, target2)); // Output: [[2, 2, 2, 2]]
    }
}
