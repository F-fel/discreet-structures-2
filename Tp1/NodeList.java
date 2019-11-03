package Tp1;

import java.util.LinkedList;

import static Tp1.objetType.*;

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

    public String toString(){
        String text="(";
        for(GraphNode node : this) {
            text+="Noeud"+node.getId()+", "+node.getQtty(A)+", "+node.getQtty(B)
                    +", "+node.getQtty(C)+"( ";
        }
        text+="))";
        return text;
    }

}
