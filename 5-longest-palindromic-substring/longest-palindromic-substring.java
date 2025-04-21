class Solution {
    public String longestPalindrome(String s) {
        int start =0, end=0;
        for(int i=0; i<s.length(); i++){
            int len1 = checkP(s, i, i);
            int len2 = checkP(s, i, i+1);

            int maxLen = Math.max(len1, len2);

            if(maxLen > end - start){
                start = i - (maxLen-1)/2;
                end = i + maxLen/2;
            }


        }
        return s.substring(start, end+1);

        
    }
    public int checkP(String s, int left, int right){
            int l = left, r = right;
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            return r-l-1;
        }
}