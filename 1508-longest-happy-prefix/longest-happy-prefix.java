class Solution {
    public String longestPrefix(String s) {
        long mod = (long)1e9 + 7; // large prime to avoid collisions
        long base = 31;           // base for polynomial hashing
        long prefixHash = 0, suffixHash = 0, power = 1;
        int n = s.length();
        int longest = 0;

        for (int i = 0; i < n - 1; i++) {
            int leftChar = s.charAt(i) - 'a' + 1;     // map 'a'→1, 'b'→2, ...
            int rightChar = s.charAt(n - 1 - i) - 'a' + 1;

            // build prefix hash
            prefixHash = (prefixHash * base + leftChar) % mod;

            // build suffix hash
            suffixHash = (suffixHash + rightChar * power) % mod;

            // increase power for next suffix position
            power = (power * base) % mod;

            // if prefix and suffix hash match, update answer
            if (prefixHash == suffixHash) {
                longest = i + 1;
            }
        }

        return s.substring(0, longest);
    }
}
