/**
 * @author Selim Aynigul
 */
package sort;

import java.util.Map;
import java.util.LinkedHashMap;
/**
 * merge sort subclass to sort given map with merge sort algorithm.
 */
public class MergeSort extends Sort{
    /**
     * Split the array in half recursively until it cannot be split, and sort.

     * @param map will be sorted with merge sort
     * @return sorted map
     */
    public MergeSort(MyMap map) {
        originalMap = map;
    }
    
    public void sort() {
        sortedMap = new MyMap(mergeSort(originalMap.getMap()));
    }
    /**
     * Split the array in half recursively until it cannot be split, and sort.

     * @param map will be sorted with merge sort
     * @return sorted map
     */
    private LinkedHashMap<Character, info> mergeSort(LinkedHashMap<Character, info> map) {
        // Base case
        if (map.size() <= 1) return map;
        // Create two maps for left and right parts of the map
        LinkedHashMap<Character, info> left = new LinkedHashMap<>(), right = new LinkedHashMap<>();
        // Put the first half of the map to the left map and second half to the right map
        int i = 0;
        for (Map.Entry<Character, info> entry : map.entrySet()) {
            if (i++ < map.size() / 2) left.put(entry.getKey(), entry.getValue());
            else right.put(entry.getKey(), entry.getValue());
        }
        // Continue splitting the array in two recursively
        left = mergeSort(left);
        right = mergeSort(right);
        // Merge sorted left and right parts and assign to sortedmap
        return merge(left, right);
    }
    /**
     * Sort and merge two maps.
     * 
     * @param left first half of the map
     * @param right second half of the map
     * @return merged map 
     */
    private LinkedHashMap<Character, info> merge(LinkedHashMap<Character, info> left, LinkedHashMap<Character, info> right) {
        LinkedHashMap<Character, info> mergedMap = new LinkedHashMap<>();
        // Compare first entries of the left and right maps and put small one to merged map
        while (!left.isEmpty() && !right.isEmpty()) {
            if (getFirstEntry(left).getValue().getCount() <= getFirstEntry(right).getValue().getCount()) {
                mergedMap.put(getFirstEntry(left).getKey(), getFirstEntry(left).getValue());
                left.remove(getFirstEntry(left).getKey());
            } 
            else {
                mergedMap.put(getFirstEntry(right).getKey(), getFirstEntry(right).getValue());
                right.remove(getFirstEntry(right).getKey());
            }
        }
        // Put remaining enrties of the left and right part to the merged map
        while (!left.isEmpty()) {
            mergedMap.put(getFirstEntry(left).getKey(), getFirstEntry(left).getValue());
            left.remove(getFirstEntry(left).getKey());
        }
        while (!right.isEmpty()) {
            mergedMap.put(getFirstEntry(right).getKey(), getFirstEntry(right).getValue());
            right.remove(getFirstEntry(right).getKey());
        }
        return mergedMap;
    }
    /**
     * Get first entry of the map.
     * 
     * @param map use this to return first entry
     * @return first entry of the map
     */
    private Map.Entry<Character, info> getFirstEntry(LinkedHashMap<Character, info> map){
        Map.Entry<Character, info> firstEntry = null;
        for (Map.Entry<Character, info> entry : map.entrySet()) {
            firstEntry = entry;
            break;
        }
        return firstEntry;
    }
}

