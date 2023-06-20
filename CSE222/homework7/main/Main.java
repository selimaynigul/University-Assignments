/**
 * @author Selim Aynigul
 */
package main;

import sort.*;
/**
 * Main class to sort given maps with sorting algorithms and print sorted maps.
 */
public class Main {
     /**
     * Main method to test other classes and their functions.
     * @param args
     */
    public static void main(String[] args) {
        String input = "'Hush, hush!' whispered the rushing wind.";
        MyMap map = new MyMap(input);
        System.out.println("\nInput: "+ input +"\n\nOriginal Map:");
        map.printMap();
        // Create sorting objects
        Sort quickSort = new QuickSort(new MyMap(input));
        Sort selectionSort = new SelectionSort(new MyMap(input));
        Sort bubbleSort = new BubbleSort(new MyMap(input));
        Sort mergeSort = new MergeSort(new MyMap(input));
        Sort insertionSort = new InsertionSort(new MyMap(input));
        // Execute sorting functions
        mergeSort.sort();      
        quickSort.sort();  
        bubbleSort.sort();  
        selectionSort.sort();
        insertionSort.sort();
        // Print sorted maps
        System.out.println("\nMerge Sort:");
        mergeSort.getsortedMap().printMap();
        System.out.println("\nQuick Sort:");
        quickSort.getsortedMap().printMap();
        System.out.println("\nBubble Sort:");
        bubbleSort.getsortedMap().printMap();
        System.out.println("\nSelection Sort:");
        selectionSort.getsortedMap().printMap();
        System.out.println("\nInsertion Sort:");
        insertionSort.getsortedMap().printMap();
    }
}


