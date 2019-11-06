package Tp1;

import static Tp1.objetType.*;

public class Order {

    private int A_;
    private int B_;
    private int C_;
    private int distance = Integer.MAX_VALUE; //distance nécéssaire pour parcourire


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

    /** TODO : complete
     * @param in djikstra table of finished algortihm
     * @return the nodes in order (aller - retour)
     *
     */
    NodeList chemin(DjikstraTable[] in){
        int a = 0;
        int b = 0;
        int c = 0;
        int dist =0;
        NodeList retval = new NodeList();
        while(((a < A_) || (b < B_) || (c<C_)) && dist < distance){
            /*fait ton code la*/
        }
        return retval;
    }



    double tempsTotal(){
        int tempsTotal=0;
        tempsTotal += (getRobotChoice() == "X") ? new RobotX().computeK():
                (getRobotChoice() == "Y") ? new RobotY().computeK(): new RobotZ().computeK();
        tempsTotal = tempsTotal * distance;
        tempsTotal+=(10*getTotalObjet());

        return tempsTotal;

    }


}