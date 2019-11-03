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

    public String toString(){
        string text="(";
        for(int i=0; i<GraphNode.size(); i++)
        {
            text+="Noeud"+i+", "+GraphNode.getQtty(objetA)+", "+GraphNode.getQtty(objetB)
                    +", "+GraphNode.getQtty(objetC)+"( "

           for(int j=0;j<)
        }
        text+="))";
    }

}
