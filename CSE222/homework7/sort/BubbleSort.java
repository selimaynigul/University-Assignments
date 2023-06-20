/**
 * @author Selim Aynigul
 */
package sort;
/**
 * bubble sort subclass to sort given map with bubble sort algorithm.
 */
public class BubbleSort extends Sort{
    /**
     * Constructor method to assign original map
     * @param map will be assigned as original map
     */
    public BubbleSort(MyMap map) {
        originalMap = map;
    }

    public void sort() {
        sortedMap = originalMap;
        int n = sortedMap.getMap().size();
        for(int i = 0; i < n; i++) 
            for(int j = 1; j < n - i; j++)
                if(getCountAt(j - 1) > getCountAt(j))
                    swap(j - 1, j);
    }
}




