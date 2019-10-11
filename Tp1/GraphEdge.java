package Tp1;

public class GraphEdge {
    private GraphNode firstNode;
    private GraphNode secondNode;
    private int distance;
    GraphEdge(GraphNode first, GraphNode second, int dist){
        firstNode = first;
        secondNode = second;
        distance = dist;
    }
    public GraphNode getFirstNode() {
        return firstNode;
    }

    public GraphNode getSecondNode() {
        return secondNode;
    }

    public int getDistance() {
        return distance;
    }
}
