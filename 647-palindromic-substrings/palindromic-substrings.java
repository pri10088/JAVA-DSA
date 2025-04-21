class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
             count += checkP(s, i, i);
             count += checkP(s, i, i + 1);
        }
        return count;
        
    }
    public int checkP(String s, int left, int right){
        int l = left, r = right, count =0;
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            count++;
            l--;
            r++;
        }
        return count;
    }

}