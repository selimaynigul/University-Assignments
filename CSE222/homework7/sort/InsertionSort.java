/**
 * @author Selim Aynigul
 */
package sort;

import java.util.Map;
import java.util.LinkedHashMap;
/**
 * Insertion sort subclass to sort given map with insertion sort algorithm.
 */
public class InsertionSort extends Sort {
     /**
     * Constructor method to assign original map
     * @param map will be assigned as original map
     */
    public InsertionSort(MyMap map) {
        originalMap = map;
    }

    public void sort() {
        sortedMap = originalMap;
        int n = sortedMap.getMap().size();
        for (int i = 1; i < n; i++) {
            Map.Entry<Character, info> key = getEntry(i);
            int j = i - 1;
            while (j >= 0 && getCountAt(j) > key.getValue().getCount()) {
                swap(j + 1, j--);
            }
            insert(j + 1, key);
        }
    }
    /**
     * Insert given entry into given index
     * @param index position to insert
     * @param key will be inserted 
     */
    private void insert(int index, Map.Entry<Character, info> key) {
        LinkedHashMap<Character, info> newMap = new LinkedHashMap<>();
        int i = 0;
        for(Map.Entry<Character, info> entry : sortedMap.getMap().entrySet()) {
            if(index == i++) newMap.put(key.getKey(), key.getValue());
            newMap.put(entry.getKey(), entry.getValue());
        }
        sortedMap.setMap(newMap);
    }
    /**
     * Get the entry at the given index
     * @param index position of the entry
     * @return given index's entry in the sorted map
     */
    private Map.Entry<Character, info> getEntry(int index) {
        int i = 0;
        for (Map.Entry<Character, info> entry : sortedMap.getMap().entrySet()) 
            if (index == i++) return entry;
        return null;
    }
}
