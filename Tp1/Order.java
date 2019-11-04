package Tp1;

import static Tp1.objetType.*;
import static Tp1.robotType.*;

public class Order {

    private int A_;
    private int B_;
    private int C_;
    private string typeOfRobot_;

    public int TotalWeight(){
        int totalWeight=0;
        Objet objetA = new Objet(A);
        Objet objetB = new Objet(B);
        Objet objetC = new Objet(C);
        totalWeight+=A_*(objetA.getWeight())+B_*(objetB.getWeight())+C_*(objetC.getWeight());
        if (totalWeight)
        return totalWeight;
    }

    Order(int a, int b, int c){
        A_ = a;
        B_ = b;
        C_ = c;
        TotalWeight();
    }

    int getNbObjetA(){
        return A_;
   }
    int getNbObjetB(){
        return B_;
   }
    int getNbObjetC(){
        return C_;
   }

    void afficherCommande(){

        System.out.println("Nombre d'objets A : "+ getNbObjetA());
        System.out.println("Nombre d'objets B : "+ getNbObjetB());
        System.out.println("Nombre d'objets C : "+ getNbObjetC());
    }



}