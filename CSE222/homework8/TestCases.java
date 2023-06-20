import java.util.List;
public class TestCases implements Runnable {
    private  String FileName;
    private int X_SIZE;
    private int Y_SIZE;

    public TestCases(String FileName, int X_SIZE, int Y_SIZE) {
        this.FileName = FileName;
        this.X_SIZE = X_SIZE;
    	this.Y_SIZE = Y_SIZE;
    }

    public void test(){  
        System.out.println("Map is " + this.FileName + " with X_SIZE " + this.X_SIZE + " and Y_SIZE " + this.Y_SIZE);
        CSE222Map Map = new CSE222Map (this.FileName, this.X_SIZE, this.Y_SIZE);
        CSE222Graph Graph = new CSE222Graph (Map);
        CSE222Dijkstra Dijkstra = new CSE222Dijkstra (Graph);
        List<Node> DijkstraPath = Dijkstra.findPath();
        CSE222BFS BFS= new CSE222BFS (Graph);
        List<Node> BFSPath = BFS.findPath();
        Map.convertPNG();
        Map.drawLine(DijkstraPath);
        Map.drawLine(BFSPath);
        Map.writePath(BFSPath, "BFSPath");
        Map.writePath(DijkstraPath, "DjikstraPath");
        System.out.println(FileName + " Dijkstra Path: "+ Dijkstra.length);
        System.out.println(FileName +" BFS Path: " + BFS.length);
    }

    @Override
    public void run() {
        test();
    }
}

