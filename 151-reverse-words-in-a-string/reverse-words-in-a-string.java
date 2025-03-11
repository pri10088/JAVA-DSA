class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder();
        String a[] = s.trim().split("\\s+");
        for(int i=a.length-1; i>=0; i--){
            str.append(a[i]);
            if(i>0){
                str.append(" ");
            }

        }
        return str.toString();
        
    }
}