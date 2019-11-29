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
    private Automate automateName;
    private Automate automateID;
    private Automate automateType;
    private JButton gotoCart;


    GraphicInterface() {
        super("TP4");
        //some initialisation
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        entrepot = new Entrepot();
        panier = new Entrepot();
        suggestedItems = new Entrepot();
        automateType=new Automate();
        automateID=new Automate();
        automateName = new Automate();
        //main screen buttons and label
        JButton init = new JButton("Initialiser le programme");
        JButton research = new JButton("Rechercher un élément");
        gotoCart = new JButton("allez au panier");
        JButton close = new JButton("Fermer la session");
        back = new JButton("retourner a l'ecran principale");//not added to main screen just initialised
        back.addActionListener(new ReturnButtonListener());
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

    private void suggest(){
        suggestedItems = entrepot;
        if(!automateName.isNull()) suggestedItems= automateName.filterByName(suggestedItems);
        if(!automateType.isNull()) suggestedItems=automateType.filterByType(suggestedItems);
        if(!automateID.isNull()) suggestedItems = automateID.filterByHex(suggestedItems);
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
            JLabel weight = new JLabel("Le panier pese : " + panier.weight() + "kg.");
            list = new JBList<>(panier.toStringArray());
            getContentPane().removeAll();
            JButton remove = new JButton("enlever un element");
            remove.addActionListener(actionEvent1 -> {
                String value = list.getSelectedValue();
                value = value.substring(value.indexOf("ID : ") + 5, value.indexOf(" Type"));
                entrepot.add(panier.popByID(value));
                this.actionPerformed(actionEvent);
            });
            JButton empty = new JButton("vider le panier");
            empty.addActionListener(actionEvent1 -> {
                entrepot.add(panier);
                panier = new Entrepot();
                this.actionPerformed(actionEvent);
            });
            JButton commande = new JButton("Acheminer la commande");
            commande.addActionListener(actionEvent1 -> {
                if(panier.weight() > 25) JOptionPane.showMessageDialog(null,"votre commande depasse 25kg. Veuillez vider le panier");
                else panier = new Entrepot();
                list = new JBList<>(panier.toStringArray());
                welcome.setText("Merci de patienter pendant que nous preparons votre commande");
                welcome.setForeground(Color.GREEN);
                ReturnButtonListener rbl = new ReturnButtonListener();
                rbl.actionPerformed(actionEvent);
            });
            JPanel buttons = new JPanel(new GridLayout(1,4));
            JPanel btnWeight = new JPanel(new GridLayout(2,1));
            add(list);
            btnWeight.add(weight);
            buttons.add(commande);
            buttons.add(back);
            buttons.add(remove);
            buttons.add(empty);
            btnWeight.add(buttons);
            add(btnWeight);
            revalidate();
            repaint();
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
            setLayout(new GridLayout(6,1));
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
        addToCart.addActionListener(actionEvent -> {
            String value = list.getSelectedValue();
            value = value.substring(value.indexOf("ID : ") + 5, value.indexOf(" Type"));
            Objet popped = entrepot.popByID(value);
            if(popped != null) panier.add(popped);
            else JOptionPane.showMessageDialog(null, "essaie d'ajout d'objet non disponible. clicker sur rechercher pour rafraishir la liste SVP");
        });

        addToCart.setPreferredSize(new Dimension(40, 40));

        JCheckBox nameBox = new JCheckBox("nom");
        JCheckBox hexBox = new JCheckBox("ID");
        JCheckBox typeBox = new JCheckBox("type");
        JTextField nameText = new JTextField();
        JTextField hexText = new JTextField();
        JRadioButton typeA = new JRadioButton("A");
        ButtonGroup types = new ButtonGroup();
        typeA.setBounds(75,50,100,30);
        typeA.setVisible(false);
        typeA.addActionListener(actionEvent -> {
            if(typeA.isSelected()) automateType = new Automate(ObjectType.A);
            suggest();
            suggestPanel.removeAll();
            suggestPanel.add(list);
            suggestPanel.revalidate();
            suggestPanel.repaint();
        });
        JRadioButton typeB = new JRadioButton("B");
        typeB.setBounds(75,50,100,30);
        typeB.setVisible(false);
        typeB.addActionListener(actionEvent -> {
            if(typeB.isSelected()) automateType = new Automate(ObjectType.B);
            suggest();
            suggestPanel.removeAll();
            suggestPanel.add(list);
            suggestPanel.revalidate();
            suggestPanel.repaint();

        });
        JRadioButton typeC = new JRadioButton("C");
        typeC.setBounds(75,50,100,30);
        typeC.setVisible(false);
        typeC.addActionListener(actionEvent -> {
            if(typeC.isSelected()) {
                automateType = new Automate(ObjectType.C);

                suggest();
                suggestPanel.removeAll();
                suggestPanel.add(list);
                suggestPanel.revalidate();
                suggestPanel.repaint();
            }

        });
        types.add(typeA);
        types.add(typeB);
        types.add(typeC);
        hexBox.addActionListener(actionEvent -> {
            hexText.setVisible(!hexText.isVisible());
            if(!hexText.isVisible()) {
                automateID = new Automate();
                suggest();
                suggestPanel.removeAll();
                suggestPanel.add(list);
                suggestPanel.revalidate();
                suggestPanel.repaint();
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
        typeBox.addActionListener(actionEvent -> {
            typeA.setVisible(!typeA.isVisible());
            typeB.setVisible(!typeB.isVisible());
            typeC.setVisible(!typeC.isVisible());
            if(!typeA.isVisible()) {
                automateType = new Automate();
                suggest();
                suggestPanel.removeAll();
                suggestPanel.add(list);
                suggestPanel.revalidate();
                suggestPanel.repaint();
            }
        });
        hexText.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            public void removeUpdate(DocumentEvent e) {
                if(!hexText.getText().equals("")) updateSuggestions();
                else automateID=new Automate();
            }

            public void insertUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            void updateSuggestions() {
                automateID = new Automate(hexText.getText());
                suggest();
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
                if(!nameText.getText().equals("")) updateSuggestions();
                else automateName=new Automate();
            }

            public void insertUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            void updateSuggestions() {
                automateName = new Automate(nameText.getText());
                suggest();
                suggestPanel.removeAll();
                suggestPanel.add(list);
                suggestPanel.revalidate();
                suggestPanel.repaint();

                splitPane.revalidate();
                splitPane.repaint();
            }
        });
        nameBox.addActionListener(actionEvent -> {
            nameText.setVisible(!nameText.isVisible());
            if(!nameText.isVisible()) automateName = new Automate();
        });
        JPanel buttons = new JPanel(new GridLayout(1,3));
        buttons.add(addToCart);
        buttons.add(gotoCart);
        buttons.add(back);
        JButton rechercher = new JButton("rechercher");
        rechercher.addActionListener(actionEvent -> {
            suggest();
            suggestPanel.removeAll();
            suggestPanel.add(list);
            revalidate();
            repaint();
        });
        searchPanel.add(rechercher);
        splitPane.setLeftComponent(searchPanel);
        splitPane.setRightComponent(suggestPanel);
        add(splitPane);
        add(buttons);
        revalidate();
        repaint();
    }
}
