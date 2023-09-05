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
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;

public class Principale extends JFrame {
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
    private JComboBox cBoxPrenom;
    private JLabel lblPrenomClient;
    private JTextField QteTextField;
    private JTextField Prixtot;
    private JTextField textFieldRecherche;
    private JButton informationsClientButton;
    private JTextField NomTextField;
    private JTextField PrenomTextField;
    private JPanel PanelinfoSante;
    private JTextField dateDeNaissanceTextField;
    private JTextField mutuelleTextField;
    private JLabel lblDateNaiss;
    private JLabel lblMutuelle;
    private JTextField numéroDeSécuritéSocialeTextField;
    private JTextField médecinTraitantTextField;
    private JLabel lblNumSecu;
    private JLabel lblMedecin;
    private JPanel PanelInfoOrdonannce;
    private JPanel PanelInfoPatient;
    private JPanel PanelListMed;
    private JTextField nomDuPatientTextField;
    private JTextField prenomTextField;
    private JTable tableMed;
    private JLabel lblNomPatient;
    private JLabel lblPrenomPatient;
    private JTextField nomMédecinTextField;
    private JLabel lblDate;
    private JTextField nOrdonannceTextField;
    private JLabel lblNumOrdonannce;
    private JButton validerAchatButton;

    private final ButtonGroup buttonGroup = new ButtonGroup();

    ArrayList<Medecin> listMedecin = new ArrayList<>();
    ArrayList<Mutuelle> listMutuelle = new ArrayList<>();
    ArrayList<Client> listClient = new ArrayList<>();
    ArrayList<Medicament> listMed = new ArrayList<>();
    ArrayList<Medicament> medic = new ArrayList<>();
    ArrayList<Ordonnance> listOrdonnance = new ArrayList<>();
    ArrayList<Achat> listAchat = new ArrayList<>();

    //liste medicament pour achat
    ArrayList<Medicament> listMedAchat = new ArrayList<>();

    // model recapMed pour achat
    DefaultTableModel modelRecapMed = new DefaultTableModel();


    final double[] sommeTot = {0.00f};

    Dimension d = new Dimension(750, 350);


    public Principale() {

        // button group pour achat-> radio boutton ordonnance choix unique
        buttonGroup.add(ordonnanceRadioButton);
        buttonGroup.add(sansOrdonnanceRadioButton);

        jeuDeDonnee();
        paramFenetre();
        actionAccueil();
        actionAchat();
        actionClient();
        actionRecherche();

        //table Recap Medicament


        TableMed.setDefaultEditor(Object.class, null);

        modelRecapMed.addColumn("Libéllé");
        modelRecapMed.addColumn("catégorie");
        modelRecapMed.addColumn("quantité");
        modelRecapMed.addColumn("Prix/u");
        modelRecapMed.addColumn("date mise en service");
        TableMed.setModel(modelRecapMed);
        TableMed.setEnabled(false);
        TableMed.setAutoCreateRowSorter(true);

    }

    /**
     * Jeu de données pour tester l'application
     */
    private void jeuDeDonnee(){

        //jeu de données pour test application
        Medecin medecin1 = new Medecin("A", "B", "A.B@mail@.com", "0123456789",
                new Adresse(1, "a", "75001", "Paris"), 1);

        Medecin medecin2 = new Medecin("C", "D", "C.D@mail@.com", "0234567891",
                new Adresse(2, "b", "69007", "Lyon"), 2);

        listMedecin.add(medecin1);
        listMedecin.add(medecin2);



        Mutuelle mutuelle1 = new Mutuelle(new Adresse(77, "rue des mutuelles", "75423", "ici"),
                "Mut", "0954642318", "mut@mail.fr", 2);


        //creation jeux de données pour test
        Client client1 = new Client("Dupont", "Marie", "dupont.marie@mail.com", "0612345678",
                new Adresse(123, "rue de la République", "75001", "Paris"),
                "20/07/1995", medecin1, mutuelle1, "123 456 789 012 345"
        );

        Client client2 = new Client("Martin", "Jean", "martin.jean@mail.com", "0789101112",
                new Adresse(456, "avenue de la libération", "69007", "Lyon"),
                "10/05/1975", medecin2, mutuelle1, "123 456 789 012 346"
        );

        listClient.add(client1);
        listClient.add(client2);


        Medicament paracetamol = new Medicament("Paracétamol", 5.99, "15/02/98", 1,
                CategorieMedicament.ANTALGIQUE);
        listMed.add(paracetamol);


        medic.add(paracetamol);


        Ordonnance ordonnance1 = new Ordonnance(medecin1, client1, medic, "30/01/2023", 1);
        listOrdonnance.add(ordonnance1);

        Ordonnance ordonnance2 = new Ordonnance(medecin1, client1, new ArrayList<>(), "15/08/2023", 2);
        listOrdonnance.add(ordonnance2);


        Achat achat1 = new Achat(client1, new ArrayList<>(), 25.37, "30/08/2023",
                ordonnance1);

        listAchat.add(achat1);
    }

