/**
 * @author Selim Aynigul
 */
package main;

import sort.*;
/**
 * Test class to print running times of the sorting algorithms with three different inputs.
 */
public class TestClass {
     /**
     * Main method to test running times.
     * @param args
     */
    public static void main(String[] args) {
       
        long start, end;

        String worst = "ooooooooooooooo nnnnnnnnnnnnnn mmmmmmmmmmmmm llllllllllll kkkkkkkkkkk jjjjjjjjjj iiiiiiiii hhhhhhhh ggggggg ffffff eeeee dddd ccc bb a";
        System.out.println("\nWorst Case Input:\n====================\n" + worst);
    
        String best = "a bb ccc dddd eeeee ffffff ggggggg hhhhhhhh iiiiiiiii jjjjjjjjjj kkkkkkkkkkk llllllllllll mmmmmmmmmmmmm nnnnnnnnnnnnnn ooooooooooooooo";
        System.out.println("\nBest Case Input:\n====================\n" + best);

        String avg = "eeeee ggggggg ccc nnnnnnnnnnnnnn llllllllllll bb ooooooooooooooo a kkkkkkkkkkk jjjjjjjjjj ffffff iiiiiiii mmmmmmmmmmmmm dddd";
        System.out.println("\nAverage Case Input:\n====================\n" + avg + "\n");
                
        
        Sort quickSort = new QuickSort(new MyMap(worst));
        Sort selectionSort = new SelectionSort(new MyMap(worst));
        Sort bubbleSort = new BubbleSort(new MyMap(worst));
        Sort mergeSort = new MergeSort(new MyMap(worst));
        Sort insertionSort = new InsertionSort(new MyMap(worst));

        Sort quickSort2 = new QuickSort(new MyMap(best));
        Sort selectionSort2 = new SelectionSort(new MyMap(best));
        Sort bubbleSort2 = new BubbleSort(new MyMap(best));
        Sort mergeSort2 = new MergeSort(new MyMap(best));
        Sort insertionSort2 = new InsertionSort(new MyMap(best));

        Sort quickSort3 = new QuickSort(new MyMap(avg));
        Sort selectionSort3 = new SelectionSort(new MyMap(avg));
        Sort bubbleSort3 = new BubbleSort(new MyMap(avg));
        Sort mergeSort3 = new MergeSort(new MyMap(avg));
        Sort insertionSort3 = new InsertionSort(new MyMap(avg));
        
        
        System.out.println("====================\nMerge Sort:\n-----------");
        start = System.nanoTime(); 
        mergeSort.sort();
        end = System.nanoTime();      
        System.out.println("Worst Case:   "+ (double)(end - start)/1000000);
        start = System.nanoTime();
        mergeSort2.sort();
        end = System.nanoTime();      
        System.out.println("Best Case:    "+ (double)(end - start)/1000000);
        start = System.nanoTime();
        mergeSort3.sort();
        end = System.nanoTime();      
        System.out.println("Average Case: "+ (double)(end - start)/1000000);

        System.out.println("====================\nSelection Sort:\n---------------");
        start = System.nanoTime();
        selectionSort.sort();
        end = System.nanoTime();      
        System.out.println("Worst Case:   "+ (double)(end - start)/1000000);
        start = System.nanoTime();
        selectionSort2.sort();
        end = System.nanoTime();       
        System.out.println("Best Case:    "+ (double)(end - start)/1000000);
        start = System.nanoTime();
        selectionSort3.sort();
        end = System.nanoTime();      
        System.out.println("Average Case: "+ (double)(end - start)/1000000);
        
        System.out.println("====================\nInsertion Sort:\n---------------");
        start = System.nanoTime();
        insertionSort.sort();
        end = System.nanoTime();      
        System.out.println("Worst Case:   "+ (double)(end - start)/1000000);
        start = System.nanoTime();
        insertionSort2.sort();
        end = System.nanoTime();      
        System.out.println("Best Case:    "+ (double)(end - start)/1000000);
        start = System.nanoTime();
        insertionSort3.sort();
        end = System.nanoTime();      
        System.out.println("Average Case: "+ (double)(end - start)/1000000);

        System.out.println("====================\nBubble Sort:\n------------");
        start = System.nanoTime();
        bubbleSort.sort();  
        end = System.nanoTime();      
        System.out.println("Worst Case:   "+ (double)(end - start)/1000000);
        start = System.nanoTime();
        bubbleSort2.sort();  
        end = System.nanoTime();      
        System.out.println("Best Case:    "+ (double)(end - start)/1000000);
        start = System.nanoTime();
        bubbleSort3.sort();  
        end = System.nanoTime();      
        System.out.println("Average Case: "+ (double)(end - start)/1000000);
        
        System.out.println("====================\nQuick Sort:\n-----------");
        start = System.nanoTime();
        quickSort.sort();
        end = System.nanoTime();      
        System.out.println("Worst Case:   "+ (double)(end - start)/1000000);
        start = System.nanoTime();
        quickSort2.sort();
        end = System.nanoTime();      
        System.out.println("Best Case:    "+ (double)(end - start)/1000000);
        start = System.nanoTime();
        quickSort3.sort();
        end = System.nanoTime();      
        System.out.println("Average Case: "+ (double)(end - start)/1000000);

    }
}
