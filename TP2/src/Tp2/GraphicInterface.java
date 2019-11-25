package Tp2;
import com.intellij.ui.components.JBList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class GraphicInterface extends JFrame {
    private Entrepot entrepot;
    Entrepot panier;
    private JPanel mainPanel;
    private JLabel welcome;
    private JButton back;
    private JList<String> list;


    public GraphicInterface() {
        super("TP4");
        //some initialisation
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        entrepot = new Entrepot();
        panier = new Entrepot();

        //main screen buttons and label
        JButton init = new JButton("Initialiser le programme");
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
        mainPanel.setSize(350,550);
        add(mainPanel);
        setSize(400, 600);
        setVisible(true);//making the frame visible
    }


    private void suggestNames(String s){
        Automate automate = new Automate(s);
        list= new JBList<>(automate.filter(entrepot.getNamesArray()));
    }
    /*Action listeners below are used to give Jbuttons purpose in life.*/
    private class researchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            getContentPane().removeAll();
            JSplitPane splitPane = new JSplitPane();
            JPanel searchPanel = new JPanel(new GridLayout(4,1));
            searchPanel.add(new JLabel("Selectionner les options de recherche : \n"));
            JCheckBox nameBox = new JCheckBox("nom");
            JPanel suggestPanel = new JPanel(); //no layout
            nameBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    JTextField nameText = new JTextField();
                    searchPanel.add(nameText);
                    nameText.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            suggestNames(nameText.getText());
                            suggestPanel.add(list);
                            revalidate();
                            repaint();
                        }
                    });
                }
            });
            searchPanel.add(nameBox);
            JCheckBox hexBox = new JCheckBox("ID hex");
            splitPane.setLeftComponent(searchPanel);
            splitPane.setRightComponent(suggestPanel);
            add(splitPane);
            revalidate();
            repaint();
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