    /**
     * Parametre de la fenetre
     * création du menubar
     * & action menuItem
     */
    private void paramFenetre(){

        //creation menuBar
        JMenuBar mbar = new JMenuBar();
        JMenu Accueil = new JMenu("Accueil");
        JMenu Achat = new JMenu("Achat");
        JMenu recherche = new JMenu("recherche");

        JMenuItem Retour = new JMenuItem("Retour");
        JMenuItem Effectuer = new JMenuItem("Effectuer achat");
        JMenuItem RechercherOrd = new JMenuItem("Ordonnance");
        JMenuItem RechercherAch = new JMenuItem("Achat");
        JMenuItem RechercherClient = new JMenuItem("Client");

        Accueil.add(Retour);
        Achat.add(Effectuer);
        recherche.add(RechercherOrd);
        recherche.add(RechercherAch);
        recherche.add(RechercherClient);

        mbar.add(Accueil);
        mbar.add(Achat);
        mbar.add(recherche);

        // Action des MenuItem

        // retour a l'accueil
        Retour.addActionListener(e -> setContentPane(PanelAcceuil));

        //page d'achat
        Effectuer.addActionListener(e -> {
            sommeTot[0] = 0;
            Prixtot.setText("");
            QteTextField.setText("1");
            setContentPane(PanelAchat);
            buttonGroup.clearSelection();
            PanelClient.setVisible(false);
            PanelAchat.setVisible(true);
            PanelMed.setVisible(false);
            PanelRecap.setVisible(false);
            cBoxCat.setVisible(false);
            lblCat.setVisible(false);
            ajouterButton.setVisible(false);
            DefaultTableModel mdl = (DefaultTableModel) TableMed.getModel();
            mdl.setRowCount(0);
            cBoxCat.removeAllItems();
            cBoxNom.removeAllItems();
            for (CategorieMedicament c : CategorieMedicament.values()) {
                cBoxCat.addItem(c.toString().toLowerCase());
            }
            cBoxCat.setSelectedIndex(-1);
            for (Client client : listClient) {
                cBoxNom.addItem(client.getNom());
            }
            cBoxNom.setSelectedIndex(-1);
        });

        //panel recherche ordonnance
        RechercherOrd.addActionListener(e -> {
            setContentPane(PanelRecherche);
            lblRsh.setVisible(false);
            textFieldRecherche.setVisible(false);
            historiqueDAchatButton.setVisible(false);
            PanelRecherche.setVisible(true);
            lblRecherche.setVisible(true);
            rechercheComboBox.setVisible(true);
            historiqueOrdonnanceButton.setVisible(false);
            rechercheComboBox.removeAllItems();


            DefaultTableModel x = (DefaultTableModel) labelTable.getModel();
            x.setRowCount(0);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Medecin");
            model.addColumn("Client");
            model.addColumn("ID ordonnance");
            model.addColumn("Date");
            model.addColumn("Medicament");


            for (Medecin medecin : listMedecin) {
                rechercheComboBox.addItem(medecin.getNom());
            }
            rechercheComboBox.setSelectedIndex(-1);


            for (Ordonnance ordonnance : listOrdonnance) {
                String a = ordonnance.getClient().getNom() + " " + ordonnance.getClient().getPrenom();
                model.addRow(new Object[]{ordonnance.getMedecin().getNom(),
                        a, ordonnance.getId(),ordonnance.getDate(),
                        ordonnance.getListMedToString()});
            }
            labelTable.setModel(model);
            labelTable.setAutoCreateRowSorter(true);
            labelTable.setDefaultEditor(Object.class, null);
        });

        //panel recherche achat par date
        RechercherAch.addActionListener(e -> {
            setContentPane(PanelRecherche);
            textFieldRecherche.setVisible(true);
            textFieldRecherche.setText("");
            lblRsh.setVisible(false);
            rechercheComboBox.setVisible(false);
            historiqueDAchatButton.setVisible(false);
            PanelRecherche.setVisible(true);
            lblRecherche.setVisible(true);
            historiqueOrdonnanceButton.setVisible(false);

            DefaultTableModel x = (DefaultTableModel) labelTable.getModel();
            x.setRowCount(0);

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Date");
            model.addColumn("Client");
            model.addColumn("Ordonnance");
            model.addColumn("Prix");

            for (Achat achat : listAchat) {
                String a = achat.getClient().getNom() + " " + achat.getClient().getPrenom();
                if (achat.getOrdonnance()!=null) {
                    model.addRow(new Object[]{achat.getDate(), a, achat.getOrdonnance().getId(),
                            achat.getPrix()});
                }
                else {
                    model.addRow(new Object[]{achat.getDate(), a, "",
                            achat.getPrix()});
                }
            }

            labelTable.setModel(model);
            labelTable.setDefaultEditor(Object.class, null);
        });

        //panel info client
        RechercherClient.addActionListener(e -> {
            setContentPane(PanelInfoClient);
            nomComboBox.setVisible(true);
            nomComboBox.removeAllItems();
            prenomComboBox.removeAllItems();
            NomTextField.setText("");
            NomTextField.setVisible(false);
            NomTextField.setEditable(false);

            for (Client client : listClient) {
                nomComboBox.addItem(client.getNom());
                prenomComboBox.addItem(client.getPrenom());
            }

            prenomComboBox.setVisible(true);
            PrenomTextField.setText("");
            PrenomTextField.setVisible(false);
            PrenomTextField.setEditable(false);

            nomComboBox.setSelectedIndex(-1);
            prenomComboBox.setSelectedIndex(-1);
        });

        //param fenetre par defaut
        setContentPane(PanelAcceuil);
        setJMenuBar(mbar);
        setSize(d);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * actionBtnAchat -> affichage panel Achat
     * actionBtnRecherche -> affichage panel Recherche
     * actionBtnInformation -> affichage panel Information client
     */
    private void actionAccueil(){
        actionBtnAchat();
        actionBtnRecherche();
        actionBtnInformation();
    }

    private void actionBtnAchat(){
        //Affichage panel Achat et réinitialise les données du form
        btnAchat.addActionListener(e -> {
            sommeTot[0] = 0;
            Prixtot.setText("");
            QteTextField.setText("1");
            setContentPane(PanelAchat);
            buttonGroup.clearSelection();
            PanelClient.setVisible(false);
            PanelAchat.setVisible(true);
            PanelMed.setVisible(false);
            PanelRecap.setVisible(false);
            cBoxCat.setVisible(false);
            lblCat.setVisible(false);
            ajouterButton.setVisible(false);
            DefaultTableModel mdl = (DefaultTableModel) TableMed.getModel();
            mdl.setRowCount(0);
            cBoxCat.removeAllItems();
            cBoxNom.removeAllItems();
            for (CategorieMedicament c : CategorieMedicament.values()) {
                cBoxCat.addItem(c.toString().toLowerCase());
            }
            cBoxCat.setSelectedIndex(-1);

            for (Client client : listClient) {
                cBoxNom.addItem(client.getNom());
            }
            cBoxNom.setSelectedIndex(-1);
        });
    }

    private void actionBtnRecherche(){
        //Affichage panel recherche et réinitialise les données de la JTable
        btnRecherche.addActionListener(e -> {
            textFieldRecherche.setVisible(false);
            setContentPane(PanelRecherche);
            PanelRecherche.setVisible(true);
            lblRsh.setVisible(true);
            historiqueOrdonnanceButton.setVisible(true);
            historiqueDAchatButton.setVisible(true);
            lblRecherche.setVisible(false);
            rechercheComboBox.setSelectedIndex(-1);
            rechercheComboBox.setVisible(false);

            DefaultTableModel x = (DefaultTableModel) labelTable.getModel();
            x.setRowCount(0);

            DefaultTableModel model = new DefaultTableModel();

            labelTable.setDefaultEditor(Object.class, null);
            labelTable.setModel(model);
        });
    }

    private void actionBtnInformation(){
        //affichge données client
        informationsClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setContentPane(PanelInfoClient);
                nomComboBox.setVisible(true);
                nomComboBox.removeAllItems();
                prenomComboBox.removeAllItems();
                NomTextField.setText("");
                NomTextField.setVisible(false);
                NomTextField.setEditable(false);

                for (Client client : listClient) {
                    nomComboBox.addItem(client.getNom());
                    prenomComboBox.addItem(client.getPrenom());
                }


                prenomComboBox.setVisible(true);
                PrenomTextField.setText("");
                PrenomTextField.setVisible(false);
                PrenomTextField.setEditable(false);

                nomComboBox.setSelectedIndex(-1);
                prenomComboBox.setSelectedIndex(-1);
            }
        });
    }

    /**
     * actionRadioBtnAchat -> action radio boutton ordonnance
     * ajoutAchat -> ajout medicament listMed et tableMed
     * triParNomAchat -> tri prenom client en fonction nom sélectionné
     * triParCategorie -> tri liste medicament en fonction categorie sélectionné
     * triParLibelle -> affiche le prix en fonction du mecicament sélectionné
     */
    private void actionAchat(){
        actionRadioBtnAchat();
        ajoutAchat();
        triParNomAchat();
        triParCategorie();
        triParLibelle();
        validerAchat();
    }

    //action radio boutton pour achat
    private void actionRadioBtnAchat(){
        // radioBoutton pour choix achat par ordonnance ou direct
        ordonnanceRadioButton.addActionListener(e -> {
            PanelMed.setVisible(true);
            PanelRecap.setVisible(true);
            PanelClient.setVisible(true);
            lblCat.setVisible(true);
            cBoxCat.setVisible(true);
            ajouterButton.setVisible(true);
            lblNumOrdonannce.setVisible(true);
            nOrdonannceTextField.setVisible(true);
            nOrdonannceTextField.setText("");
        });

        sansOrdonnanceRadioButton.addActionListener(e -> {
            PanelMed.setVisible(true);
            PanelRecap.setVisible(true);
            PanelClient.setVisible(true);
            lblCat.setVisible(true);
            cBoxCat.setVisible(true);
            ajouterButton.setVisible(true);
            lblNumOrdonannce.setVisible(false);
            nOrdonannceTextField.setVisible(false);
        });
    }

    // bouton ajouter panel achat
    private void ajoutAchat(){
        // ajout du medicament selectionné au recapMed
        // liste de medicament stocké pour validation afin d'etre ajouter a l'historique achat
        ajouterButton.addActionListener(e -> {
            Medicament m = null;

            //en fonction du medicament choisit l'ajoute avec toutes ses informations dans la table recap
            for (Medicament med : listMed) {
                if (med.getNom().equals(libelleComboBox.getSelectedItem()) &&
                        med.getCategorie().toString().toLowerCase().equals(cBoxCat.getSelectedItem())) {
                    m = med;
                }
            }
            if (m != null) {
                modelRecapMed.addRow(new Object[]{m.getNom(), m.getCategorie(), QteTextField.getText(),
                        m.getPrix(), m.getDateMES()});
                sommeTot[0] = sommeTot[0] + (m.getPrix() * Double.parseDouble(QteTextField.getText()));
                listMedAchat.add(m);
            }

            Prixtot.setText("" + sommeTot[0]);

        });

    }

    //tri liste déroulante client panel achat
    private void triParNomAchat(){
        //tri list client en fonctio nom sélectionner
        cBoxNom.addActionListener(e -> {
            cBoxPrenom.removeAllItems();
            for (Client client : listClient) {
                if (client.getNom().equals(cBoxNom.getSelectedItem())) {
                    cBoxPrenom.addItem(client.getPrenom());
                }
            }
        });
    }

    // tri liste medicament en fonction de la categorie
    private  void triParCategorie(){
        // action de tri sur les medicament en fonction de la categorie choisit
        cBoxCat.addItemListener(e -> {
            if (Objects.equals(cBoxCat.getSelectedItem(), "") || cBoxCat.getSelectedItem() == null) {
                libelleComboBox.removeAllItems();
                for (Medicament med : listMed) {
                    libelleComboBox.addItem(med.getNom());
                }
                libelleComboBox.setSelectedIndex(-1);
            } else {
                libelleComboBox.removeAllItems();
                for (Medicament med : listMed) {
                    if (med.getCategorie().toString().toLowerCase().equals(cBoxCat.getSelectedItem())) {
                        libelleComboBox.addItem(med.getNom());
                    }
                }
            }
        });
    }

    private  void triParLibelle(){
        // action pour afficher le prix en fonction du médicament choisit
        libelleComboBox.addItemListener(e -> {
            if (Objects.equals(cBoxCat.getSelectedItem(), "") || cBoxCat.getSelectedItem() == null) {
                for (Medicament med : listMed) {
                    if (med.getNom().equals(libelleComboBox.getSelectedItem())) {
                        cBoxCat.setSelectedItem(med.getCategorie().toString().toLowerCase());
                    }
                }
            } else {
                for (Medicament m : listMed) {
                    if (m.getNom().equals(libelleComboBox.getSelectedItem())) {
                        prixTextField.setText("" + m.getPrix());
                    }
                }
            }
        });
    }

    private  void validerAchat(){
        // bouton valider -> a faire : valide un achat si tous les champs son rempli
        // archive en meme temps
        validerButton.addActionListener(e -> {

            Client c = null;
            for (Client client : listClient) {
                if (cBoxPrenom.getSelectedItem() == null) {
                    if (client.getNom().equals(cBoxNom.getSelectedItem())) {
                        c = client;
                    }
                } else if (client.getNom().equals(cBoxNom.getSelectedItem())
                        && client.getPrenom().equals(cBoxPrenom.getSelectedItem())) {
                    c = client;
                }
            }


            Achat achat = new Achat(c, listMedAchat, sommeTot[0], classMetier.Util.Date.newDate(), null);
            listAchat.add(achat);

            setContentPane(PanelAcceuil);

        });
    }


    /**
     *
     */
    private  void actionRecherche(){
        //recherche Achat
        RechercheAchat();
        triDate();

        //recherche Ordonnance
        RechercheOrd();
        triOrdonnance();

        //Jtable
        TableRecherche();
    }

    private  void RechercheAchat(){
        //affiche et réinitialise la JTable recherche pour afficher que les achats
        historiqueDAchatButton.addActionListener(e -> {
            textFieldRecherche.setVisible(true);
            textFieldRecherche.setText("");
            lblRsh.setVisible(false);
            historiqueDAchatButton.setVisible(false);
            PanelRecherche.setVisible(true);
            lblRecherche.setVisible(true);
            historiqueOrdonnanceButton.setVisible(false);

            DefaultTableModel x = (DefaultTableModel) labelTable.getModel();
            x.setRowCount(0);

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Date");
            model.addColumn("Client");
            model.addColumn("ID ordonnance");
            model.addColumn("Prix");

            for (Achat achat : listAchat) {
                String a = achat.getClient().getNom() + " " + achat.getClient().getPrenom();
                if (achat.getOrdonnance()!=null) {
                    model.addRow(new Object[]{achat.getDate(), a, achat.getOrdonnance().getId(),
                            achat.getPrix()});
                }
                else {
                    model.addRow(new Object[]{achat.getDate(), a, "",
                            achat.getPrix()});
                }
            }

            labelTable.setModel(model);
            labelTable.setDefaultEditor(Object.class, null);

        });
    }

    private  void RechercheOrd(){
        //affiche et réinitialise la JTable recherche pour afficher que les ordonnances
        historiqueOrdonnanceButton.addActionListener(e -> {

            lblRsh.setVisible(false);
            historiqueDAchatButton.setVisible(false);
            PanelRecherche.setVisible(true);
            lblRecherche.setVisible(true);
            rechercheComboBox.setVisible(true);
            historiqueOrdonnanceButton.setVisible(false);
            rechercheComboBox.removeAllItems();


            DefaultTableModel x = (DefaultTableModel) labelTable.getModel();
            x.setRowCount(0);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Medecin");
            model.addColumn("Client");
            model.addColumn("ID ordonnance");
            model.addColumn("Date");
            model.addColumn("Medicament");


            for (Medecin medecin : listMedecin) {
                rechercheComboBox.addItem(medecin.getNom());
            }
            rechercheComboBox.setSelectedIndex(-1);


            for (Ordonnance ordonnance : listOrdonnance) {
                String a = ordonnance.getClient().getNom() + " " + ordonnance.getClient().getPrenom();
                model.addRow(new Object[]{ordonnance.getMedecin().getNom(),
                        a, ordonnance.getId(),ordonnance.getDate(),
                        ordonnance.getListMedToString()});
            }
            labelTable.setModel(model);
            labelTable.setAutoCreateRowSorter(true);
            labelTable.setDefaultEditor(Object.class, null);

        });
    }

    private void triOrdonnance(){
        // recherche par medecin dans historique ordonnance
        rechercheComboBox.addActionListener(e -> {
            DefaultTableModel x = (DefaultTableModel) labelTable.getModel();
            x.setRowCount(0);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Medecin");
            model.addColumn("Client");
            model.addColumn("ID ordonnance");
            model.addColumn("Date");
            model.addColumn("Medicament");
            for (Medecin medecin : listMedecin) {
                if (medecin.getNom().equals(rechercheComboBox.getSelectedItem())) {
                    for (Ordonnance ordonnance : listOrdonnance) {
                        if (ordonnance.getMedecin().getNom().equals(medecin.getNom())) {
                            String a = ordonnance.getClient().getNom() + " " + ordonnance.getClient().getPrenom();
                            model.addRow(new Object[]{ordonnance.getMedecin().getNom(),
                                    a, ordonnance.getId(),ordonnance.getDate(), ordonnance.getListMedToString()});
                        }
                    }
                }
            }
            labelTable.setModel(model);
            labelTable.setAutoCreateRowSorter(true);
            labelTable.setDefaultEditor(Object.class, null);
        });
    }


    //action de recherche par date
    private void triDate(){
        textFieldRecherche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel x = (DefaultTableModel) labelTable.getModel();
                x.setRowCount(0);
                DefaultTableModel model = new DefaultTableModel();

                model.addColumn("Date");
                model.addColumn("Client");
                model.addColumn("Ordonnance");
                model.addColumn("Prix");


                for (classMetier.Util.Achat achat : listAchat) {
                    if (textFieldRecherche.getText().equals(achat.getDate())) {
                        String a = achat.getClient().getNom() + " " + achat.getClient().getPrenom();
                        if (achat.getOrdonnance()!=null){
                            model.addRow(new Object[]{achat.getDate(), a, achat.getOrdonnance().getId(), achat.getPrix()});
                        }
                        else {
                            model.addRow(new Object[]{achat.getDate(), a,"", achat.getPrix()});
                        }
                    }
                }


                labelTable.setModel(model);
                labelTable.setAutoCreateRowSorter(true);
                labelTable.setDefaultEditor(Object.class, null);

            }
        });
    }


    //action selon case double cliqué dans la Jtable des recherche
    //colonne client affiche données client dans nouvelle fenetre
    //colonne ID ordonnance affiche détails ordonnance dans nouvelle fenetre
    private void TableRecherche(){

        labelTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    switch (column) {
                        case 1: {
                            if (target.getColumnName(column).equals("Client")) {
                                JFrame info = new JFrame();
                                info.setBounds(100, 100, 750, 500);
                                info.setContentPane(PanelInfoClient);
                                info.setVisible(true);
                                nomComboBox.setVisible(false);
                                NomTextField.setText("");
                                NomTextField.setVisible(true);
                                NomTextField.setEditable(false);

                                prenomComboBox.setVisible(false);
                                PrenomTextField.setText("");
                                PrenomTextField.setVisible(true);
                                PrenomTextField.setEditable(false);
                                for (Client client : listClient) {
                                    if ((client.getNom() + " " + client.getPrenom()).equals(target.getValueAt(row, column))) {
                                        NomTextField.setText(client.getNom());
                                        PrenomTextField.setText(client.getPrenom());
                                        numéroTextField.setText(client.getTel());
                                        rueTextField.setText(client.getAdresse().getRue());
                                        codePostalTextField.setText(client.getAdresse().getCodePostal());
                                        villeTextField.setText(client.getAdresse().getVille());
                                        dateDeNaissanceTextField.setText(client.getDateNaiss());
                                        mutuelleTextField.setText(client.getMutuelle().getNom());
                                        numéroDeSécuritéSocialeTextField.setText(client.getNumSecu());
                                        médecinTraitantTextField.setText(client.getMedecin().getNom());
                                    }
                                }
                            }
                        }
                        case 2:{
                            if (target.getColumnName(column).equals("ID ordonnance")){
                                //if (target.getValueAt(row,column)!=null) {
                                JFrame info = new JFrame();
                                info.setBounds(100, 100, 750, 500);
                                info.setContentPane(PanelInfoOrdonannce);

                                if (target.getValueAt(row,column).equals("")){
                                    JOptionPane.showMessageDialog(null,"Il n'y a pas d'ordonnance");
                                } else if (!target.getValueAt(row,column).equals("")) {


                                    for (Ordonnance ordonnance : listOrdonnance) {
                                        if (ordonnance.getId() ==
                                                Integer.parseInt(target.getValueAt(row, column).toString())) {
                                            lblDate.setText(ordonnance.getDate());
                                            nomMédecinTextField.setText(ordonnance.getMedecin().getNom());
                                            nomDuPatientTextField.setText(ordonnance.getClient().getNom());
                                            prenomTextField.setText(ordonnance.getClient().getPrenom());
                                            DefaultTableModel x = new DefaultTableModel();

                                            x.addColumn("Categorie");
                                            x.addColumn("Libéllé");
                                            x.addColumn("date mise en service");
                                            x.addColumn("Prix / u");
                                            tableMed.setModel(x);

                                            DefaultTableModel model = (DefaultTableModel) tableMed.getModel();
                                            model.setRowCount(0);

                                            tableMed.setDefaultEditor(Object.class, null);
                                            tableMed.setAutoCreateRowSorter(true);


                                            for (Medicament med : ordonnance.getListMed()) {
                                                model.addRow(new Object[]{med.getCategorie(), med.getNom(), med.getDateMES(), med.getPrix()});
                                            }
                                            tableMed.setModel(model);

                                        }
                                    }
                                    info.setVisible(true);
                                }
                            }
                        }
                        default: {
                        }
                    }

                }
            }
        });
    }


    /**
     *
     */
    private void actionClient(){
        triNom();
        triPrenom();
    }

    private void triNom(){
        // tri prénom client si plusieurs
        //sinon affiche détails client
        nomComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client c = null;
                prenomComboBox.removeAllItems();
                for (Client client : listClient) {
                    if (client.getNom().equals(nomComboBox.getSelectedItem())) {

                        prenomComboBox.addItem(client.getPrenom());
                        c = client;

                    }
                }
                if (prenomComboBox.getItemCount() == 1 && c != null) {
                    NomTextField.setText(c.getNom());
                    PrenomTextField.setText(c.getPrenom());
                    numéroTextField.setText(c.getTel());
                    rueTextField.setText(c.getAdresse().getRue());
                    codePostalTextField.setText(c.getAdresse().getCodePostal());
                    villeTextField.setText(c.getAdresse().getVille());
                    dateDeNaissanceTextField.setText(c.getDateNaiss());
                    mutuelleTextField.setText(c.getMutuelle().getNom());
                    numéroDeSécuritéSocialeTextField.setText(c.getNumSecu());
                    médecinTraitantTextField.setText(c.getMedecin().getNom());
                }
            }
        });
    }

    private void triPrenom(){
        //affichage données client
        prenomComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Client client : listClient) {
                    if (client.getNom().equals(nomComboBox.getSelectedItem())
                            && client.getPrenom().equals(prenomComboBox.getSelectedItem())) {

                        NomTextField.setText(client.getNom());
                        PrenomTextField.setText(client.getPrenom());
                        numéroTextField.setText(client.getTel());
                        rueTextField.setText(client.getAdresse().getRue());
                        codePostalTextField.setText(client.getAdresse().getCodePostal());
                        villeTextField.setText(client.getAdresse().getVille());
                        dateDeNaissanceTextField.setText(client.getDateNaiss());
                        mutuelleTextField.setText(client.getMutuelle().getNom());
                        numéroDeSécuritéSocialeTextField.setText(client.getNumSecu());
                        médecinTraitantTextField.setText(client.getMedecin().getNom());
                    }
                }
            }
        });

    }
}