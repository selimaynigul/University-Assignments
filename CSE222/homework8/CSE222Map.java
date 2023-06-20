import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
/**
 * Read input txt file and create 2D matrix array, convert it to png image 
 * and draw shortest path on it.
 */
public class CSE222Map {
    private String filename;
    private List<List<Integer>>  map;
    private List<Integer> startPoint;
    private List<Integer> endPoint;
    public int X_SIZE;
    public int Y_SIZE;
    
    // getters
    public List<List<Integer>> getMap() { return map;}
    public List<Integer> getStart() { return startPoint; }
    public List<Integer> getEnd() { return endPoint; }
    /**
     * Constructor method to read input txt file, assign start and end coordinates 
     * and create 2d matrix.
     * 
     * @param file name of the input file
     * @param x horizantal size of the matrix
     * @param y vertical size of the matrix
     */
    public CSE222Map(String file, int x, int y) {
        X_SIZE = x; Y_SIZE = y;
        this.filename = file.substring(0, file.length() - 4);
        file = "./TextFiles/" + file;
        map = new  ArrayList<List<Integer>>();
        startPoint = new ArrayList<>();
        endPoint = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                if (lineNumber == 0) startPoint = assignCoordinates(line);
                else if (lineNumber == 1) endPoint = assignCoordinates(line);
                else {
                    List<String> elements = Arrays.asList(line.split(","));
                    List<Integer> row = new ArrayList<>();
                    for (String element : elements) {
                        int val = Integer.parseInt(element);
                        if(val == -1) val = 1;
                        row.add(val);
                    }
                    map.add(row);
                }
                lineNumber++;
            }  
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Convert map to png image file.
     */
    public void convertPNG() {
        BufferedImage image = new BufferedImage(Y_SIZE, X_SIZE, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        for (int y = 0; y < X_SIZE; y++) {
            for (int x = 0; x < Y_SIZE; x++) {
                int pixel = map.get(y).get(x);
                if (pixel == 1) graphics.setColor(Color.GRAY);
                else graphics.setColor(Color.WHITE);
                graphics.fillRect(x, y, 1, 1);
            }
        }
        // Save the image as a PNG file
        try {
            File output = new File(filename + ".png");
            ImageIO.write(image, "png", output);
        } catch (Exception e) {
            System.out.println("Error creating image: " + e.getMessage());
        }
    }
    /**
     * assign given coordiantes 
     * @param line will be splitted and assigned to the x and y values
     * @return coordinates' list
     */
    private List<Integer> assignCoordinates(String line) {
        List<Integer> coordinates = new ArrayList<>();
        String[] parts = line.split(",");
        for (String part : parts) coordinates.add(Integer.parseInt(part));
        return coordinates;
    }
    /**
     * Draws a line on an image to represent a given path.
     *
     * @param path The list of nodes representing the path.
     */
    public void drawLine(List<Node> path) {
        try {
            BufferedImage image = ImageIO.read(new File(filename + ".png"));
            Graphics2D graphic = image.createGraphics();
            graphic.setColor(Color.RED);
            for (int y = 0; y < X_SIZE; y++) {
                for (int x = 0; x < Y_SIZE; x++) 
                    if (isInPathArray(x, y, path)) 
                        graphic.fillRect(y, x, 1, 1);
            }
            graphic.dispose();
            ImageIO.write(image, "png", new File(filename + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * check if the node in the given coordinates is in the path list.
     * 
     * @param x x coordinate of the node
     * @param y y coordinate of the node
     * @param path path list
     * @return boolean
     */
    private boolean isInPathArray(int x, int y, List<Node> path) {
        for (Node node : path) 
            if (node.x == x && node.y == y) 
                return true; 
        return false; 
    }
    /**
     * Writes the shortest path to a file.
     *
     * @param shortestPath The list of nodes representing the shortest path.
     */
    public void writePath(List<Node> shortestPath, String file) {
        try (FileWriter writer = new FileWriter(filename + "_" + file + ".txt")) {
            for (Node node : shortestPath) 
                writer.write(node.x + "," + node.y + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
