class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> mpp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> q = new PriorityQueue<>(
                (a, b) -> mpp.get(b) - mpp.get(a));
        q.addAll(mpp.keySet());
        StringBuilder s1 = new StringBuilder();
        while (!q.isEmpty()) {

            char ch = q.poll();
            int count = mpp.get(ch);
            for (int i = 0; i < count; i++) {
                s1.append(ch);
            }
        }

        return s1.toString();

    }
}