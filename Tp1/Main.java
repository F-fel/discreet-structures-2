package Tp1;


public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        Tester test = new Tester();
        if(test.nodeTest()) System.out.println( "READNODE WORKS");
        else System.out.println("eww");
        if(test.djikstraTester()) System.out.println("DJIKSTRA WORKS");
    }

}
