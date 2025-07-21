class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        if(s.length() != t.length()) return false;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            char a = t.charAt(i);
            count[c - 'a']++;
            count[a - 'a']--;
        }
        for(int c : count){
            if(c != 0) return false;
        }
        return true;
    }
}