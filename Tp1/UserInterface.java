package Tp1;

import java.net.URL;
import java.util.Scanner;

class UserInterface {
    private NodeList graph;
    private Order commande ;
    private void start(){
        System.out.print("Bienvenue au TP1 du cours log 2810 qui vous est présenté par Farid, Luca et Arthur.\n");
    }
    private void showOptions(){
        System.out.print("Veuillez choisir une des 6 options suivante: \n" +
                "1 : créer le graph\n" +
                "2 : Afficher le graph\n" +
                "3 : Prendre une commande\n" +
                "4 : Afficher votre commande\n" +
                "5 : Afficher le plus cour chemin\n" +
                "6 : Quitter\n");
    }

    void run(){
        start();
        showOptions();
        Scanner in = new Scanner(System.in);
        while(true) {
            int i = in.nextInt();
            if(i==1) creerGraph();
            else if(i==2) afficherGraph();
            else if(i==3) prendreCommande();
            else if(i==4) afficherCommande();
            else if(i==5) plusCourtChemin();
            else if(i==6) return;
            else def();
            }
        }

    private void def(){
        System.out.print("L'option séléctioner est invalide.\n");
        showOptions();
    }
    private void creerGraph() {
        Scanner in = new Scanner(System.in);
        URL path = GraphNode.class.getResource("Tp1/entrepot.txt");
        String file = "C:\\Users\\faelfa\\IdeaProjects\\Log2810_tp1\\src\\Tp1\\entrepot.txt";
        EntrepotReader er = new EntrepotReader();
        while (true) {
            try {
                graph=er.creerGraph();
                break;
            } catch (Exception e) {
                System.out.print("Le chemin pour le fichier txt n'est pas valid.\n SVP entrer un chemin valid : \n");
                file = in.nextLine();
            }
        }
        System.out.println("\n\n");
        showOptions();
    }
    private void afficherGraph(){
        graph.afficherGraphe();
        System.out.println("\n\n");
        showOptions();
    }
    private void prendreCommande(){
        Scanner in = new Scanner(System.in);
        System.out.print("Veuillez saisir le nombre d'objet <A> désiré : \n");
        int a = in.nextInt();
        System.out.print("Veuillez saisir le nombre d'objet <B> désiré : \n");
        int b = in.nextInt();
        System.out.print("Veuillez saisir le nombre d'objet <C> désiré : \n");
        int c = in.nextInt();
        commande = new Order(a,b,c);
        System.out.println("\n\n");
        showOptions();
    }
    private void afficherCommande(){
        commande.afficherCommande();
        showOptions();
    }

    private void plusCourtChemin() {

        Djikstra dj = new Djikstra();
        String actions = commande.chemin(dj.algorithm(graph,0));
        System.out.println("un robot de type "+commande.getRobotChoice() + " est designe");
        System.out.println("le robot parcours une distance de "+ commande.getDistance()+" metres");
        System.out.println("le temps total a effectuer pour le robot est de " + commande.tempsTotal());
        System.out.println("le chemin parcourut par le robot est :");
        actions = actions.replaceAll("(.{180})", "$1\n");
        System.out.println(actions);
        showOptions();
    }


}
