/**
 * @author Selim Aynigul
 */
package homework5;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Tree {

    private LinkedList<String[]> arr;
    private DefaultMutableTreeNode root;
    private JTree tree;
    private JFrame frame;

    /**
     * Constructor method to read txt file and create JTree structure
     */
    public Tree() {
        arr = readFromFile("tree.txt");
        root = createTree(arr);
        showTree();
    }
    /**
     * Read input file and convert it to a 2D list
     * 
     * @param fileName name of the input txt file to read
     * @return 2D list that converted from txt file
     */
    private LinkedList<String[]> readFromFile(String fileName) {
        LinkedList<String[]> arr = new LinkedList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] nodes = line.split(";");
                arr.add(nodes);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return arr;
    }
    /**
     * convert 2D input array to tree structure
     * 
     * @param data will be converted 
     * @return root node of the tree
     */
    private DefaultMutableTreeNode createTree(LinkedList<String[]> data) {

         // Create tree structure from 2d array
                
        // Create the root node of the JTree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        // Loop through the input array and add nodes to the JTree
        for (String[] nodeData : data) {
            DefaultMutableTreeNode node = root;

            // Traverse the JTree to find the parent node of the current node
            for (int i = 0; i < nodeData.length - 1; i++) {
                String nodeName = nodeData[i];
                DefaultMutableTreeNode nextNode = null;

                // Check if the parent node already exists
                for (int j = 0; j < node.getChildCount(); j++) {
                    DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(j);
                    if (nodeName.equals(child.getUserObject().toString())) {
                        nextNode = child;
                        break;
                    }
                }
                // If the parent node does not exist, create it and add it to the JTree
                if (nextNode == null) {
                    nextNode = new DefaultMutableTreeNode(nodeName);
                    node.add(nextNode);
                }
                node = nextNode;
            }

            // Add the current node to the JTree
            String nodeName = nodeData[nodeData.length - 1];
            DefaultMutableTreeNode leaf = new DefaultMutableTreeNode(nodeName);
            node.add(leaf);
        }
        return root;
    }     
    /**
     * Use BFS algorithm to search the tree
     * 
     * @param searchString target value
     * @return boolean
     */
    public boolean findBFS(String searchString) {
        // Create a queue to hold nodes to be visited
        Queue<DefaultMutableTreeNode> queue = new LinkedList<>();
        // Add the root node to the queue
        queue.add(root);

        int step = 1;
        System.out.print("\nUsing BFS to find '" + searchString + "' in the tree...");

        // Traverse the tree using BFS
        while (!queue.isEmpty()) {
            DefaultMutableTreeNode currentNode = queue.poll();
            System.out.print("\nStep " + (step++) + " -> " + currentNode.toString());
            // If the node contains the search string end the search
            if (currentNode.toString().equals(searchString)) {
                System.out.println(" (Found!)");
                return true;
            }
            // Add the current node's children to the queue for searching
            for (int i = 0; i < currentNode.getChildCount(); i++) {
                DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) currentNode.getChildAt(i);
                queue.add(childNode);
            }
        }
        // if tree doesn't have the target
        System.out.println("\n'" + searchString + "' not found in the tree.");
        return false;
    }
    /**
     * Use DFS algorithm to search the tree
     * @param searchString target value
     * @return boolean
     */
    public boolean findDFS(String searchString)
    {
        int step = 1;
        System.out.print("\nUsing DFS to find '" + searchString + "' in the tree...");
        Stack<DefaultMutableTreeNode> stack = new Stack<>();
        stack.push(root);
        // traverse the tree using dfs
        while (!stack.isEmpty()) {
            DefaultMutableTreeNode temp = stack.pop();
            System.out.print("\nStep " + (step++) + " -> " + temp.toString());
            if(temp.toString().equals(searchString)) {
                System.out.println(" (Found!)");
                return true;
            }
            for (int i = 0; i < temp.getChildCount(); i++) {
                stack.push((DefaultMutableTreeNode)temp.getChildAt(i));
            }
        }
        System.out.println("\n'" + searchString + "' not found in the tree.");
        return false;
    }
    
    /**
     * Use post order traversal to search the tree
     * 
     * @param searchString target value
     * @return boolean
     */
    public boolean findPostOrder(String searchString) {
        System.out.print("\nUsing Post Order Traversal to find '" + searchString + "' in the tree...");
        Stack<DefaultMutableTreeNode> stack = new Stack<>();
        Stack<DefaultMutableTreeNode> visited = new Stack<>();
        int index = 1;
        stack.push(root);
        while (!stack.isEmpty()) {
            DefaultMutableTreeNode node = stack.pop();
            visited.push(node);
            for (int i = 0; i < node.getChildCount(); i++) {
                DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
                stack.push(child);
            }
        }
        while (!visited.isEmpty()) {
            DefaultMutableTreeNode node = visited.pop();
            System.out.print("\nStep " + (index++) + " -> " + node.toString());
            if (node.toString().equals(searchString)) {
                System.out.println(" (Found!)");
                return true;
            }
        }
        System.out.println("\n'" + searchString + "' not found in the tree.");
        return false;
    }
    /**
     * Get input node 
     * 
     * @param root this tree will be searched
     * @param nodes input node to search
     * @return if given input exist then return it, othwewise return null
     */
    private DefaultMutableTreeNode getNode(String[] nodes) {

        int index = 0;
        String searchString = nodes[index];

        // Create a queue to hold nodes to be visited
        Queue<DefaultMutableTreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Traverse the tree using BFS
        while (!queue.isEmpty()) {
            // Get the current node from the front of the queue
            DefaultMutableTreeNode currentNode = queue.poll();
            // If a level of path is found check if it is the last level
            if (currentNode.toString().equals(searchString)) {
                // If this is the last level of search return the node
                if(index == nodes.length - 1) {
                    return currentNode;
                }
                // If this is not the last level continue to search next level
                else {
                    searchString = nodes[++index];
                }
                // Clear the queue to prevent unnecessary itearations
                queue.clear();
            }
            // Add the current node's children to the queue
           for (int i = 0; i < currentNode.getChildCount(); i++) {
               queue.add((DefaultMutableTreeNode)currentNode.getChildAt(i));
           }
        }
        return null;
    }
    /**
     * Get new location to move
     * 
     * @param year find this node 
     * @return new location's node
     */
    private DefaultMutableTreeNode getYear(String year) {
        for (int i = 0; i < root.getChildCount(); i++) {
            if(root.getChildAt(i).toString().equals(year)) 
                return (DefaultMutableTreeNode)root.getChildAt(i);
        }
        return null;
    }
    /**
     * Remove selected node from tree. If the parent folder will be empty after 
     * removing input then remove the empty folder as well.
     * 
     * @param node will be removed
     */
    private static void removeNode(DefaultMutableTreeNode node) {
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode)node.getParent();
        node.removeFromParent();
        // remove the parent folder if there is no more child after removing existing child
        while(parent.getChildCount() == 0) {
            DefaultMutableTreeNode temp = (DefaultMutableTreeNode)parent.getParent();
            parent.removeFromParent();
            parent = temp;
        }
    }
    /**
     * Add node to the new location in the tree
     * 
     * @param location where to move
     * @param nodes node path to move
     * @param temp if node has child add this nodes childs to new location
     * @param year location to move
     */
    private void addNode(DefaultMutableTreeNode location, DefaultMutableTreeNode temp, String[] nodes, String year) {

        // If given year is not in the tree create one
        if(location == null) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(year);
            root.add(node);
            location = node;
        }

        DefaultMutableTreeNode parent = location;
        int count = 0;
        for(int i = 1; i < nodes.length; i++) {
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(nodes[i]);
            boolean control = false;
            for(int j = 0; j < parent.getChildCount(); j++) {
                if(parent.getChildAt(j).toString().equals(newNode.toString())) { // search selected year
                    parent = (DefaultMutableTreeNode)parent.getChildAt(j);
                    count++;
                    control = true;
                }            
            }
            if(!control) {
                parent.add(newNode);
                parent = newNode;
            }
        }
        // If node has childs add them to their new location as well
        if(temp.getChildCount() != 0) {
            int num = temp.getChildCount();
            for(int i = 0; i < num; i++) {
                parent.add((DefaultMutableTreeNode)temp.getChildAt(0));
            }
        }
        // If both paths are the same print this information 
        if(count == nodes.length - 1) {
            System.out.println("\n" + print(nodes) + " has been overwritten");
        }
    }
    /**
     * Move selected node in the tree.
     * 
     * @param nodes input path to move
     * @param year location to move
     * @return if moving is done successfully return true, otherwise return false
     */
    public boolean moveNode(String[] nodes, String year) { 
        // check invalid situations
        if(nodes.length < 2) {
            System.out.println("Invalid input");
            return false;
        }
        if(year == nodes[0]) {
            System.out.println("You are already in the same year folder!");
            return false;
        }
        if(getNode(nodes) == null) {
            System.out.println("Cannot move " + print(nodes) + " because it doesn't exist in the tree.");
            return false;
        }
        DefaultMutableTreeNode node = getNode(nodes);
        DefaultMutableTreeNode location = getYear(year);
        DefaultMutableTreeNode temp = node;
        // remove node and add it to the new location
        removeNode(node);
        addNode(location, temp, nodes, year);
        showTree();

        System.out.println("\nMoved " +  print(nodes) + " to " + year);
        return true;
    }
    /**
     * Show JTree on the screen using JFrame
     */
    private void showTree() {
        tree = new JTree(root);
        frame = new JFrame("Tree");
        frame.add(tree);
        frame.setSize(400, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }
    /**
     * Convert given string array to proper format
     * 
     * @param nodes input path
     * @return proper format of the string to print
     */
    private String print(String[] nodes) {
        int n = nodes.length;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++) {
            res.append(nodes[i]);
            if(i != n - 1) res.append("->");
        }
        return res.toString();
    }
}