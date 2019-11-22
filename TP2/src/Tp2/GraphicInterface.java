package Tp2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicInterface extends JFrame {
    public GraphicInterface() {
        super("TP4");
        JLabel welcome = new JLabel("Bienvenue au Tp2 de Log2410");
        setLayout(new GridLayout(5,1));
        JButton init = new JButton("Initialiser le programme");
        init.addActionListener(new InitListener());
        JButton research = new JButton("Rechercher un élément");
        research.addActionListener(new researchListener());
        JButton showCart = new JButton("Afficher le panier");
        showCart.addActionListener(new CartListener());
        JButton close = new JButton("Fermer la session");
        close.addActionListener(new closeListener());
        welcome.setVisible(true);
        add(welcome);
        add(init);
        add(research);
        add(showCart);
        add(close);
        setSize(300, 400);
        setVisible(true);//making the frame visible
    }

    private class researchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            /*
             * TODO
             * */
        }
    }

    private class InitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            /*
             * TODO
             * */
        }
    }

    private class CartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            /*
             * TODO
             * */
        }
    }

    private class closeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            /*
             * TODO
             * */
        }
    }
}
