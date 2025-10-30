class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int operations = target[0]; // start with first element
        
        for (int i = 1; i < n; i++) {
            if (target[i] > target[i - 1]) {
                operations += target[i] - target[i - 1];
            }
        }
        
        return operations;
    }
}
