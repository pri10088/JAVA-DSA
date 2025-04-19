class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int l=0, r=0, ans=0;
        HashSet<Character> set = new HashSet<>();
        while(r<s.length()){
            char ch = s.charAt(r);
            while(set.contains(ch)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(ch);
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
        
    }
}