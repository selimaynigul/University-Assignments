/**
 * @author Selim Aynigul
 */
package sort;
/**
 * Selection sort subclass to sort given map with selection sort algorithm.
 */
public class SelectionSort extends Sort{
    /**
     * Constructor method to assign original map
     * @param map will be assigned as original map
     */
    public SelectionSort(MyMap map) {
        originalMap = map;
    }
   
    public void sort() {
        sortedMap = originalMap;
        int n = sortedMap.getMap().size();
        for(int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < n; j++) {
                if(getCountAt(j) <= getCountAt(minIndex)) 
                    minIndex = j;
            }
            if(minIndex != i) swap(i, minIndex);
        }
    }
}
