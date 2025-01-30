class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; // Pointer for placing non-zero elements

        // First pass: Move non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap nums[i] with nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
