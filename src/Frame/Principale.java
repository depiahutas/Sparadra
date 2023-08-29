package Frame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principale extends JFrame{
    private JPanel PanelMain;
    private JPanel PanelAcceuil;
    private JPanel PanelAchat;
    private JPanel PanelRecherche;
    private JPanel PanelInfoClient;
    private JButton btnAchat;
    private JButton btnRecherche;
    private JPanel PanelMeds;
    private JPanel PanelMed;
    private JPanel PanelBtn;
    private JRadioButton ordonnanceRadioButton;
    private JRadioButton sansOrdonnanceRadioButton;
    private JComboBox libelleComboBox;
    private JTextField prixTextField;
    private JPanel PanelBtnRch;
    private JComboBox rechercheComboBox;
    private JPanel PanelTable;
    private JTable labelTable;
    private JPanel PanelInfosClient;
    private JPanel PanelAdresse;
    private JComboBox nomComboBox;
    private JComboBox prenomComboBox;
    private JTextField telTextField;
    private JTextField mailTextField;
    private JTextField numéroTextField;
    private JTextField rueTextField;
    private JTextField codePostalTextField;
    private JTextField villeTextField;
    private JLabel lblMail;
    private JLabel lblTel;
    private JLabel lblRecherche;
    private JLabel lblAchat;
    private JLabel lblLibelle;
    private JLabel lblPrix;
    private JLabel lblNom;
    private JLabel lblPrenom;
    private JLabel lblNum;
    private JLabel lblRue;
    private JLabel lblCP;
    private JLabel lblVille;
    private JLabel lblTable;
    private JButton ajouterButton;
    private JPanel PanelRecap;
    private JTable TableMed;
    private JComboBox cBoxCat;
    private JLabel lblCat;
    private JButton rtnRechercher;


    public Principale(){

        //creation menuBar
         JMenuBar mbar = new JMenuBar();
         JMenu Accueil = new JMenu("Accueil");
         JMenu Achat = new JMenu("Achat");
         JMenu recherche = new JMenu("recherche");

         mbar.add(Accueil);
         mbar.add(Achat);
         mbar.add(recherche);


        //param fenetre par defaut
        setContentPane(PanelAcceuil);
        Dimension d = new Dimension(750, 350);
        setJMenuBar(mbar);
        setSize(d);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnAchat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(PanelAchat);
                PanelAchat.setVisible(true);
            }
        });
        btnRecherche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(PanelRecherche);
                PanelRecherche.setVisible(true);
            }
        });

        ordonnanceRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelMed.setVisible(true);
                PanelRecap.setVisible(true);
            }
        });
        sansOrdonnanceRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelMed.setVisible(true);
                PanelRecap.setVisible(true);
            }
        });

        //table Recap Medicament
        DefaultTableModel modelRecapMed = new DefaultTableModel();

        modelRecapMed.addColumn("Libéllé");
        modelRecapMed.addColumn("catégorie");
        modelRecapMed.addColumn("quantité");
        modelRecapMed.addColumn("Prix/u");
        modelRecapMed.addColumn("date mise en service");
        TableMed.setModel(modelRecapMed);
        TableMed.setEnabled(false);
        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //en fonction du medicament choisit l'ajoute avec toutes ses informations dans la table recap
                modelRecapMed.addRow(new Object[]{});
            }
        });

        DefaultTableModel modelRecherche = new DefaultTableModel();
        String colonne1="";
        String colonne2="";
        String colonne3="";
        String colonne4="";
        modelRecherche.addColumn(colonne1);
        modelRecherche.addColumn(colonne2);
        modelRecherche.addColumn(colonne3);
        modelRecherche.addColumn(colonne4);

        labelTable.setModel(modelRecherche);


    }

}
