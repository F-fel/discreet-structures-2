package Tp2;
import com.intellij.ui.components.JBList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class GraphicInterface extends JFrame {
    private Entrepot entrepot;
    private Entrepot panier;
    private JPanel mainPanel;
    private JLabel welcome;
    private JButton back;
    private JList<String> list;
    private Entrepot suggestedItems;


    GraphicInterface() {
        super("TP4");
        //some initialisation
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        entrepot = new Entrepot();
        panier = new Entrepot();
        suggestedItems = new Entrepot();

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

// methods below are used to give suggestions based on type of the search
    private void suggestNames(String s){
        Automate automate = new Automate(s);
        suggestedItems = automate.filterByName(entrepot);
        list= new JBList<>(suggestedItems.toArray());
    }
    private void suggestID(String s){
        Automate automate = new Automate(s);
        suggestedItems=automate.filterByHex(entrepot);
        list= new JBList<>(suggestedItems.toArray());
    }
    private  void suggestType(ObjectType t){
        Automate automate = new Automate(t);
        suggestedItems = automate.filterByType(entrepot);
        list= new JBList<>(suggestedItems.toArray());
    }

    /*Action listeners below are used to give Jbuttons purpose in life.*/
    private class researchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //clear everything
            getContentPane().removeAll();
            JSplitPane splitPane = new JSplitPane();
            JPanel searchPanel = new JPanel(new GridLayout(4,1));

            //search options
            searchPanel.add(new JLabel("Selectionner les options de recherche : \n"));
            JPanel suggestPanel = new JPanel(); //no layout

            JCheckBox nameBox = new JCheckBox("nom");
            JCheckBox  hexBox = new JCheckBox("ID");
            JCheckBox typeBox = new JCheckBox("nom");
            JTextField nameText = new JTextField();
            JTextField hexText = new JTextField();
            JRadioButton typeA = new JRadioButton("A");
            JRadioButton typeB = new JRadioButton("B");
            JRadioButton typeC = new JRadioButton("C");
            hexBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    hexText.setVisible(!hexText.isVisible());
                    hexText.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            suggestNames(hexText.getText());
                            list.setVisible(true);
                            splitPane.revalidate();
                            splitPane.repaint();
                        }
                    });

                }
            });
            searchPanel.add(nameText);
            nameText.setVisible(false);
            nameText.getDocument().addDocumentListener(new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    updateSuggestions();
                }
                public void removeUpdate(DocumentEvent e) {
                    updateSuggestions();
                }
                public void insertUpdate(DocumentEvent e) {
                    updateSuggestions();
                }

                void updateSuggestions() {
                    suggestNames(nameText.getText());
                    suggestPanel.removeAll();
                    suggestPanel.add(list);
                    splitPane.revalidate();
                    splitPane.repaint();
                }
            });
            nameBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    nameText.setVisible(!nameText.isVisible());
                    nameText.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            suggestNames(nameText.getText());
                            list.setVisible(true);
                            splitPane.revalidate();
                            splitPane.repaint();
                        }
                    });
                }
            });
            searchPanel.add(nameBox);
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
            suggestedItems = entrepot;
            welcome.setText("entrepot successfully loaded");
            welcome.setForeground(Color.blue);
            repaint();
            revalidate();
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
