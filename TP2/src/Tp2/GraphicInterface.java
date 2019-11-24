package Tp2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GraphicInterface extends JFrame {
    private Entrepot entrepot;
    private Entrepot panier;
    private JPanel mainPanel;
    JLabel welcome;
    JButton back;
    public GraphicInterface() {
        super("TP4");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        entrepot  =new Entrepot();
        panier = new Entrepot();

        //main screen buttons and label
        JButton init = new JButton("Initialiser le programme");
        init.setPreferredSize(new Dimension(40,100));
        JButton research = new JButton("Rechercher un élément");
        JButton gotoCart = new JButton("allez au panier");
        JButton close = new JButton("Fermer la session");
        back = new JButton("retourner a l'ecran principale");//not added to main screen just initialised
        welcome = new JLabel("Bienvenue au Tp2 de Log2410");
        //give each button an action
        setLayout(new GridLayout(5,1));
        init.addActionListener(new InitListener());
        research.addActionListener(new researchListener());
        gotoCart.addActionListener(new CartListener());
        close.addActionListener(new closeListener());
        welcome.setVisible(true); //make the label visible

        mainPanel = new JPanel(new GridLayout(4,1)) ; //5rows 1 column

        //add to panel/frame
        add(welcome);
        mainPanel.add(init);
        mainPanel.add(research);
        mainPanel.add( gotoCart);
        mainPanel.add(close);
        mainPanel.setSize(250,350);
        add(mainPanel);
        setSize(300, 400);
        setVisible(true);//making the frame visible
    }



    /*Action listeners below are used to give Jbuttons purpose in life.*/
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
            EntrepotFactory ef = new EntrepotFactory();
            try {
                entrepot = ef.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class CartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            getContentPane().removeAll();
            repaint();
            /** TODO : add new buttons with their classes
             *
             * */
        }
    }

    private class closeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            dispose();
        }
    }
    private class ReturnButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionevent){
            getContentPane().removeAll();
            add(welcome);
            add(mainPanel);
        }
    }
}
