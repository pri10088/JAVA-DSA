class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c,0)+1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0,minLen=Integer.MAX_VALUE, have=0, needSize=need.size(),start = 0;
        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c,0)+1);

            if(need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()){
                have++;
            }
            while(have == needSize){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar)-1);
                if(need.containsKey(leftChar) && window.get(leftChar)< need.get(leftChar)){
                    have--;
                }
                left++;
            }

        }
         return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}