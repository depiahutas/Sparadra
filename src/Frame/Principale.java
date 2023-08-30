package Frame;

import classMetier.Util.Achat;
import classMetier.Util.Adresse;
import classMetier.Util.CategorieMedicament;
import classMetier.personne.Client;
import classMetier.personne.Medecin;
import classMetier.sante.Medicament;
import classMetier.sante.Mutuelle;
import classMetier.sante.Ordonnance;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

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
    private JButton historiqueDAchatButton;
    private JButton historiqueOrdonnanceButton;
    private JLabel lblRsh;
    private JButton validerButton;
    private JPanel PanelClient;
    private JLabel lblNomClient;
    private JComboBox cBoxNom;


    public Principale(){
        final double[] sommeTot = {0.00f};

        ArrayList<Medecin> listMedecin = new ArrayList<>();
        Medecin medecin1 = new Medecin("A","B","A.B@mail@.com","0123456789",
                new Adresse(1,"a",75001,"Paris"),1);

        Medecin medecin2 = new Medecin("C","D","C.D@mail@.com","0234567891",
                new Adresse(2,"b",69007,"Lyon"),2);

        listMedecin.add(medecin1);
        listMedecin.add(medecin2);

        ArrayList<Client> listClient = new ArrayList<Client>();
        //creation jeux de données pour test
        Client client1 = new Client("Dupont","Marie","dupont.marie@mail.com","0612345678",
                new Adresse(123,"rue de la République",75001,"Paris"),
                new Date("20/07/1995"),medecin1,new Mutuelle(),"123 456 789 012 345"
        );

        Client client2 = new Client("Martin","Jean","martin.jean@mail.com","0789101112",
                new Adresse(456,"avenue de la libération",69007,"Lyon"),
                new Date("10/05/1975"),medecin2,new Mutuelle(),"123 456 789 012 346"
        );

        listClient.add(client1);
        listClient.add(client2);

        ArrayList<Medicament> listMed = new ArrayList<Medicament>();
        Medicament paracetamol = new Medicament("Paracétamol",5.99,new Date("15/02/98"),1, CategorieMedicament.ANTALGIQUE);
        listMed.add(paracetamol);


        ArrayList<Ordonnance> listOrdonnance = new ArrayList<>();
        Ordonnance ordonnance1 = new Ordonnance(medecin1,client1,new ArrayList<>(),new Date("30/08/2023"));
        listOrdonnance.add(ordonnance1);

        ArrayList<Achat> listAchat = new ArrayList<Achat>();
        Achat achat1 = new Achat(client1,new ArrayList<Medicament>(),25.37,new Date("30/08/2023"),true);

        listAchat.add(achat1);

        //creation menuBar
         JMenuBar mbar = new JMenuBar();
         JMenu Accueil = new JMenu("Accueil");
         JMenu Achat = new JMenu("Achat");
         JMenu recherche = new JMenu("recherche");

         JMenuItem Retour = new JMenuItem("Retour");
         JMenuItem Effectuer = new JMenuItem("Effectuer achat");
         JMenuItem RechercherOrd = new JMenuItem("Ordonnance");
         JMenuItem RechercherAch = new JMenuItem("Achat");

         Accueil.add(Retour);
         Achat.add(Effectuer);
         recherche.add(RechercherOrd);
         recherche.add(RechercherAch);

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
                DefaultTableModel mdl = (DefaultTableModel) TableMed.getModel();
                mdl.setRowCount(0);
                cBoxCat.removeAllItems();
                for (CategorieMedicament c : CategorieMedicament.values()){
                    cBoxCat.addItem(c.toString().toLowerCase());
                }
                cBoxCat.setSelectedIndex(-1);
            }
        });
        btnRecherche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(PanelRecherche);
                PanelRecherche.setVisible(true);
                lblRsh.setVisible(true);
                historiqueOrdonnanceButton.setVisible(true);
                historiqueDAchatButton.setVisible(true);
                lblRecherche.setVisible(false);
                rechercheComboBox.setSelectedIndex(-1);
                rechercheComboBox.setVisible(false);

                DefaultTableModel x= (DefaultTableModel) labelTable.getModel();
                x.setRowCount(0);

                DefaultTableModel model = new DefaultTableModel();
                labelTable.setModel(model);
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
        Retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(PanelAcceuil);
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
        TableMed.setAutoCreateRowSorter(true);



        ArrayList<Medicament> listMedAchat = new ArrayList<>();
        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Medicament m = null;

                //en fonction du medicament choisit l'ajoute avec toutes ses informations dans la table recap
                for(Medicament med :listMed){
                    if (med.getNom().equals(libelleComboBox.getSelectedItem()) && med.getCategorie().toString().toLowerCase().equals(cBoxCat.getSelectedItem())){
                       m=med;
                    }
                }
                if(m!=null) {
                    modelRecapMed.addRow(new Object[]{m.getNom(),m.getCategorie(),m.getQuantite(),m.getPrix(),m.getDateMES()});
                sommeTot[0] = sommeTot[0] +(m.getPrix()*m.getQuantite());
                }

                    listMedAchat.add(m);

                    Achat achat = new Achat(client1, listMedAchat,sommeTot[0],new Date("30/08/2020"),true);
            }
        });
        cBoxCat.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (Objects.equals(cBoxCat.getSelectedItem(), "") || cBoxCat.getSelectedItem()==null){
                    libelleComboBox.removeAllItems();
                    for (Medicament med : listMed){
                        libelleComboBox.addItem(med.getNom());
                    }
                    libelleComboBox.setSelectedIndex(-1);
                }
                else {
                    libelleComboBox.removeAllItems();
                    for (Medicament med : listMed) {
                        if (med.getCategorie().toString().toLowerCase().equals(cBoxCat.getSelectedItem())) {
                            libelleComboBox.addItem(med.getNom());
                        }
                    }
                }
            }
        });
        libelleComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (Objects.equals(cBoxCat.getSelectedItem(), "") || cBoxCat.getSelectedItem()==null) {
                    prixTextField.setText("");
                }
                else {
                    for (Medicament m : listMed){
                        if (m.getNom().equals(libelleComboBox.getSelectedItem())){
                            prixTextField.setText(""+m.getPrix());
                        }
                    }
                }
            }
        });
        historiqueDAchatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblRsh.setVisible(false);
                historiqueDAchatButton.setVisible(false);
                PanelRecherche.setVisible(true);
                lblRecherche.setVisible(true);
                rechercheComboBox.setVisible(true);
                historiqueOrdonnanceButton.setVisible(false);

                DefaultTableModel x= (DefaultTableModel) labelTable.getModel();
                x.setRowCount(0);

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Date");
                model.addColumn("Client");
                model.addColumn("Ordonnance");
                model.addColumn("Prix");

                for (Achat achat:listAchat){
                    model.addRow(new Object[]{achat.getDate(),achat.getClient().getNom(),achat.isOrdonnance(),achat.getPrix()});
                }

                labelTable.setModel(model);


            }
        });
        historiqueOrdonnanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lblRsh.setVisible(false);
                historiqueDAchatButton.setVisible(false);
                PanelRecherche.setVisible(true);
                lblRecherche.setVisible(true);
                rechercheComboBox.setVisible(true);
                historiqueOrdonnanceButton.setVisible(false);
                rechercheComboBox.removeAllItems();


                DefaultTableModel x= (DefaultTableModel) labelTable.getModel();
                x.setRowCount(0);
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Medecin");
                model.addColumn("Client");
                model.addColumn("Date");
                model.addColumn("Medicament");



                for(Medecin medecin:listMedecin){
                    rechercheComboBox.addItem(medecin.getNom());
                }
                rechercheComboBox.setSelectedIndex(-1);


                for (Ordonnance ordonnance:listOrdonnance){

                    model.addRow(new Object[]{ordonnance.getMedecin().getNom(),ordonnance.getClient().getNom(),ordonnance.getDate().toString(),ordonnance.getListMedToString()});
                }
                labelTable.setModel(model);

            }
        });


        rechercheComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel x= (DefaultTableModel) labelTable.getModel();
                x.setRowCount(0);
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Medecin");
                model.addColumn("Client");
                model.addColumn("Date");
                model.addColumn("Medicament");
                for (Medecin medecin:listMedecin){
                    if (medecin.getNom().equals(rechercheComboBox.getSelectedItem())){
                        for (Ordonnance ordonnance:listOrdonnance){
                            if (ordonnance.getMedecin().getNom().equals(medecin.getNom())){
                                model.addRow(new Object[]{ordonnance.getMedecin().getNom(),ordonnance.getClient().getNom(),ordonnance.getDate().toString(),ordonnance.getListMedToString()});
                            }
                        }
                    }
                }
                labelTable.setModel(model);
            }
        });
    }

}
