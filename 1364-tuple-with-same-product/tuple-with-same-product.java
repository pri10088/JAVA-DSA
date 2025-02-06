class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productMap = new HashMap<>();
        int n = nums.length;

        // Step 1: Store product frequencies in a HashMap
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productMap.put(product, productMap.getOrDefault(product, 0) + 1);
            }
        }

        int count = 0;

        
        for (int freq : productMap.values()) {
            if (freq > 1) {
                count += freq * (freq - 1) * 4; // kC2 * 2 permutations
            }
        }

        return count;
    }
}