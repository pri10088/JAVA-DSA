class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        /// UPVOTE !
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray();

        while (end < chS.length) {
            if (map[chS[end++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? new String() :
                new String(chS, startIndex, minLen);
    }
}
--------------------------------------------------------------------------------------
    class Solution {
    public String minWindow(String s, String t) {
        // If s is smaller than t, no possible window
        if (s.length() < t.length()) return "";

        // 1. Build frequency map for characters in t
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            // Count how many times each character appears in t
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 2. Initialize sliding window data structures
        Map<Character, Integer> window = new HashMap<>();
        int have = 0;                      // How many unique characters currently satisfy the requirement
        int needSize = need.size();        // Total unique characters we need
        int left = 0;                      // Left pointer of window
        int minLen = Integer.MAX_VALUE;    // Track minimum length found
        int start = 0;                     // Track start index of best window

        // 3. Expand the window using right pointer
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // Add current character to the window map
            window.put(c, window.getOrDefault(c, 0) + 1);

            // If this char is needed and now counts match, increment 'have'
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }

            // 4. When all needed chars are satisfied, shrink from left to minimize window
            while (have == needSize) {
                // Update the result if this window is smaller
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Try to remove the leftmost character to shrink window
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // If removing leftChar breaks the requirement, decrease 'have'
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    have--;
                }

                // Move left pointer forward
                left++;
            }
        }

        // 5. Return the smallest window if found, else return empty string
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
