import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] current = new char[2 * n]; // preallocate char array
        backtrack(result, current, 0, 0, n, 0);
        return result;
    }

    private void backtrack(List<String> result, char[] current, int open, int close, int n, int pos) {
        if (pos == current.length) {
            result.add(new String(current)); // convert to string once
            return;
        }

        if (open < n) { // add '(' if possible
            current[pos] = '(';
            backtrack(result, current, open + 1, close, n, pos + 1);
        }

        if (close < open) { // add ')' if valid
            current[pos] = ')';
            backtrack(result, current, open, close + 1, n, pos + 1);
        }
    }
}
