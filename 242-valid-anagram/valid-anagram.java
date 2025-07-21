class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map1.put(c, map1.getOrDefault(c,0)+1);
        }
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(!map1.containsKey(c) || map1.get(c) == 0){
                return false;
            }
            map1.put(c, map1.get(c)-1);
        }
        return true;
    }
}