package Tp1;

import static Tp1.objetType.*;

public class Order {

    private int A_;
    private int B_;
    private int C_;
    private int distance; //distance nécéssaire pour parcourire


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


    public void afficherParcours(){
        //affichage voulu
        //pointdepart->point1->point2->collecting A-> pointn->pointarrive
        String text= "pointDepart->";
        for(GraphNode node:this) {
            text+="point"+node.getId()+"->";//node parcouru
            //objet recuperer

        }
        text+="pointArrivee";
        System.out.println(text);
        System.out.println("robot utilise : Type "+ getRobotChoice());
        System.out.println("temps: "+ tempsTotal());
        System.out.println("distance: "+ distanceTotal());


    }

    private double tempsTotal(){// A FAIRE
        int tempsTotal=0;
        //formule temps=robot.computeK()*distanceTotal();

        //il y a un cout de 10 secondes  pour prendre un objet a chaque fois
        tempsTotal+=(10*getTotalObjet());

        return tempsTotal;

    }

    private double distanceTotal(){ //A FAIRE
        int distanceTotal_=0;
        //additioner toute les distances entre les nodes du parcours


        //faire cette disctance *2 pour aller retour
        distanceTotal_*=2;

        return distanceTotal_;
    }

    private void plusCourtChemin(NodeList graph,int src, Order order){

        //Dijkstra
        //DjikstraTable[] djikstraTables=algorithm (graph,src);


        //afficher robot utilise , afficher temps total et distance et commande

        System.out.println("objet A: "+ order.getA_()+", objet B: "+ order.getB_()+", objet C: "+ order.getC_());
        System.out.println(order.getRobotChoice());
        System.out.println("le robot parcours une distance de "+ distanceTotal()+" metres");
        System.out.println("le temps total a effectuer pour le robot est de ");//+ tempsTotal()); //manque parametre pour fonction

        //afficher liste des noeuds traverse



        //afficher les objets prient dans les noeuds


    }







}