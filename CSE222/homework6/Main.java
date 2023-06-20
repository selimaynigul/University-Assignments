/**
 * @author Selim Aynigul
 */
package homework6;

public class Main {
    /**
     * Main method to test other classes and their functions.
     * 
     * @param args
     */
    public static void main(String[] args) {
        // PART A
        String input = "'Hush, hush!' whispered the rushing wind.";
        myMap mapObj = new myMap(input);
        String preProcessed = mapObj.rearrange();
        System.out.println("Original string:      " + mapObj.getStr());
        System.out.println("Preprocessed string:  " + preProcessed);
        // PART B
        mapObj.buildMap(preProcessed);
        // PART C
        MergeSort mergeSort = new MergeSort(mapObj);
        System.out.println("\nThe original (unsorted) map:");
        mergeSort.getOriginalMap().printMap();
        System.out.println("\nThe sorted map:");
        mergeSort.sort();
        mergeSort.getSortedMap().printMap();
    }
}