/**
 * @author Selim Aynigul
 */
package sort;

import java.util.Map;
import java.util.LinkedHashMap;
/**
 * Abstract class to define essential methods for other sorting subclasses.
 */
public abstract class Sort {
    protected MyMap originalMap;
    protected MyMap sortedMap;
    /**
     * Get sorted method
     * @return sortedMap
     */
    public MyMap getsortedMap() {
        return sortedMap;
    }
    /**
     * Sort original map in increasing order
     */
    public abstract void sort();
    /**
     * Swap two element of the map
     * @param i first index of the element to be swapped
     * @param j second index of the element to be swapped
     */
    protected void swap(int i, int j) {
        if(i == j) return;
        LinkedHashMap<Character, info> newMap = new LinkedHashMap<>();
        Map.Entry<Character, info> firstEntry = null, secondEntry = null;
        int index = 0; 
        // Find entries at the given indexes
        for(Map.Entry<Character, info> entry : sortedMap.getMap().entrySet()) {
            if(index == i) firstEntry = entry;
            else if(index == j) secondEntry = entry;
            index++;
        }
        index = 0;
        // Put entries into a new map with swapped indexes
        for(Map.Entry<Character, info> entry : sortedMap.getMap().entrySet()) {
            if(index == i) newMap.put(secondEntry.getKey(), secondEntry.getValue());
            else if(index == j) newMap.put(firstEntry.getKey(), firstEntry.getValue());
            else newMap.put(entry.getKey(), entry.getValue());
            index++;
        }
        sortedMap.setMap(newMap);
    }
    /**
     * Get the count value of the given index in the sorted map
     * @param index position of the element
     * @return Count value of the info object in the given index of the sorted map
     */
    protected int getCountAt(int index) {
        int i = 0;
        for (Map.Entry<Character, info> entry : sortedMap.getMap().entrySet()) 
            if (index == i++) return entry.getValue().getCount();
        return -1;
    }
}