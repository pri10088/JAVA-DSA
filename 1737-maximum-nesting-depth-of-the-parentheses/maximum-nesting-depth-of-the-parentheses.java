class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int cur  = 0;
        int maxCur = 0;
        for(char ch : s.toCharArray()){
            if( ch == '('){
                cur++;
                maxCur =  Math.max(maxCur, cur);
            }else if(ch == ')'){
                cur--;

            }
            
        }
        return maxCur;
        
    }
}