import java.util.*;
import java.math.BigInteger;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        // Prime numbers for 'a' to 'z'
        int[] nos = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67,
            71, 73, 79, 83, 89, 97, 101
        };

        Map<BigInteger, List<String>> map = new HashMap<>();

        for (String word : strs) {
            BigInteger prod = BigInteger.ONE;
            for (int i = 0; i < word.length(); i++) {
                int prime = nos[word.charAt(i) - 'a'];
                prod = prod.multiply(BigInteger.valueOf(prime));
            }

            if (!map.containsKey(prod)) {
                map.put(prod, new ArrayList<>());
            }
            map.get(prod).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
