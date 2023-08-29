package Frame;

import javax.swing.*;
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
    private JComboBox comboBox1;
    private JTextField textField1;
    private JPanel PanelBtnRch;
    private JComboBox comboBox2;
    private JPanel PanelTable;
    private JTable table1;
    private JPanel PanelInfosClient;
    private JPanel PanelAdresse;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
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


    public Principale(){
        setContentPane(PanelAcceuil);
        PanelAcceuil.setVisible(true);


















        //creation menuBar
         JMenuBar mbar = new JMenuBar();
         JMenu Accueil = new JMenu("Accueil");
         JMenu Achat = new JMenu("Achat");
         JMenu recherche = new JMenu("recherche");

         mbar.add(Accueil);
         mbar.add(Achat);
         mbar.add(recherche);

        Accueil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(PanelAcceuil);
                PanelAcceuil.setVisible(true);
            }
        });

        //param fenetre par defaut
        Dimension d = new Dimension(750, 350);
        setJMenuBar(mbar);
        setSize(d);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}

//    public Principale() {
//        setVisible(true);
//
//        //creation menuBar
//        JMenuBar mbar = new JMenuBar();
//
//        JMenu Accueil = new JMenu("Accueil");
//        JMenu Achat = new JMenu("Achat");
//        JMenu recherche = new JMenu("recherche");
//
//        mbar.add(Accueil);
//        mbar.add(Achat);
//        mbar.add(recherche);
//        //    mbar.add(m2);
//
//        //creation des listener
//        btnAchat.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                getContentPane().removeAll();
//                setContentPane(PanelAchat);
//                PanelAchat.setVisible(true);
//            }
//        });
//
//
//        rdBtnOrdonnance1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                PanelMed.setVisible(true);
//            }
//        });
//        cBoxMedicament.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                PanelMed.add(new JLabel("Libéllé:"));
//                PanelMed.add(new JComboBox<>());
//            }
//        });
//
//        //param fenetre par defaut
//        setContentPane(Panelmain);
//        Dimension d = new Dimension(750, 350);
//        //param fenetre
//        setJMenuBar(mbar);
//        setSize(d);
//        setLayout(null);
//        setVisible(true);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//    }
//
//
//}

