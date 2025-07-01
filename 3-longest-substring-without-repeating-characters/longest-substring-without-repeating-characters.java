class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0,maxLength=0;
        HashMap<Character, Integer> mpp = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if(mpp.containsKey(c)){
                l = Math.max(mpp.get(c)+1, l);
            }

            mpp.put(c,r);
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}