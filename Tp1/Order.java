package Tp1;

class Order {

    private int A_;
    private int B_;
    private int C_;

    int TotalWeight(){
        return A_ + (3* B_ )+ (6 * C_);
    }

    Order(int a, int b, int c){
        A_ = a;
        B_ = b;
        C_ = c;
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