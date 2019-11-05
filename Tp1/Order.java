package Tp1;

import static Tp1.objetType.*;
import static Tp1.robotType.*;

public class Order {

    private int A_;
    private int B_;
    private int C_;
    private String robotChoose_;
    private int totalWeight_=0;
    private boolean impossible=false;

    Objet objetA = new Objet(A);
    Objet objetB = new Objet(B);
    Objet objetC = new Objet(C);
    RobotX robotX = new RobotX();
    RobotY robotY = new RobotY();
    RobotZ robotZ = new RobotZ();


    public String getRobotChoose_(){
        return robotChoose_;
    }

    public boolean getImpossible(){
        return impossible;
    }

    public int getTotalWeight_(){
        return totalWeight_;
    }

    public int getA_(){
        return A_;
    }

    public int getB_(){
        return B_;
    }

    public int getC_(){
        return C_;
    }

    public int totalWeight(){
        totalWeight_+=A_*(objetA.getWeight())+B_*(objetB.getWeight())+C_*(objetC.getWeight());

        if (totalWeight_<=robotX.getMAX_KILO()){
            robotChoose_="X";
        }
        else if (totalWeight_<=robotY.getMAX_KILO()){
            robotChoose_="Y";
        }
        else if (totalWeight_<=robotZ.getMAX_KILO()){
            robotChoose_="Z";
        }
        else if (totalWeight_>robotZ.getMAX_KILO()){
            impossible=true;
        }
        return totalWeight_;
    }

    Order(int a, int b, int c){
        A_ = a;
        B_ = b;
        C_ = c;
        totalWeight();
    }


    public void afficherCommande(){

        System.out.println("Nombre d'objets A : "+ A_);
        System.out.println("Nombre d'objets B : "+ B_);
        System.out.println("Nombre d'objets C : "+ C_);
    }



}