class Solution {
    public boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()){
            return false;

        }
        String s1 = s+s;
        if(s1.indexOf(goal) != -1){
            return true;
        }
        return false;
        
    }
}