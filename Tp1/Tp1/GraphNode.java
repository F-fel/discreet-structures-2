package Tp1;

import java.util.LinkedList;

import static Tp1.objetType.*;


public class GraphNode{
    private int id;
    private int objetA;
    private int objetB;
    private int objetC;

    private int objetAVoulu;
    private int objetBVoulu;
    private int objetCVoulu;

    private int nbObjetTotal;
    private LinkedList<GraphEdge> edges;

    GraphNode(int id, int a , int b, int c){

        edges = new LinkedList<>();
        this.id = id;
        nbObjetTotal=a+b+c;
        objetA =a;
        objetB =b;
        objetC =c;

        objetAVoulu=0;
        objetBVoulu=0;
        objetCVoulu=0;

    }

    public int getObjetAVoulu(){
        return objetAVoulu;
    }

    public int getObjetBVoulu(){
        return objetBVoulu;
    }

    public int getObjetCVoulu(){
        return objetCVoulu;
    }

    public int getNbObjetTotal(){
        return nbObjetTotal;
    }

    public int getObjetA(){
        return objetA;
    }

    public int getObjetB(){
        return objetB;
    }

    public int getObjetC(){
        return objetC;
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
                    nbObjetTotal--;

                    return true;
                }
                else return false;
            case B:
                if (objetB != 0 ) {
                    objetB--;
                    nbObjetTotal--;

                    return true;
                }
                else return false;
            case C:
                if (objetC != 0 ) {
                    objetC--;
                    nbObjetTotal--;

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
                && nbObjetTotal==node.getNbObjetTotal()
                && edges.size()==node.edges.size());
    }
}
