class Solution {
    public List<String> letterCombinations(String digits) {
        
        String[] mapping = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        List<String> result = new ArrayList<>();
         if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(),result,mapping);
        return result;
    }
    private void backtrack(String digits, int index, StringBuilder current, List<String> result, String[] mapping){
        if(index == digits.length()){
            result.add(current.toString());
            return;
        }
        char digitChar = digits.charAt(index);
           String letters = mapping[digitChar - '0'];

        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current, result, mapping);
            current.deleteCharAt(current.length() - 1);
        }
    }
}