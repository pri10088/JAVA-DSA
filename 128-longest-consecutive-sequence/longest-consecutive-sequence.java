import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] numbers) {
        Set<Integer> uniqueNumbersSet = new HashSet<>();

        // Step 1: Add all numbers to a set for O(1) lookup
        for (int number : numbers) {
            uniqueNumbersSet.add(number);
        }

        int longestSequenceLength = 0; // Tracks the longest consecutive sequence length

        // Step 2: Iterate through each unique number
        for (int currentNumber : uniqueNumbersSet) {

            // Step 3: Check if 'currentNumber' is the start of a sequence
            if (!uniqueNumbersSet.contains(currentNumber - 1)) {
                int currentSequenceStart = currentNumber; // Start of the current sequence
                int currentSequenceLength = 1;            // Length of the current consecutive sequence

                // Step 4: Check for consecutive numbers after the start
                while (uniqueNumbersSet.contains(currentSequenceStart + 1)) {
                    currentSequenceStart++;  // Move to the next consecutive number
                    currentSequenceLength++; // Increase the current sequence length
                }

                // Step 5: Update the longest sequence length if current is longer
                longestSequenceLength = Math.max(longestSequenceLength, currentSequenceLength);
            }
        }

        // Step 6: Return the length of the longest consecutive sequence
        return longestSequenceLength;
    }
}
