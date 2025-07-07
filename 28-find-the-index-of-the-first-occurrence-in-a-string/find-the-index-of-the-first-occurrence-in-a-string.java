class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for(int i=0; i<n; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                int j=0;
                int k=i;
                while(j<m && k<n && haystack.charAt(k) == needle.charAt(j)){
                    j++;
                    k++;
                    if(j == m){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}