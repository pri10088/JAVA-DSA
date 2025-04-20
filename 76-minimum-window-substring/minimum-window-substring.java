class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countT = new HashMap<>();
        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int have =0, need = countT.size();
        int res[] = { -1, -1};
        int resLen=Integer.MAX_VALUE, l =0;

        Map<Character, Integer> window = new HashMap<>();
        for(int r=0; r<s.length(); r++){
            char ch = s.charAt(r);
            window.put(ch, window.getOrDefault(ch,0)+1);

            if(countT.containsKey(ch) && window.get(ch).intValue() == countT.get(ch).intValue()){
                have++;
            }
            while(have == need){
                if(r-l+1 <resLen){
                     res[0] = l;
                     res[1] = r;
                    resLen = r-l+1;
                }

                char lc = s.charAt(l);
                window.put(lc, window.get(lc)-1);

                if(countT.containsKey(lc) && window.get(lc) < countT.get(lc)){
                    have--;
                }

                l++;
            }

        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);

        
    }
}