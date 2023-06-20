import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CSE222Dijkstra {
    private CSE222Graph graph;
    public int length;
    private int[][] distance;
    private Node[][] prev;
    /**
     * constructor method to assign graph object
     * @param graph will be assigned as new graph
     */
    public CSE222Dijkstra(CSE222Graph graph) {
         this.graph = graph;
        int size = graph.getNodes().length;
        distance = new int[size][size];
        prev = new Node[size][size];
    }
    /**
     * Find shortest feasible path between starting and ending nodes on the graph
     * using Djikstra algorithm.
     * 
     * @return shortest path
     */
    public List<Node> findPath() {
        // get start and end nodes' coordinates
        int startX = graph.getMap().getStart().get(0);
        int startY = graph.getMap().getStart().get(1);
        int endX = graph.getMap().getEnd().get(0);
        int endY = graph.getMap().getEnd().get(1);
        // get start and end nodes
        Node source = graph.getNodeByPosition(startX, startY);
        Node dest =  graph.getNodeByPosition(endX, endY);
        // Initialize distances to infinity except for the source node
        for (int i = 0; i < graph.getNodes().length; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
        distance[source.x][source.y] = 0;
        // Create a priority queue to store the nodes
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> distance[n1.x][n1.y] - distance[n2.x][n2.y]);
        queue.offer(source);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr == dest) break;
            for (Node neighbor : graph.getEdges()[curr.x][curr.y]) {
                // Assuming all edges have weight 1
                int newDistance = distance[curr.x][curr.y] + 1; 
                if (newDistance < distance[neighbor.x][neighbor.y]) {
                    distance[neighbor.x][neighbor.y] = newDistance;
                    prev[neighbor.x][neighbor.y] = curr;
                    queue.offer(neighbor);
                }
            }
        }
        List<Node> path = new ArrayList<>();
        Node curr = dest;
        // fill the shortest path
        while (curr != null) {
            path.add(0, curr);
            curr = prev[curr.x][curr.y];
        }
        // assign length
        length = path.size() - 1;
        if(length == -1) {
            System.out.println("No feasible path found!");
            length = 0;
        }
        return path;
    }    
}
