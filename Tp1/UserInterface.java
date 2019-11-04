package Tp1;

import java.io.IOException;
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
                "6 : Quitter");
    }

    public  void run(){
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
                    break;
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
        URL path = GraphNode.class.getResource("entrepot.txt");
        String file = path.getFile();
        EntrepotReader er = new EntrepotReader();
        while (true) {
            try {
                graph=er.creerGraph(file);
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

}
