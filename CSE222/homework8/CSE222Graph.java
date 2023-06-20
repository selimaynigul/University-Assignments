import java.util.ArrayList;
import java.util.List;
/**
 * Construct a graph structure using giving matrix
 */
public class CSE222Graph {
    private List<Node>[][] edges;
    private Node[][] nodes;
    private CSE222Map map;
    /**
     * Constructor method to assign given map object, and creating a 
     * graph structure from it.
     * 
     * @param map will be converted to graph structure.
     */
    public CSE222Graph(CSE222Map map) {
        this.map = map;
        nodes = new Node[map.X_SIZE][map.Y_SIZE];
        edges = new ArrayList[map.X_SIZE][map.Y_SIZE];
        for (int i = 0; i < map.X_SIZE; i++) {
            for (int j = 0; j < map.Y_SIZE; j++) {
                edges[i][j] = new ArrayList<Node>();
            }
        }
        constructGraph(map.getMap());
    }
    // getters
    public Node[][] getNodes() { return nodes; }
    public List<Node>[][] getEdges() { return edges; }
    public CSE222Map getMap() { return map; }
    /**
     * Create a graph structure from given matrix.
     * @param matrix will be converted to graph structure.
     */
    public void constructGraph(List<List<Integer>> matrix) {
        int n = map.getMap().size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == 0) {
                    Node node = new Node(i, j);
                    addNode(node);
                    if (i > 0 && j > 0 && matrix.get(i-1).get(j-1) == 0) 
                        edges[i][j].add(getNodeByPosition(i-1, j-1));
                    if (i > 0 && matrix.get(i-1).get(j) == 0) 
                        edges[i][j].add(getNodeByPosition(i-1, j));
                    if (i > 0 && j < n - 1 && matrix.get(i-1).get(j+1) == 0) 
                        edges[i][j].add(getNodeByPosition(i-1, j+1));
                    if (j > 0 && matrix.get(i).get(j - 1) == 0) 
                        edges[i][j].add(getNodeByPosition(i, j-1));
                    if (j < n - 1 && matrix.get(i).get(j+1) == 0) 
                        addEdge(getNodeByPosition(i, j), i, j+1);
                    if (i < n - 1 && j > 0 && matrix.get(i+1).get(j-1) == 0) 
                        addEdge(getNodeByPosition(i, j), i+1, j-1);
                    if (i < n - 1 && matrix.get(i+1).get(j) == 0) 
                        addEdge(getNodeByPosition(i, j), i+1, j);
                    if (i < n - 1 && j < n - 1 && matrix.get(i+1).get(j+1) == 0) 
                        addEdge(getNodeByPosition(i, j), i+1, j+1);   
                }
            }
        }
    }
    /**
     * get node in the selected corrdinate
     * @param x x coordinate  
     * @param y y coordinate
     * @return node in the given coordinate, if not exits return null
     */
    public Node getNodeByPosition(int x, int y) {
        return nodes[x][y] == null ? null : nodes[x][y];
    }
    /**
     * add new edge to edges list
     * @param source source node
     * @param x x coordinate of the destination node
     * @param y y coordinate of the destination node
     */
    public void addEdge(Node source, int x, int y) {
        addNode(new Node(x, y));
        edges[source.x][source.y].add(nodes[x][y]);
    }
    /**
     * add new node to the nodes list
     * @param node will be added.
     */
    public void addNode(Node node) {
        if(nodes[node.x][node.y] == null) 
            nodes[node.x][node.y] = node;
    }

}

    
   
    
    
    



