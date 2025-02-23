import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : nums) {
            uniqueNumbers.add(number);
        }

        int longestSequenceLength = 0;

        for (int number : uniqueNumbers) {
            // Only start counting when it's the start of a sequence
            if (!uniqueNumbers.contains(number - 1)) {
                int currentNumber = number;
                int currentSequenceLength = 1;

                // Count consecutive sequence
                while (uniqueNumbers.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentSequenceLength++;
                }

                // Update the longest sequence length
                if (currentSequenceLength > longestSequenceLength) {
                    longestSequenceLength = currentSequenceLength;
                }
            }
        }
        return longestSequenceLength;
    }
}
