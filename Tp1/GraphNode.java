package Tp1;

public class GraphNode{
    private int id;
    private int objetA;
    private int objetB;
    private int objetC;

    GraphNode(int id, int A, int B, int C){
        this.id = id;
        objetA = A;
        objetB = B;
        objetC = C;
    }

    public int getA(){return objetA;}
    public int getB(){return objetB;}
    public int getC(){return objetC;}
    void remove(objetType objet){
        switch (objet) {
            case A:
                objetA--;
            case B:
                objetB--;
            case C:
                objetB--;
            default:
        }
    }

}
