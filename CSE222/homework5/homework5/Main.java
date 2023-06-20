/**
 * 
 * @author Selim Aynigul
 */
package homework5;

import java.util.Scanner;

public class Main {
    /**
     * Main method to take inputs and test the functions
     * 
     * @param args
     */
    public static void main(String[] args) {

        Tree tree = new Tree(); // PART A
        
        // Get input to search in tree
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter to search: ");
        String input = scanner.nextLine();

        // Searching in tree with different algorithms
        tree.findBFS(input); // PART B
        tree.findDFS(input); // PART C
        tree.findPostOrder(input); // PART D

        // Getting input node to move in the tree
        System.out.println("\n\nPlease enter to move: (ex: 2023,CSE321,LECTURE1)");
        input = scanner.nextLine();
        String[] node = input.split(",");
        System.out.println("\nPlease enter the year: ");
        String newLocation = scanner.nextLine();
        scanner.close();
     
        // Move input node to selected folder
        tree.moveNode(node, newLocation); // PART E
    }
}
