package Tp1;

import java.util.LinkedList;


public class NodeList extends LinkedList<GraphNode> {
    NodeList(){super();}
    boolean isEqual(NodeList n){
        if(this.size() != n.size()) return false;
        boolean ret = true;
        for(int i =0;i<n.size();++i){
            if(!get(i).isEqual(n.get(i))) ret = false;
        }
        return ret;
    }

    public String nodetoString(GraphNode node){
        String text="(";
        text+="Noeud"+node.getId()+", "+node.getObjetA()+", "+node.getObjetB()
                    +", "+node.getObjetC()+"( ";

        for(GraphEdge edges:node.getEdges()){
            text+= "( "+edges.getNode()+", "+edges.getDistance()+"), ";

        }
        text+="))";
        return text;
    }

    public void afficherGraphe(){
        for(GraphNode node:this) {
            System.out.println(nodetoString(node));
        }
    }



}
