import java.util.*;

class RandomizedSet {
    private Map<Integer, Integer> map; // value -> index
    private List<Integer> list;        // store values
    private Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);                 // Add to list
        map.put(val, list.size() - 1); // Store index in map
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        
        int idx = map.get(val);             // Index of val
        int lastElement = list.get(list.size() - 1);

        // Swap val with last element to remove in O(1)
        list.set(idx, lastElement);
        map.put(lastElement, idx);

        // Remove last element
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
