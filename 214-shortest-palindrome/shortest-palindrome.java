class Solution {
    public String shortestPalindrome(String s) {
        // form a new string for lps array calc
        String newStr = s + '#' + reverse(s);

        // get the longest palindrome length
        int[] lps = calculate(newStr);
        int longestLen = lps[lps.length - 1];

        // leftover + original string
        StringBuilder sb = new StringBuilder();
        String leftOver = s.substring(longestLen);
        sb.append(reverse(leftOver)).append(s);

        return sb.toString();
    }

    public static int[] calculate(String pat) {
        int n = pat.length();
        int[] lps = new int[n];

        int j = 0, i = 1;
        while (i < n) {
            // match
            if (pat.charAt(j) == pat.charAt(i)) {
                lps[i] = j + 1;
                j++; i++;
            }

            // not-match
            else {
                // j didn't move yet
                if (j == 0) {
                    // put zero & inc i
                    lps[i] = 0;
                    i++;
                }

                // j had moved to right
                else {
                    // move j to prev char index lps
                    j = lps[j - 1];
                }
            }
        }

        return lps;
    }

    public String reverse(String s) {
        int n = s.length();

        char[] str = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            char temp = str[i];
            str[i] = str[n - i - 1];
            str[n - i - 1] = temp;
        }

        return new String(str);
    }
}