class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            mpp.put(c, mpp.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (mpp.containsKey(c)) {
                mpp.put(c, mpp.get(c) - 1);
                if (mpp.get(c) == 0) {
                    mpp.remove(c);
                }
            }
        }
        return mpp.isEmpty();
    }
}