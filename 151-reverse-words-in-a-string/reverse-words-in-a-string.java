class Solution {
    public String reverseWords(String s) {
        String[] string = s.trim().split("\\s+");
        int i=0;
        int j= string.length - 1;
            
            while(i<j){
                String temp = string[i];
                string[i] = string[j];
                string[j] = temp;
                i++;
                j--; 
            }
        return String.join(" ", string);
    }
}