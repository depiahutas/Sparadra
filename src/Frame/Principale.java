package Frame;

import classMetier.Util.Achat;
import classMetier.Util.Adresse;
import classMetier.Util.CategorieMedicament;
import classMetier.Util.Regex;
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
import java.util.regex.Pattern;

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
    private JTextField numeroTextField;
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
    private JTextField numeroDeSecuriteSocialeTextField;
    private JTextField medecinTraitantTextField;
    private JLabel lblNumSecu;
    private JPanel PanelInfoOrdonannce;
    private JPanel PanelInfoPatient;
    private JPanel PanelListMed;
    private JTextField nomDuPatientTextField;
    private JTextField prenomTextField;
    private JTable tableMed;
    private JLabel lblNomPatient;
    private JLabel lblPrenomPatient;
    private JTextField nomMedecinTextField;
    private JLabel lblDate;
    private JTextField nOrdonannceTextField;
    private JLabel lblNumOrdonannce;
    private JLabel lblErreurAchat;
    private JLabel lblErreurClient;
    private JLabel lblErreurOdronnance;
    private JLabel lblErreurRecherche;
    private JLabel lblQte;
    private JLabel lblInfoClient;
    private JLabel lblDateOrdo;
    private JLabel lblNomMed;
    private JLabel lblMutuelle;
    private JLabel lblMedecin;
    private JButton modifierButton;
    private JButton validerInfoButton;
    private JLabel errorlbl;
    private JButton NewClietnBtn;
    private JPanel PanelAjoutClient;
    private JButton validCreationButton;
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

    //liste Adresse
    ArrayList<Adresse> listAdresse = new ArrayList<>();

    // model recapMed pour achat
    DefaultTableModel modelRecapMed = new DefaultTableModel();


    final double[] sommeTot = {0.00f};

    Dimension d = new Dimension(750, 350);

    JFrame nouvClient = new JFrame();


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


        Adresse adresse1 =new Adresse(1, "a", "75001", "Paris");
        Adresse adresse2 = new Adresse(2, "b", "69007", "Lyon");
        Adresse adresse3 =new Adresse(77, "rue des mutuelles", "75423", "ici");
        Adresse adresse4 = new Adresse(123, "rue de la République", "75001", "Paris");
        Adresse adresse5 = new Adresse(456, "avenue de la libération", "69007", "Lyon");

        listAdresse.add(adresse1);
        listAdresse.add(adresse2);
        listAdresse.add(adresse3);
        listAdresse.add(adresse4);
        listAdresse.add(adresse5);

        //jeu de données pour test application
        Medecin medecin1 = new Medecin("A", "B", "jane.doe@example.net", "0123456789",
                adresse1, "A123456789");

        Medecin medecin2 = new Medecin("C", "D", "johndoe@example.org", "0234567891",
                adresse2, "C098765432");

        listMedecin.add(medecin1);
        listMedecin.add(medecin2);



        Mutuelle mutuelle1 = new Mutuelle(adresse3, "Mut", "0954642318", "mut.mut@gmail.fr", 2);
        listMutuelle.add(mutuelle1);

        //creation jeux de données pour test
        Client client1 = new Client(1,"Dupont", "Marie", "dupont.marie@gmail.com", "0612345678",
               adresse4, "20/07/1995", medecin1, mutuelle1, "2012345678"
        );

        Client client2 = new Client(2,"Martin", "Jean", "martin.jean@gmail.com", "0789101112", adresse5,
                "10/05/1975", medecin2, mutuelle1, "2012345679"
        );

        listClient.add(client1);
        listClient.add(client2);


        Medicament paracetamol = new Medicament("Paracétamol", 5.99, "15/02/98", 1,
                CategorieMedicament.ANTALGIQUE);
        Medicament Antispasmodiques = new Medicament("Antispasmodiques",2.66,"15/09/2020",1,
                CategorieMedicament.ANTISPAMODIQUES);
        Medicament Corticoides = new Medicament("Corticoïdes",15.00,"28/07/2021",1,
                CategorieMedicament.CORTICOIDES);
        Medicament antibacteriens = new Medicament("antibactériens",12.50,"08/02/2023",1,
                CategorieMedicament.ANTIBACTERIENS);
        Medicament Polymyxines = new Medicament("Polymyxines",24.33,"12/06/2022",1,
                CategorieMedicament.POLYMIXINES);
        Medicament Tetracyclines = new Medicament("Tétracyclines",30.48,"01/01/2021",1,
                CategorieMedicament.TETRECYCLINES);
        Medicament Antituberculeux = new Medicament("Antituberculeux",36,"12/2022",1,
                CategorieMedicament.ANTITUBERCULEUX);

        medic.add(paracetamol);
        medic.add(Corticoides);
        medic.add(Antispasmodiques);
        medic.add(antibacteriens);
        medic.add(Polymyxines);
        medic.add(Tetracyclines);
        medic.add(Antituberculeux);


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

        setTitle("Accueil");

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
        Retour.addActionListener(e -> {setContentPane(PanelAcceuil); setTitle("Accueil");});

        //page d'achat
        Effectuer.addActionListener(e -> {
            setTitle("Achat");
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
            setTitle("Recherche : ordonnance");
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
            setTitle("Recherche : achat");
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

        //panel info client
        RechercherClient.addActionListener(e -> {
            setTitle("Information client");
            setContentPane(PanelInfoClient);

            errorlbl.setVisible(false);
            modifierButton.setVisible(false);
            validerInfoButton.setVisible(false);
            modifierButton.setVisible(true);
            numeroTextField.setEditable(false);
            rueTextField.setEditable(false);
            codePostalTextField.setEditable(false);
            villeTextField.setEditable(false);

            medecinTraitantTextField.setEditable(false);
            mutuelleTextField.setEditable(false);

            dateDeNaissanceTextField.setEditable(false);
            numeroDeSecuriteSocialeTextField.setEditable(false);


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
            setTitle("Achat");
            if (!listMedAchat.isEmpty()){
                listMedAchat.clear();
            }
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
            setTitle("Recherche");
            textFieldRecherche.setVisible(false);
            setContentPane(PanelRecherche);
            revalidate();
            repaint();
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
                setTitle("Information client");
                setContentPane(PanelInfoClient);


                errorlbl.setVisible(false);
                modifierButton.setVisible(false);
                validerInfoButton.setVisible(false);
                modifierButton.setVisible(true);
                numeroTextField.setEditable(false);
                rueTextField.setEditable(false);
                codePostalTextField.setEditable(false);
                villeTextField.setEditable(false);

                medecinTraitantTextField.setEditable(false);
                mutuelleTextField.setEditable(false);

                nomComboBox.setVisible(true);
                nomComboBox.removeAllItems();
                prenomComboBox.setVisible(true);
                prenomComboBox.removeAllItems();

                NomTextField.setText("");
                NomTextField.setVisible(false);
                NomTextField.setEditable(false);

                dateDeNaissanceTextField.setEditable(false);
                numeroDeSecuriteSocialeTextField.setEditable(false);

                for (Client client : listClient) {
                    nomComboBox.addItem(client.getNom());
                    prenomComboBox.addItem(client.getPrenom());
                }

                validCreationButton.setVisible(false);

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
        nouveauClient();
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
            try{



                    //en fonction du medicament choisit l'ajoute avec toutes ses informations dans la table recap
                    for (Medicament med : listMed) {
                        if (med.getNom().equals(libelleComboBox.getSelectedItem()) &&
                                med.getCategorie().toString().toLowerCase().equals(cBoxCat.getSelectedItem())) {
                            m = med;
                        }
                    }
                    if (m != null) {
                        if (Integer.parseInt(QteTextField.getText())<1){
                            throw new IllegalArgumentException("la quantité doit etre positive");
                        }else {
                            modelRecapMed.addRow(new Object[]{m.getNom(), m.getCategorie(), QteTextField.getText(),
                                    m.getPrix(), m.getDateMES()});
                            sommeTot[0] = sommeTot[0] + (m.getPrix() * Double.parseDouble(QteTextField.getText()));
                            listMedAchat.add(m);
                        }
                    }

                    if (libelleComboBox.getSelectedItem()==null || libelleComboBox.getSelectedItem().equals("")){
                        throw new NullPointerException("Médicament nécessaire");
                    }else {
                        lblErreurAchat.setVisible(false);
                    }



            }catch(Exception erreur) {
                lblErreurAchat.setVisible(true);
                lblErreurAchat.setText(erreur.getMessage());
                lblErreurAchat.setForeground(Color.red);
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

    // action bouton nouveau client
    private void nouveauClient(){
        NewClietnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // affichage d'une nouvelle fenetre (unique ne peut pas etre dupliquer)
                // avec panelInfoClient modifier
                nouvClient.setContentPane(PanelInfoClient);
                nouvClient.setBounds(750,500,750,500);
                nouvClient.setTitle("nouveau client");
                nouvClient.setVisible(true);

                CreationClient();

            }
        });
    }

    // methode
    private void CreationClient(){

        nomComboBox.setVisible(false);
        prenomComboBox.setVisible(false);

        validCreationButton.setVisible(true);
        nomComboBox.setSelectedIndex(-1);
        telTextField.setEditable(true);
        telTextField.setVisible(true);
        lblTel.setVisible(true);
        mailTextField.setVisible(true);
        mailTextField.setEditable(true);
        lblMail.setVisible(true);
        numeroTextField.setEditable(true);
        rueTextField.setEditable(true);
        codePostalTextField.setEditable(true);
        villeTextField.setEditable(true);
        dateDeNaissanceTextField.setEditable(true);
        mutuelleTextField.setEditable(true);
        numeroDeSecuriteSocialeTextField.setEditable(true);
        medecinTraitantTextField.setEditable(true);


        final String[] donnees = {""};
            validCreationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        int id = listClient.size()+1;
                        String nom =  NomTextField.getText();
                        String prenom = PrenomTextField.getText();
                        String mail = mailTextField.getText();
                        String tel =telTextField.getText();
                        String dateNaiss = dateDeNaissanceTextField.getText();
                        String numSecu = numeroDeSecuriteSocialeTextField.getText();
                        donnees[0] = id+" |\n"+nom+" |\n"+prenom+" |\n"+ mail+" |\n"+tel+" |\n"+dateNaiss
                                +" |\n"+numSecu;
                    Client client = new Client(id, nom, prenom, mail, tel, listAdresse.get(0), dateNaiss,
                            listMedecin.get(0), listMutuelle.get(0), numSecu);
                    listClient.add(client);
                    }catch (Exception exception){
                        JOptionPane.showMessageDialog(null, donnees[0] + "\n"+
                                exception.getMessage());
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

    // bouton valider -> verif condition achat avant archivage
    private  void validerAchat(){

        validerButton.addActionListener(e -> {

            Client c = null;

            String regexIDOrd = "[0-9]";
            Ordonnance ord = null;
            try {
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
                if (ordonnanceRadioButton.isSelected()) {
                    if (nOrdonannceTextField.getText().isEmpty()){
                        throw new NullPointerException("Numéro Ordonnance nécéssaire");
                    }
                    if (Pattern.matches(regexIDOrd,nOrdonannceTextField.getText())) {
                        for (Ordonnance ordonnance:listOrdonnance){
                            if (ordonnance.getId()==Integer.parseInt(nOrdonannceTextField.getText())){
                                ord=ordonnance;
                            }
                        }
                    }
                    else {
                        throw new IllegalArgumentException("Numéro Ordonnance incorrect");
                    }
                }


                if (Objects.equals(cBoxPrenom.getSelectedItem(), "") || cBoxPrenom.getSelectedItem()==null){
                    throw new NullPointerException("Sélectionnez un client");
                } else if (listMedAchat.isEmpty()) {
                    throw new NullPointerException("Médicament nécéssaire");
                } else {
                    lblErreurClient.setVisible(false);
                    Achat achat = new Achat(c, new ArrayList<Medicament>(listMedAchat), sommeTot[0], classMetier.Util.Date.newDate(),ord );
                    listAchat.add(achat);
                    setContentPane(PanelAcceuil);
                }
            }catch (Exception exception){
                System.out.println(exception.getMessage());
                if(exception.getMessage().equals("Sélectionnez un client")){
                    lblErreurOdronnance.setVisible(false);
                    lblErreurClient.setVisible(true);
                    lblErreurClient.setText(exception.getMessage());
                    lblErreurClient.setForeground(Color.red);
                }
                if (exception.getMessage().equals("Médicament nécéssaire")) {
                    lblErreurClient.setVisible(false);
                    lblErreurAchat.setVisible(true);
                    lblErreurAchat.setText(exception.getMessage());
                    lblErreurAchat.setForeground(Color.red);
                }
                if (exception.getMessage().equals("Numéro Ordonnance nécéssaire") || exception.getMessage().equals("Numéro Ordonnance incorrect")){
                    lblErreurOdronnance.setVisible(true);
                    lblErreurOdronnance.setText(exception.getMessage());
                    lblErreurOdronnance.setForeground(Color.red);
                }
            }
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
            model.addColumn("Liste medicament");
            model.addColumn("Prix");

            if(!listAchat.isEmpty()) {
                for (Achat achat : listAchat) {
                    String a = achat.getClient().getNom() + " " + achat.getClient().getPrenom();
                    String b = "";
                    if (achat.getListMed()!=null) {
                        for (Medicament medicament : achat.getListMed()) {
                            b = b + " | " + medicament.getNom();
                        }
                    }
                    if (achat.getOrdonnance() != null) {
                        model.addRow(new Object[]{achat.getDate(), a, achat.getOrdonnance().getId(),
                                b, achat.getPrix()});
                    } else {
                        model.addRow(new Object[]{achat.getDate(), a, "",
                                b, achat.getPrix()});
                    }
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
        textFieldRecherche.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String recherche = null;

                try {
                    if (Pattern.matches(Regex.getRegexDate(), textFieldRecherche.getText())) {
                        recherche = textFieldRecherche.getText();
                        lblErreurRecherche.setVisible(false);
                    }
                    else {
                        throw new IllegalArgumentException("Date incorrecte");
                    }

                    DefaultTableModel x = (DefaultTableModel) labelTable.getModel();
                    x.setRowCount(0);
                    DefaultTableModel model = new DefaultTableModel();

                    model.addColumn("Date");
                    model.addColumn("Client");
                    model.addColumn("ID ordonnance");
                    model.addColumn("Prix");


                    for (classMetier.Util.Achat achat : listAchat) {
                        if (recherche.equals(achat.getDate())) {
                            String a = achat.getClient().getNom() + " " + achat.getClient().getPrenom();
                            if (achat.getOrdonnance() != null) {
                                model.addRow(new Object[]{achat.getDate(), a, achat.getOrdonnance().getId(), achat.getPrix()});
                            } else {
                                model.addRow(new Object[]{achat.getDate(), a, "", achat.getPrix()});
                            }
                        }
                    }


                    labelTable.setModel(model);
                    labelTable.setAutoCreateRowSorter(true);
                    labelTable.setDefaultEditor(Object.class, null);
                }
                catch (Exception exception){
                    lblErreurRecherche.setVisible(true);
                    lblErreurRecherche.setText(exception.getMessage());
                    lblErreurRecherche.setForeground(Color.red);
                }
            }

            //@Override
            //public void (ActionEvent e) {
            //
            //}
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
                                        numeroTextField.setText(client.getTel());
                                        rueTextField.setText(client.getAdresse().getRue());
                                        codePostalTextField.setText(client.getAdresse().getCodePostal());
                                        villeTextField.setText(client.getAdresse().getVille());
                                        dateDeNaissanceTextField.setText(client.getDateNaiss());
                                        mutuelleTextField.setText(client.getMutuelle().getNom());
                                        numeroDeSecuriteSocialeTextField.setText(client.getNumSecu());
                                        medecinTraitantTextField.setText(client.getMedecin().getNom());
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
                                            nomMedecinTextField.setText(ordonnance.getMedecin().getNom());
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
        miseAJour();
    }

    private void triNom(){
        // tri prénom client si plusieurs
        //sinon affiche détails client
        nomComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client c = null;
                prenomComboBox.removeAllItems();

                errorlbl.setVisible(false);
                modifierButton.setVisible(false);
                validerInfoButton.setVisible(false);
                numeroTextField.setEditable(false);
                rueTextField.setEditable(false);
                codePostalTextField.setEditable(false);
                villeTextField.setEditable(false);

                medecinTraitantTextField.setEditable(false);
                mutuelleTextField.setEditable(false);

                telTextField.setEditable(false);
                mailTextField.setEditable(false);

                // affichage page index selection =-1
                // informations client vide
                if (nomComboBox.getSelectedIndex() == -1) {

                    modifierButton.setVisible(false);

                    NomTextField.setText("");
                    telTextField.setText("");
                    telTextField.setEditable(false);
                    mailTextField.setText("");
                    mailTextField.setEditable(false);
                    PrenomTextField.setText("");
                    numeroTextField.setText("");
                    rueTextField.setText("");
                    codePostalTextField.setText("");
                    villeTextField.setText("");
                    dateDeNaissanceTextField.setText("");
                    mutuelleTextField.setText("");
                    numeroDeSecuriteSocialeTextField.setText("");
                    medecinTraitantTextField.setText("");
                } else {
                    for (Client client : listClient) {
                        if (client.getNom().equals(nomComboBox.getSelectedItem())) {

                            prenomComboBox.addItem(client.getPrenom());
                            c = client;
                        }
                    }
                    // si un seul prenom associé au nom alors affiche par default les données
                    if (prenomComboBox.getItemCount() == 1 && c != null) {

                        NomTextField.setText(c.getNom());
                        PrenomTextField.setText(c.getPrenom());
                        lblTel.setVisible(true);
                        telTextField.setVisible(true);
                        telTextField.setText(c.getTel());
                        lblMail.setVisible(true);
                        mailTextField.setText(c.getMail());
                        mailTextField.setVisible(true);
                        numeroTextField.setText(c.getAdresse().getNumero()+"");
                        rueTextField.setText(c.getAdresse().getRue());
                        codePostalTextField.setText(c.getAdresse().getCodePostal());
                        villeTextField.setText(c.getAdresse().getVille());
                        dateDeNaissanceTextField.setText(c.getDateNaiss());
                        mutuelleTextField.setText(c.getMutuelle().getNom());
                        numeroDeSecuriteSocialeTextField.setText(c.getNumSecu());
                        medecinTraitantTextField.setText(c.getMedecin().getNom());
                    }
                }
            }
        });
    }

    private void triPrenom(){
        //affichage données client
        prenomComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                errorlbl.setVisible(false);
                validerInfoButton.setVisible(false);
                numeroTextField.setEditable(false);
                rueTextField.setEditable(false);
                codePostalTextField.setEditable(false);
                villeTextField.setEditable(false);

                medecinTraitantTextField.setEditable(false);
                mutuelleTextField.setEditable(false);

                telTextField.setEditable(false);
                mailTextField.setEditable(false);

                for (Client client : listClient) {
                    if (client.getNom().equals(nomComboBox.getSelectedItem())
                            && client.getPrenom().equals(prenomComboBox.getSelectedItem())) {

                        modifierButton.setVisible(true);

                        NomTextField.setText(client.getNom());
                        PrenomTextField.setText(client.getPrenom());
                        telTextField.setText(client.getTel());
                        mailTextField.setText(client.getMail());
                        numeroTextField.setText(client.getAdresse().getNumero()+"");
                        rueTextField.setText(client.getAdresse().getRue());
                        codePostalTextField.setText(client.getAdresse().getCodePostal());
                        villeTextField.setText(client.getAdresse().getVille());
                        dateDeNaissanceTextField.setText(client.getDateNaiss());
                        mutuelleTextField.setText(client.getMutuelle().getNom());
                        numeroDeSecuriteSocialeTextField.setText(client.getNumSecu());
                        medecinTraitantTextField.setText(client.getMedecin().getNom());
                    }
                }
            }
        });

    }

    private void miseAJour(){
        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                telTextField.setEditable(true);
                mailTextField.setEditable(true);

                numeroTextField.setEditable(true);
                rueTextField.setEditable(true);
                codePostalTextField.setEditable(true);
                villeTextField.setEditable(true);

                medecinTraitantTextField.setEditable(true);
                mutuelleTextField.setEditable(true);
                modifierButton.setVisible(false);
                validerInfoButton.setVisible(true);


            }
        });

            validerInfoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    for (Client c : listClient){
                        if (c.getNom().equals(nomComboBox.getSelectedItem())&&c.getPrenom().equals(prenomComboBox.getSelectedItem())){

                            boolean y=true;

                            try {
                                if (telTextField.getText().matches(Regex.getRegexTel())) {
                                    c.setTel(telTextField.getText());
                                }
                                else {
                                    throw new IllegalArgumentException("Le numéro de téléphone est incorrect");
                                }
                            } catch (Exception exception) {
                                y=false;
                                errorlbl.setVisible(true);
                                errorlbl.setText(exception.getMessage());
                            }

                            try {
                                if (mailTextField.getText().matches(Regex.getRegexMail())) {
                                    c.setMail(mailTextField.getText());
                                } else {
                                    throw new IllegalArgumentException("Le mail est incorrect");
                                }
                            } catch (Exception exception) {
                                errorlbl.setVisible(true);
                                errorlbl.setText(exception.getMessage());
                                    y=false;
                            }


                            Adresse add = null;
                            String numero = null;
                            String rue = null;
                            String ville = null;
                            String cp = null;


                            
                            try{

                                if (numeroTextField.getText().matches(Regex.getRegexNumeroAdresse())){
                                        numero=numeroTextField.getText();
                                }
                                else {
                                    throw new IllegalArgumentException("le numero de rue est incorrecte");
                                }

                                if (rueTextField.getText().matches(Regex.getRegexNomAdresse())){
                                    rue=rueTextField.getText();
                                }
                                else{
                                    throw new IllegalArgumentException("le nom de la rue est incorrecte");
                                }

                                if (villeTextField.getText().matches(Regex.getRegexVille())){
                                    ville=villeTextField.getText();
                                }
                                else {
                                    throw new IllegalArgumentException("la ville est incorrecte");
                                }

                                if (codePostalTextField.getText().matches(Regex.getRegexCodePostal())){
                                    cp=codePostalTextField.getText();
                                }
                                else {
                                    throw new IllegalArgumentException("le code postal est incorrecte");
                                }

                                for (Adresse adresse: listAdresse){
                                    if (adresse.getNumero()==Integer.parseInt(numero)
                                            && adresse.getRue().equals(rue)
                                            && adresse.getVille().equals(ville)
                                            && adresse.getCodePostal().equals(cp)){
                                        add=adresse;
                                    }
                                }



                            } catch (Exception exception){
                                errorlbl.setVisible(true);
                                errorlbl.setText(exception.getMessage());
                                y=false;
                            }

                            if (add!=null){
                                c.setAdresse(add);
                            }
                            else {
                                try {
                                Adresse newAdresse = new Adresse(Integer.parseInt(numero), rue, cp, ville);
                                listAdresse.add(newAdresse);
                                c.setAdresse(newAdresse);
                                }
                                catch (Exception exception){
                                    errorlbl.setVisible(true);
                                    errorlbl.setText(exception.getMessage());
                                    y=false;
                                }

                            }


                            try {
                                if (y) {
                                    System.out.println("Mise a jour des informations");
                                    errorlbl.setVisible(false);
                                    telTextField.setEditable(false);
                                    mailTextField.setEditable(false);
                                    numeroTextField.setEditable(false);
                                    rueTextField.setEditable(false);
                                    codePostalTextField.setEditable(false);
                                    villeTextField.setEditable(false);

                                    medecinTraitantTextField.setEditable(false);
                                    mutuelleTextField.setEditable(false);

                                    modifierButton.setVisible(true);
                                    validerInfoButton.setVisible(false);
                                }
                            }catch (Exception exception){
                                JOptionPane.showMessageDialog(Principale.this,
                                        "Erreur lors de la mise a jour des informations"+
                                                "\n"+exception.getMessage());
                            }

                        }
                    }

                }
            });


    }
}