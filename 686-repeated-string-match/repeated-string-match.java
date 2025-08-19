class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        // Keep appending until length of sb >= length of b
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // Check if b is substring now
        if (sb.indexOf(b) != -1) return count;

        // Append one more time in case b overlaps
        sb.append(a);
        count++;
        if (sb.indexOf(b) != -1) return count;

        // If still not found
        return -1;
    }
}
