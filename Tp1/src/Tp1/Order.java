package Tp1;

public class Order {

    int TotalWeight(Objet objet){
        int totalWeight=0;

        //blabla bla


        return totalWeight;

    }

    public int prendreCommande(int A, int B, int C){

        int commande [] = new int[3];

        commande[0] = A;
        commande[1] = B;
        commande[2] = C;

        return commande;

    }

    public void afficherCommande(int [] commande){

        System.out.println("Nombre d'objets A : "+ commande[0]);
        System.out.println("Nombre d'objets B : "+ commande[1]);
        System.out.println("Nombre d'objets C : "+ commande[2]);
    }


    Time(Objet objet){
        int k=0;

        if(RobotX){
            k=1+TotalWeight(objet); //mettre variable robot
        }
        else if (RobotY){
            k=1.5+0.6*TotalWeight(objet); //mettre variable robot
        }
        else if (RobotZ){
            k=2.5+0.2*TotalWeight(objet); //mettre variable robot
        }
        int t=k*
    }


}