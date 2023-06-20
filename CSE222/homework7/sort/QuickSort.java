/**
 * @author Selim Aynigul
 */
package sort;
/**
 * Quick sort subclass to sort given map with Quick sort algorithm.
 */
public class QuickSort extends Sort {
    /**
     * Constructor method to assign original map
     * @param map will be assigned as original map
     */
    public QuickSort(MyMap map) {
        originalMap = map;
    }
    
    public void sort() {
        sortedMap = originalMap;
        quicksort(0, sortedMap.getMap().size() - 1);
    }
    /**
     * Main function that implements quick sort
     * @param low starting index
     * @param high ending index
     */
    private void quicksort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quicksort(low, pi - 1);
            quicksort(pi + 1, high);
        }    
    }
    /**
     * Take last element and place it at its correct position
     * in sorted map and place all smaller elements to left 
     * and greater elements to right.
     * @param low first index
     * @param high last index
     * @return pivot index
     */
    private int partition(int low, int high) {
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (getCountAt(j) < getCountAt(high)) 
                swap(++i, j);
        }
        swap(i + 1, high);
        return i + 1;
    }
}


