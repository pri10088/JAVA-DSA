class Solution {
    public boolean rotateString(String s, String goal) {
        int n1 = s.length();
        int n2 = goal.length();
        if(n1 != n2){
            return false;
        }

        String s3 = s + s;
        if(s3.indexOf(goal) != -1){
            return true;
        }
        return false;
        
    }
}