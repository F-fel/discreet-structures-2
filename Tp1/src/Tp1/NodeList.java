package Tp1;

import java.util.LinkedList;

public class NodeList extends LinkedList<GraphNode> {
    NodeList(){super();}
    GraphNode getById(int id){
        for(GraphNode node : this){
            if (node.getId()==id) return node;
        }
        return null;
    }

}
