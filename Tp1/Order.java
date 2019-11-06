package Tp1;

import java.util.LinkedList;

import static Tp1.objetType.*;

public class Order {

    private int A_;
    private int B_;
    private int C_;
    private int distance = Integer.MAX_VALUE; //distance nécéssaire pour parcourire (aller seulement)


    public String getRobotChoice(){
        int weight = totalWeight();
        if(weight <= RobotX.MAX_KILO_) return "X";
        if(weight <= RobotY.MAX_KILO_) return "Y";
        if(weight <= RobotZ.MAX_KILO_) return "Z";
        else return "La commande est trop lourde, veuillez la diviser en plusieurs petites commandes\n";
    }

    public int getTotalObjet(){
        return A_ + B_ + C_;
    }


     int totalWeight(){
       return new Objet(A).getWeight() * A_ + new Objet(C).getWeight() * C_ + new Objet(B).getWeight() * B_;
    }

     int getA_(){
        return A_;
    }

     int getB_(){
        return B_;
    }

     int getC_(){
        return C_;
    }

    int getDistance(){return distance;}

    Order(int a, int b, int c){
        A_ = a;
        B_ = b;
        C_ = c;
    }


     void afficherCommande(){

        System.out.println("Nombre d'objets A : "+ A_);
        System.out.println("Nombre d'objets B : "+ B_);
        System.out.println("Nombre d'objets C : "+ C_);
    }
    public NodeList chemin(DjikstraTable[] in){
        return chemin(in, new boolean[in.length]);
    }
    /** TODO : complete
     * @param in djikstra table of finished algortihm
     * @return the nodes in order (aller - retour)
     *
     */
    private NodeList chemin(DjikstraTable[] in,boolean[] indexes){
        int a = A_;
        int b = B_;
        int c = C_;
        int dist =0;
        int pickups =0;
        NodeList retval = new NodeList();
        retval.add(in[0].getNode());
        LinkedList<GraphEdge> edges = in[0].getPreviousNode().getEdges();
        indexes[0] = true;
        while(((a >0) || (b >0) || (c>0)) && dist < distance){
            /*fait ton code la*/
            int edgeCounter =0;
            //ce chemin n'a pas ete essayer
            if(indexes[edges.get(edgeCounter).getNode().getId()]){
                ++edgeCounter;
            }
            //give up if all have been visited
            if(edgeCounter >= edges.size()){
                break;
            }
            retval.add(edges.get(edgeCounter).getNode());
            edges = retval.getLast().getEdges();
            //take as much as you need or as much as available
            if(a>retval.getLast().getQtty(A)) {
                a -= retval.getLast().getQtty(A);
            }
            else if(a != 0){
                a=0 ;
            }

            if(b>retval.getLast().getQtty(B)) {
                b -= retval.getLast().getQtty(B);
            }
            else if(b != 0){
                b=0 ;
            }
            if(c>retval.getLast().getQtty(C))
                c -= retval.getLast().getQtty(C);
            else if(c != 0){
                c=0 ;
            }

        }
        if(dist<distance && a==0 && c== 0 && b==0) {
            distance=dist;
            return retval;
        }
        return chemin(in,indexes);
    }



    double tempsTotal(){
        int tempsTotal=0;
        tempsTotal += (getRobotChoice() == "X") ? new RobotX().computeK():
                (getRobotChoice() == "Y") ? new RobotY().computeK(): new RobotZ().computeK();
        tempsTotal = tempsTotal * distance * 2;
        tempsTotal+=(10*getTotalObjet());

        return tempsTotal;

    }


}