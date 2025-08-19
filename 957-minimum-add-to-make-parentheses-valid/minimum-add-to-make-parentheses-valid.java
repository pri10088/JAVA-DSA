class Solution {
    public int minAddToMakeValid(String s) {
        int balance = 0;   // unmatched '(' count
        int additions = 0; // how many '(' we need to add

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else { // ch == ')'
                if (balance > 0) {
                    balance--; // match with previous '('
                } else {
                    additions++; // need one '('
                }
            }
        }

        // Additions + remaining '(' to balance
        return additions + balance;
    }
}
