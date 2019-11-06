package Tp1;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;


public class GraphNode{
    private int id;
    private int objetA;
    private int objetB;
    private int objetC;


    private LinkedList<GraphEdge> edges;

    GraphNode(int id, int a , int b, int c){

        edges = new LinkedList<>();
        this.id = id;
        objetA =a;
        objetB =b;
        objetC =c;

    }



    public int getId(){
        return id;
    }

    /**
     * @param objet type of object
     * @return number of objet still in the node
     */
    public int getQtty(objetType objet){
        switch (objet) {
            case A: return objetA;
            case B: return objetB;
            case C: return objetC;
            default: return 0;
        }
    }
    private boolean remove(objetType objet){
        switch (objet) {
            case A:
                if (objetA != 0 ) {
                    objetA--;

                    return true;
                }
                else return false;
            case B:
                if (objetB != 0 ) {
                    objetB--;

                    return true;
                }
                else return false;
            case C:
                if (objetC != 0 ) {
                    objetC--;

                    return true;
                }
                else return false;
            default:
                return false;
        }
    }

    /**
     * @param objet type of objet you wanna remove
     * @param occurence number of objects you wnna remove
     * @return true if all removal succeeds
     * */
    boolean remove(objetType objet, int occurence){
        if(occurence <= 0 ) return false;
        if(occurence > getQtty(objet)) return false;
        while(occurence != 0){
            remove(objet);
            --occurence;
        }
        return true;
    }



    LinkedList<GraphEdge> getEdges(){
        return edges;
    }

    public void addEdge(GraphEdge edge){
        edges.add(edge);
    }

    public boolean isEqual(GraphNode node){
        if(edges.size()==node.edges.size()) {
            for(int i =0; i<edges.size();++i){
                if(!edges.get(i).isEqual(node.edges.get(i))) return false;
            }
        }
        return (id == node.id && objetA == node.objetA && objetB == node.objetB && objetC==node.objetC
                && getNbObjetTotal()==node.getNbObjetTotal()
                && edges.size()==node.edges.size());
    }

    private int getNbObjetTotal() {
        return objetA + objetB + objetC;
    }
    GraphEdge getClosestEdge(){
        int minDistance = Integer.MAX_VALUE;
        GraphEdge minEdge=null;
        for(GraphEdge edge : edges){
            if(edge.getDistance()<minDistance) minDistance = edge.getDistance();
            minEdge = edge;
        }
        return minEdge;
    }
    GraphEdge getRandomEdge(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, edges.size() );
        return edges.get(randomNum);
    }
}
