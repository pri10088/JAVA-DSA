class Solution {
    public int lengthOfLastWord(String s) {
        String[] st = s.trim().split("\\s+");
        int n = st.length-1;
        String res = st[n];
        int len = res.length();
        return len;
    }
}