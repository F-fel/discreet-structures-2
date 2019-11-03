package Tp1;

public class Order {

    private int A_;
    private int B_;
    private int C_;

    int TotalWeight(Objet objet){
        int totalWeight=0;

        return totalWeight;
    }

    Order(int A, int B, int C){
        A_ = A;
        B_ = B;
        C_ = C;
    }

   public int getNbObjetA(){
        return A_;
   }
   public int getNbObjetB(){
        return B_;
   }
   public int getNbObjetC(){
        return C_;
   }

    public void afficherCommande(){

        System.out.println("Nombre d'objets A : "+ getNbObjetA());
        System.out.println("Nombre d'objets B : "+ getNbObjetB());
        System.out.println("Nombre d'objets C : "+ getNbObjetC());
    }



}