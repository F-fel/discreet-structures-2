package Tp1;

import java.net.URL;
import java.util.Scanner;

public class UserInterface {
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

    public  void run(){
        start();
        showOptions();
        Scanner in = new Scanner(System.in);
        while(true) {
            switch (in.nextInt()) {
                case 1:
                    creerGraph();
                case 2:
                    afficherGraph();
                case 3:
                    prendreCommande();
                case 4:
                    afficherCommande();
                case 6:
                    return;
                default:
                    def();
            }
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
    }
    private void afficherGraph(){
        System.out.println( graph.toString());
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
    }
    private void afficherCommande(){
        commande.afficherCommande();
    }

    /**
     * todo
     */
    private void plusCourtChemin() {
        Djikstra dj;
        String print = "le chemin optimal est : \n" ;
        for(GraphNode node : commande.chemin()){
            print = print + Integer(node.getId()).toString() + " --> ";
        }
        System.out.print(print);
    }
}
