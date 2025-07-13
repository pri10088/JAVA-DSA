class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int ll = 0;

        for (String word : words) {
            if (!line.isEmpty() && ll + word.length() + line.size() > maxWidth) {
                int extraSpaces = maxWidth - ll;
                int gaps = line.size() - 1;

                for (int i = 0; i < extraSpaces; i++) {
                    int index = i % Math.max(gaps, 1);
                    line.set(index, line.get(index) + " ");
                }

                res.add(String.join("", line));
                line.clear();
                ll = 0;
            }

            line.add(word);
            ll = ll + word.length();
        }

        // Process last line (left-justified)
        String lastLine = String.join(" ", line);
        int spacesNeeded = maxWidth - lastLine.length();
        lastLine = lastLine + " ".repeat(spacesNeeded);
        res.add(lastLine);

        return res;
    }
}
