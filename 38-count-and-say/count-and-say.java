class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";  // Base case
        
        String prev = countAndSay(n - 1); // Get previous sequence
        StringBuilder sb = new StringBuilder();
        
        int count = 1;
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == prev.charAt(i - 1)) {
                count++; // Count consecutive characters
            } else {
                sb.append(count).append(prev.charAt(i - 1));
                count = 1; // reset count
            }
        }
        
        // Append last group
        sb.append(count).append(prev.charAt(prev.length() - 1));
        
        return sb.toString();
    }
}
