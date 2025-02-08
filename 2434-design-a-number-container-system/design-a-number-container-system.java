import java.util.*;

class NumberContainers {
    private Map<Integer, Integer> indexMap;  // Stores index -> number mapping
    private Map<Integer, TreeSet<Integer>> numberMap;  // Stores number -> set of indices

    public NumberContainers() {
        indexMap = new HashMap<>();
        numberMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexMap.containsKey(index)) {
            int oldNumber = indexMap.get(index);
            if (oldNumber == number) return; // No need to update if same number

            // Remove index from old number's set
            numberMap.get(oldNumber).remove(index);
            if (numberMap.get(oldNumber).isEmpty()) {
                numberMap.remove(oldNumber);
            }
        }

        // Update indexMap
        indexMap.put(index, number);

        // Add index to new number's TreeSet
        numberMap.putIfAbsent(number, new TreeSet<>());
        numberMap.get(number).add(index);
    }

    public int find(int number) {
        if (!numberMap.containsKey(number) || numberMap.get(number).isEmpty()) {
            return -1;
        }
        return numberMap.get(number).first(); // Get the smallest index
    }
}
