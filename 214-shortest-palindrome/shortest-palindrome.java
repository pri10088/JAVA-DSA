class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        int[] lps = computeLPS(combined);

        // longest palindrome prefix length
        int len = lps[lps.length - 1];

        // add the remaining suffix of rev in front of s
        return rev.substring(0, s.length() - len) + s;
    }

    private int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int j = 0; // length of current matching prefix

        for (int i = 1; i < n; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = lps[j - 1]; // fallback
            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }
        return lps;
    }
}
