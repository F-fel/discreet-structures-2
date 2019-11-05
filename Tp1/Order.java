package Tp1;

import static Tp1.objetType.*;

public class Order {

    private int A_;
    private int B_;
    private int C_;
    private int distance; //distance nécéssaire pour parcourire


    public String getRobotChoice(){
        int weight = totalWeight();
        if(weight <= RobotX.MAX_KILO_) return "le robot choisi pour cette commande est le RobotX";
        if(weight <= RobotY.MAX_KILO_) return "le robot choisi pour cette commande est le RobotY";
        if(weight <= RobotZ.MAX_KILO_) return "le robot choisi pour cette commande est le RobotZ";
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

    /** TODO : complete
     * @param in djikstra table of finished algortihm
     * @return the nodes in order (aller - retour)
     *
     */
    NodeList chemin(DjikstraTable[] in,boolean[] indexes){
        int dist =0;
        Djikstra dj = new Djikstra();
        while(dist<distance) {
            int index = dj.findMin(in, indexes);
            indexes[index] = true;
            GraphNode node = in[index].getPreviousNode();
            for(GraphEdge edge : node.getEdges()){

            }
        }

        return null;
    }


}