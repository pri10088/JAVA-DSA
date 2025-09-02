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
}
