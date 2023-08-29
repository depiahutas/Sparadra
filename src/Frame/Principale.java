package Frame;

import javax.swing.*;
import java.awt.*;

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
    }

}
