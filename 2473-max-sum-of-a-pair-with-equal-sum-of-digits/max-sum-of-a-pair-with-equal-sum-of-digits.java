import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> digitSumMap = new HashMap<>();
        for (int num : nums) {
            int sum = getDigitSum(num);
            digitSumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(num);
        }
        int maxSum = -1;
        for (List<Integer> group : digitSumMap.values()) {
            if (group.size() >= 2) {
                Collections.sort(group, Collections.reverseOrder());
                int currentSum = group.get(0) + group.get(1);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}