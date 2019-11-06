package Tp1;

import java.util.LinkedList;

import static Tp1.objetType.*;

public class Order {

    private int A_;
    private int B_;
    private int C_;
    private int distance = 0; //distance nécéssaire pour parcourire (aller seulement)


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
    String chemin(DjikstraTable[] in){
        int a = A_;
        int b = B_;
        int c = C_;
        int dist =0;
        int pickups =0;
        NodeList retval = new NodeList();
        retval.add(in[0].getNode());
        StringBuilder sb = new StringBuilder();
        sb.append(retval.getLast().getId()).append(" --> ");
        while((a >0) || (b >0) || (c>0)) {
            GraphEdge edge = retval.getLast().getClosestEdge();
            retval.add(edge.getNode());
            sb.append(retval.getLast().getId()).append(" --> ");
            distance += edge.getDistance();
            int availableA = edge.getNode().getQtty(A);
            if(a>availableA){
                edge.getNode().remove(A,availableA);
                a = a -availableA;
                if (availableA != 0) {
                    sb.append("le robot prend " + availableA + " objet(s) A");
                    sb.append(" --> ");
                }
            }else if(a!=0){


                edge.getNode().remove(A,a);
                sb.append("le robot prend "+a+ " objet(s) A");
                sb.append(" --> ");
                a=0;
            }
            int availableB = edge.getNode().getQtty(B);
            if(b>availableB){
                edge.getNode().remove(B,availableB);
                if(availableB!=0) {
                    sb.append("le robot prend " + availableB + " objet(s) B");
                    sb.append(" --> ");
                }
                b = b -availableB;
            }else if(b!=0){
                sb.append("le robot prend "+b+ " objet(s) B");
                sb.append(" --> ");
                b=0;
                edge.getNode().remove(B,b);
            }
            int availableC = edge.getNode().getQtty(C);
            if(c>availableC){
                edge.getNode().remove(C,availableC);
                if(availableC!=0) {
                    sb.append("le robot prend " + availableC + " objet(s) C");
                    sb.append(" --> ");
                }
                c = c -availableC;
            }else if(c!=0){
                sb.append("le robot prend "+c+ " objet(s) C");
                sb.append(" --> ");
                c=0;
                edge.getNode().remove(C,c);
            }
        }
        for(int i = retval.size() -1 ;i>=0;--i){
            sb.append(retval.getLast().getId()).append(" ---> ");
        }
        sb.append("FIN");
        return sb.toString();
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