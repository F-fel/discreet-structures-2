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
        setLayout(new GridLayout(5, 1));
        init.addActionListener(new InitListener());
        research.addActionListener(new researchListener());
        gotoCart.addActionListener(new CartListener());
        close.addActionListener(new closeListener());
        welcome.setVisible(true); //make the label visible

        mainPanel = new JPanel(new GridLayout(4, 1)); //5rows 1 column

        //add to panel/frame
        add(welcome);
        mainPanel.add(init);
        mainPanel.add(research);
        mainPanel.add(gotoCart);
        mainPanel.add(close);
        mainPanel.setSize(350, 550);
        add(mainPanel);
        setSize(400, 600);
        setVisible(true);//making the frame visible
    }

    // methods below are used to give suggestions based on type of the search
    private void suggestNames(String s) {
        Automate automate = new Automate(s);
        suggestedItems = automate.filterByName(suggestedItems);
        list = new JBList<>(suggestedItems.toStringArray());
    }

    private void suggestID(String s) {
        Automate automate = new Automate(s);
        suggestedItems = automate.filterByHex(suggestedItems);
        list = new JBList<>(suggestedItems.toStringArray());
    }

    private void suggestType(ObjectType t) {
        Automate automate = new Automate(t);
        suggestedItems = automate.filterByType(suggestedItems);
        list = new JBList<>(suggestedItems.toStringArray());
    }

    /*Action listeners below are used to give Jbuttons purpose in life.*/
    private class researchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            researchPage();
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

    private class ReturnButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionevent) {
            getContentPane().removeAll();
            setLayout(new GridLayout(5,1));
            add(welcome);
            add(mainPanel);
            revalidate();
            repaint();
        }

    }

    private void researchPage() {
        //clear everything
        getContentPane().removeAll();
        setLayout(new GridLayout(2,0));
        JSplitPane splitPane = new JSplitPane();
        JPanel searchPanel = new JPanel(new GridLayout(10, 1));

        searchPanel.add(new JLabel("Selectionner les options de recherche : \n"));
        JPanel suggestPanel = new JPanel();
        JButton addToCart = new JButton("Ajouter au panier");
        addToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String value = list.getSelectedValue();
                value = value.substring(value.indexOf("ID : ") + 5, value.indexOf(" Type") - 1);
                panier.add(entrepot.popByID(value));
            }
        });

        addToCart.setPreferredSize(new Dimension(40, 40));

        JCheckBox nameBox = new JCheckBox("nom");
        JCheckBox hexBox = new JCheckBox("ID");
        JCheckBox typeBox = new JCheckBox("type");
        JTextField nameText = new JTextField();
        JTextField hexText = new JTextField();
        JRadioButton typeA = new JRadioButton("A");
        typeA.setBounds(75,50,100,30);
        typeA.setVisible(false);
        JRadioButton typeB = new JRadioButton("B");
        typeB.setBounds(75,50,100,30);
        typeB.setVisible(false);
        JRadioButton typeC = new JRadioButton("C");
        typeC.setBounds(75,50,100,30);
        typeC.setVisible(false);
        ButtonGroup types = new ButtonGroup();
        types.add(typeA);
        types.add(typeB);
        types.add(typeC);
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
        searchPanel.add(nameBox);
        searchPanel.add(hexText);
        hexText.setVisible(false);
        searchPanel.add(hexBox);
        searchPanel.add(typeBox);
        searchPanel.add(typeA);
        searchPanel.add(typeB);
        searchPanel.add(typeC);
        typeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                typeA.setVisible(!typeA.isVisible());
                typeB.setVisible(!typeB.isVisible());
                typeC.setVisible(!typeC.isVisible());
            }
        });
        hexText.getDocument().addDocumentListener(new DocumentListener() {
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
                suggestID(hexText.getText());
                suggestPanel.removeAll();
                suggestPanel.add(list);
                suggestPanel.revalidate();
                suggestPanel.repaint();

                splitPane.revalidate();
                splitPane.repaint();
            }
        });
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
                suggestPanel.revalidate();
                suggestPanel.repaint();

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
        JButton back = new JButton("retourner au menu princiaple");
        back.addActionListener(new ReturnButtonListener());
        JPanel buttons = new JPanel(new GridLayout(1,2));
        buttons.add(addToCart);
        buttons.add(back);
        splitPane.setLeftComponent(searchPanel);
        splitPane.setRightComponent(suggestPanel);
        add(splitPane);
        add(buttons);
        revalidate();
        repaint();
    }
}
