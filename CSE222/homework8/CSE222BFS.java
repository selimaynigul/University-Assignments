import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
/**
 * Find shortes path and it's length on the given graph object
 */
public class CSE222BFS {
    private CSE222Graph graph;
    protected int length;
    /**
     * constructor method to assign graph object
     * @param graph will be assigned as new graph
     */
    public CSE222BFS(CSE222Graph graph) {
        this.graph = graph;
    }
    /**
     * Find shortest feasible path between starting and ending nodes on the graph
     * using BFS traversal.
     * 
     * @return shortest path
     */
    public List<Node> findPath() {
        int startX = graph.getMap().getStart().get(0);
        int startY = graph.getMap().getStart().get(1);
        int endX = graph.getMap().getEnd().get(0);
        int endY = graph.getMap().getEnd().get(1);
    
        Node start = graph.getNodeByPosition(startX, startY);
        Node end = graph.getNodeByPosition(endX, endY);
    
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> visited = new HashMap<>();
    
        queue.add(start);
        visited.put(start, null);  

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
    
            if (curr == end) break;
    
            for (Node neighbor : graph.getEdges()[curr.x][curr.y]) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, curr);
                    queue.add(neighbor);
                }
            }
        }
        List<Node> path = new ArrayList<>();
        if (!visited.containsKey(end))
            System.out.println("No feasible path found!");
        else {
            Node curr = end;
            while (curr != null) {
                path.add(0, curr);
                curr = visited.get(curr);
            }
        }
        length = path.size() - 1;
        return path;
    }
    
}
