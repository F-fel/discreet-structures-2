package Tp2;
import javax.swing.*;
public class GraphicInterface {
    public void run() {
        JLabel intro = new JLabel("Bienvenu au TP2!",SwingConstants.CENTER);
        JFrame f = new JFrame();//creating instance of JFrame
        JButton init = new JButton("Initialiser le programme");
        JButton research = new JButton("Rechercher un élément");
        JButton showCart = new JButton("Afficher le panier");
        JButton close = new JButton("Fermer la session");
        init.setBounds(100,150 , 300, 40);//x axis, y axis, width, height
        research.setBounds(100,250,300,40);
        showCart.setBounds(100,350,300,40);
        close.setBounds(100,450,300,40);
        f.add(init);
        f.add(research);
        f.add(showCart);
        f.add(close);
        f.add(intro);
        f.setSize(500, 800);
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
    }

}
