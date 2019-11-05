package Tp1;

class GraphEdge {
    private GraphNode node;
    private int distance;
    GraphEdge(GraphNode node_ ,int dist){
        node = node_;
        distance = dist;
    }

    GraphNode getNode() { return node; }

    int getDistance() { return distance; }

    boolean isEqual(GraphEdge obj) {
        return (node.getId() == obj.node.getId() && distance==obj.distance);
    }
}
