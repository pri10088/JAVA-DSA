class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mpp = new HashMap<>();
        for(String s : strs){
            char[] ch= s.toCharArray();
            Arrays.sort(ch);
            String s1 = String.valueOf(ch);

            if(!mpp.containsKey(s1)){
                mpp.put(s1, new ArrayList<>());
            }
            mpp.get(s1).add(s);
        }
        return new ArrayList<>(mpp.values());        
    }
}