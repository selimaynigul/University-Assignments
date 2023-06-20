/**
 * @author Selim Aynigul
 */
package homework6;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

public class MergeSort {
    
    private myMap originalMap;
    private myMap sortedMap;
    /**
     * Constructor method to assign original map and create sorted map with merge sort
     * 
     * @param map will be assigned as original
     */
    public MergeSort(myMap map) {
        originalMap = map;
    }
    /**
     * getter for sorted map 
     * 
     * @return sortedMap 
     */
    public myMap getSortedMap() { return sortedMap;}
    /**
     * getter for original map
     * 
     * @return originalMap
     */
    public myMap getOriginalMap() { return originalMap; }
    /**
     * Sort original map using merge sort algorithm and assign it to sorted array
     */
    public void sort() {
        sortedMap = new myMap(mergeSort(originalMap.getMap()));
    }
    /**
     * Split the array in half recursively until it cannot be split, and sort.

     * @param map will be sorted with merge sort
     * @return sorted map
     */
    public LinkedHashMap<Character, info> mergeSort(LinkedHashMap<Character, info> map) {
        // Base case
        if (map.size() < 2) return map;
        LinkedHashMap<Character, info> first = new LinkedHashMap<>(), second = new LinkedHashMap<>();
        // Put the first half of the map to the first map and second half to the second map
        int i = 0;
        for (Map.Entry<Character, info> entry : map.entrySet()) {
            if (i++ < map.size() / 2) first.put(entry.getKey(), entry.getValue());
            else second.put(entry.getKey(), entry.getValue());
        }
        // Continue splitting the array in two recursively
        first = mergeSort(first);
        second = mergeSort(second);
        // Merge sorted first and second map and assign to sortedmap
        return merge(first, second);
    }
    /**
     * Sort and merge two maps.
     * 
     * @param first first half of the map
     * @param second second half of the map
     * @return merged map 
     */
    private LinkedHashMap<Character, info> merge(LinkedHashMap<Character, info> first, LinkedHashMap<Character, info> second) {
        LinkedHashMap<Character, info> mergedMap = new LinkedHashMap<>();
        // Compare first entries of the first and second part and put small one to merged map
        while (!first.isEmpty() && !second.isEmpty()) {
            if (getFirstEntry(second).getValue().getCount() >= getFirstEntry(first).getValue().getCount()) {
                mergedMap.put(getFirstEntry(first).getKey(), getFirstEntry(first).getValue());
                first.remove(getFirstEntry(first).getKey());
            } 
            else {
                mergedMap.put(getFirstEntry(second).getKey(), getFirstEntry(second).getValue());
                second.remove(getFirstEntry(second).getKey());
            }
        }
        // Put remaining enrties of the first and second part to the merged map
        while (!second.isEmpty()) {
            mergedMap.put(getFirstEntry(second).getKey(), getFirstEntry(second).getValue());
            second.remove(getFirstEntry(second).getKey());
        }
        while (!first.isEmpty()) {
            mergedMap.put(getFirstEntry(first).getKey(), getFirstEntry(first).getValue());
            first.remove(getFirstEntry(first).getKey());
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

