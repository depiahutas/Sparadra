package Frame;

import DAO.Util.AchatDAO;
import DAO.Util.AdresseDAO;
import DAO.Util.PanierDAO;
import DAO.personne.ClientDAO;
import DAO.personne.MedecinDAO;
import DAO.personne.personneDAO;
import DAO.sante.CategorieMedicamentDAO;
import DAO.sante.MedicamentDAO;
import DAO.sante.MutuelleDAO;
import DAO.sante.OrdonnanceDAO;
import classMetier.Util.*;
import classMetier.personne.Client;
import classMetier.personne.Medecin;
import classMetier.personne.Personne;
import classMetier.sante.CategorieMedicament;
import classMetier.sante.Medicament;
import classMetier.sante.Mutuelle;
import classMetier.sante.Ordonnance;
import com.itextpdf.text.DocumentException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

import static classMetier.Util.FilePdf.createPdf;
import static classMetier.Util.FilePdf.openPdf;

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
    private JPanel PanelOpenPDF;
    private JPanel PanelListMedOrd;
    private JButton btnOpenPDF;
    private JButton historiqueMutuelleButton;
    private JComboBox CBBoxMutuelle;
    private JButton gestionStockButton;
    private JPanel PanelGestionStock;
    private JTable TabMedic;
    private JPanel PanelTabMedic;
    private JLabel lblRechercheMed;
    private JPanel PanelRechercheMed;
    private JTextField txtFieldRchMed;
    private JComboBox cbBoxMutuelle;
    private JComboBox cbBoxMedecin;
    private JButton validerAchatButton;

    private final ButtonGroup buttonGroup = new ButtonGroup();

   // ArrayList<Medecin> listMedecin = new ArrayList<>();
   // ArrayList<Mutuelle> listMutuelle = new ArrayList<>();
   // ArrayList<Client> listClient = new ArrayList<>();
   // ArrayList<Medicament> listMed = new ArrayList<>();
   // ArrayList<Medicament> medic = new ArrayList<>();
   // ArrayList<Ordonnance> listOrdonnance = new ArrayList<>();
   // ArrayList<Achat> listAchat = new ArrayList<>();
   // ArrayList<CategorieMedicament> listCategorie = new ArrayList<>();

    //liste Adresse
   //ArrayList<Adresse> listAdresse = new ArrayList<>();

    //java.util.List<Personne> listPersonne = new ArrayList<>();


    //liste medicament pour achat
    ArrayList<Medicament> listMedAchat = new ArrayList<>();



    // model recapMed pour achat
    DefaultTableModel modelRecapMed = new DefaultTableModel();


    final float[] sommeTot = {0.00f};

    Dimension d = new Dimension(750, 350);

    JFrame nouvClient = new JFrame();

    CategorieMedicamentDAO catDAO = new CategorieMedicamentDAO();

    ClientDAO clientDAO = new ClientDAO();

    MedecinDAO medecinDAO = new MedecinDAO();

    MutuelleDAO mutuelleDAO = new MutuelleDAO();

    MedicamentDAO medicamentDAO = new MedicamentDAO();

    OrdonnanceDAO ordonnanceDAO = new OrdonnanceDAO();

    AchatDAO achatDAO = new AchatDAO();

    PanierDAO panierDAO = new PanierDAO();

    AdresseDAO adresseDAO = new AdresseDAO();

    personneDAO personneDAO = new personneDAO();




    public Principale() throws IOException, ClassNotFoundException {

        // button group pour achat-> radio boutton ordonnance choix unique
        buttonGroup.add(ordonnanceRadioButton);
        buttonGroup.add(sansOrdonnanceRadioButton);

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
        JMenu RechercheClient = new JMenu("Recherche Client");
        JMenu Stock = new JMenu("Stock");

        JMenuItem Retour = new JMenuItem("Retour");
        JMenuItem Effectuer = new JMenuItem("Effectuer achat");
        JMenuItem RechercherOrd = new JMenuItem("Ordonnance");
        JMenuItem RechercherAch = new JMenuItem("Achat");
        JMenuItem RechercherClientNom = new JMenuItem("par Nom");
        JMenuItem RechercherClientMutuelle = new JMenuItem("par Mutuelle");
        JMenuItem GestionStock = new JMenuItem("Gestion");

        Accueil.add(Retour);
        Achat.add(Effectuer);
        recherche.add(RechercherOrd);
        recherche.add(RechercherAch);
        recherche.add(RechercheClient);
        RechercheClient.add(RechercherClientNom);
        RechercheClient.add(RechercherClientMutuelle);
        Stock.add(GestionStock);

        mbar.add(Accueil);
        mbar.add(Achat);
        mbar.add(recherche);
        mbar.add(Stock);

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
            for (CategorieMedicament c : catDAO.findAll()) {
                cBoxCat.addItem(c.getLibelle().toLowerCase());
            }
            cBoxCat.setSelectedIndex(-1);
            for (Client client : clientDAO.findAll()) {
                cBoxNom.addItem(client.getPersonne().getNom());
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
            historiqueMutuelleButton.setVisible(false);
            CBBoxMutuelle.setVisible(false);
            rechercheComboBox.removeAllItems();


            DefaultTableModel x = (DefaultTableModel) labelTable.getModel();
            x.setRowCount(0);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Medecin");
            model.addColumn("Client");
            model.addColumn("ID ordonnance");
            model.addColumn("Date");
            model.addColumn("Medicament");


            for (Medecin medecin : medecinDAO.findAll()) {
                rechercheComboBox.addItem(medecin.getPersonne().getNom());
            }
            rechercheComboBox.setSelectedIndex(-1);


            for (Ordonnance ordonnance : ordonnanceDAO.findAll()) {
                String a = ordonnance.getClient().getPersonne().getNom() + " " + ordonnance.getClient().getPersonne().getPrenom();
                model.addRow(new Object[]{ordonnance.getMedecin().getPersonne().getNom(),
                        a, ordonnance.getId(),ordonnance.getDate(),
                        ordonnance.getCompose().getListMedToString()});
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

            for (Achat achat : achatDAO.findAll()) {
                String a = achat.getClient().getPersonne().getNom() + " " + achat.getClient().getPersonne().getPrenom();
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

        //Recherche Client par Mutuelle
        RechercherClientMutuelle.addActionListener(e -> {
            setTitle("Recherche : Client-Mutuelle");
            setContentPane(PanelRecherche);

            historiqueDAchatButton.setVisible(false);
            historiqueOrdonnanceButton.setVisible(false);
            historiqueMutuelleButton.setVisible(false);
            CBBoxMutuelle.setVisible(true);

            CBBoxMutuelle.removeAllItems();
            for (Mutuelle mutuelle:mutuelleDAO.findAll()){
                CBBoxMutuelle.addItem(mutuelle.getNom());
            }

            DefaultTableModel x = (DefaultTableModel) labelTable.getModel();
            x.setRowCount(0);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mutuelle");
            model.addColumn("Client");
            model.addColumn("Medecin traitant");

            for (Client client : clientDAO.findAll()) {
                model.addRow(new Object[]{client.getMutuelle().getNom(), (client.getPersonne().getNom() + " " + client.getPersonne().getPrenom()),
                        ("Dr." + client.getMedecin().getPersonne().getNom())});
            }
            labelTable.setModel(model);
            labelTable.setAutoCreateRowSorter(true);
            labelTable.setDefaultEditor(Object.class, null);
        });

        //panel info client
        RechercherClientNom.addActionListener(e -> {
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

            for (Client client : clientDAO.findAll()) {
                nomComboBox.addItem(client.getPersonne().getNom());
                prenomComboBox.addItem(client.getPersonne().getPrenom());
            }


            prenomComboBox.setVisible(true);
            PrenomTextField.setText("");
            PrenomTextField.setVisible(false);
            PrenomTextField.setEditable(false);

            nomComboBox.setSelectedIndex(-1);
            prenomComboBox.setSelectedIndex(-1);
        });

        // affichage panel Gestion des Stocks de medicament
        // via menu bar
        GestionStock.addActionListener(e -> {
            setTitle("Gestion des Stock");
            setContentPane(PanelGestionStock);


            DefaultTableModel x = (DefaultTableModel) TabMedic.getModel();
            x.setRowCount(0);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Libelle");
            model.addColumn("Prix");
            model.addColumn("Categorie");
            model.addColumn("Quantite en stock");
            model.addColumn("DateMES");

            for (Medicament med : medicamentDAO.findAll()) {
                model.addRow(new Object[]{med.getNom(),med.getPrix(),med.getCategorie(),med.getQuantite(),med.getDateMES()});
            }

            TabMedic.setAutoCreateRowSorter(true);
            TabMedic.setDefaultEditor(Object.class, null);
            TabMedic.setModel(model);

            triStock();

            revalidate();
            repaint();
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
        actionBtnStock();
    }

    private void actionBtnAchat(){
        //Affichage panel Achat et réinitialise les données du form
        btnAchat.addActionListener(e -> {
            setTitle("Achat");
            listMedAchat.clear();
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

            for (CategorieMedicament c :catDAO.findAll()) {
                cBoxCat.addItem(c.getLibelle().toLowerCase());
            }
            cBoxCat.setSelectedIndex(-1);

            for (Client client : clientDAO.findAll()) {
                cBoxNom.addItem(client.getPersonne().getNom());
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
            historiqueMutuelleButton.setVisible(true);
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

                for (Client client : clientDAO.findAll()) {
                    nomComboBox.addItem(client.getPersonne().getNom());
                    prenomComboBox.addItem(client.getPersonne().getPrenom());
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

    private void actionBtnStock(){

        gestionStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTitle("Gestion des Stock");
                setContentPane(PanelGestionStock);


                DefaultTableModel x = (DefaultTableModel) TabMedic.getModel();
                x.setRowCount(0);
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Libelle");
                model.addColumn("Prix");
                model.addColumn("Categorie");
                model.addColumn("Quantite en stock");
                model.addColumn("DateMES");

                for (Medicament med : medicamentDAO.findAll()) {
                    model.addRow(new Object[]{med.getNom(),med.getPrix(),med.getCategorie().getLibelle(),med.getQuantite(),med.getDateMES()});
                }

                TabMedic.setAutoCreateRowSorter(true);
                TabMedic.setDefaultEditor(Object.class, null);
                TabMedic.setModel(model);


                triStock();

                revalidate();
                repaint();
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
                    for (Medicament med : medicamentDAO.findAll()) {
                        if (med.getNom().equals(libelleComboBox.getSelectedItem()) &&
                                med.getCategorie().getLibelle().toString().toLowerCase().equals(cBoxCat.getSelectedItem())) {
                            m = med;
                        }
                    }
                    if (m != null) {
                        if (Integer.parseInt(QteTextField.getText())<1){
                            throw new IllegalArgumentException("la quantité doit etre positive");
                        }else {
                            modelRecapMed.addRow(new Object[]{m.getNom(), m.getCategorie().getLibelle(), QteTextField.getText(),
                                    m.getPrix(), m.getDateMES()});
                            sommeTot[0] = sommeTot[0] + (m.getPrix() * Integer.parseInt(QteTextField.getText()));
                            m.setQuantite(Integer.parseInt(QteTextField.getText()));
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
            for (Client client : clientDAO.findAll()) {
                if (client.getPersonne().getNom().equals(cBoxNom.getSelectedItem())) {
                    cBoxPrenom.addItem(client.getPersonne().getPrenom());
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
        PrenomTextField.setVisible(true);
        PrenomTextField.setEditable(true);
        NomTextField.setVisible(true);
        NomTextField.setEditable(true);

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
        mutuelleTextField.setVisible(false);
        numeroDeSecuriteSocialeTextField.setEditable(true);
        medecinTraitantTextField.setVisible(false);
        cbBoxMedecin.setVisible(true);
        cbBoxMutuelle.setVisible(true);

        cbBoxMedecin.removeAllItems();
        for (Medecin medecin: medecinDAO.findAll()) {
            cbBoxMedecin.addItem("Dr. "+medecin.getPersonne().getNom());
        }

        cbBoxMutuelle.removeAllItems();
        for (Mutuelle mutuelle: mutuelleDAO.findAll()) {
            cbBoxMutuelle.addItem(mutuelle.getNom());
        }


        final String[] donnees = {""};
            validCreationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        Adresse adr = new Adresse(0, Integer.parseInt(numeroTextField.getText()),
                                rueTextField.getText(),
                                codePostalTextField.getText(),
                                villeTextField.getText());


                        adresseDAO.verif_adr(adr);
                        Personne p = new Personne(0,
                            NomTextField.getText(),
                            PrenomTextField.getText(),
                            mailTextField.getText(),
                            telTextField.getText(),
                            adr
                            );

                        personneDAO.verif_per(p);

                        String dateNaiss = dateDeNaissanceTextField.getText();
                        String numSecu = numeroDeSecuriteSocialeTextField.getText();

                        //donnees[0] = id+" |\n"+nom+" |\n"+prenom+" |\n"+ mail+" |\n"+tel+" |\n"+dateNaiss
                        //       +" |\n"+numSecu;

                        System.out.println(cbBoxMedecin.getSelectedItem().toString().substring(4));

                        Client client = new Client(0, p, dateNaiss,
                                medecinDAO.findMed(cbBoxMedecin.getSelectedItem().toString().substring(4)),
                                mutuelleDAO.findMut(cbBoxMutuelle.getSelectedItem().toString()),
                                numSecu
                        );

                        clientDAO.verif_client(client);


                        JOptionPane.showMessageDialog(null, "Client Ajouté");



                        cBoxNom.removeAllItems();
                        for (Client clients : clientDAO.findAll()) {
                            cBoxNom.addItem(clients.getPersonne().getNom());
                        }

                        cBoxPrenom.removeAllItems();
                        for (Client clients : clientDAO.findAll()) {
                            cBoxPrenom.addItem(clients.getPersonne().getPrenom());
                        }
                        cBoxNom.setSelectedIndex(cBoxNom.getItemCount() - 1);
                        nouvClient.dispose();

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
                for (Medicament med : medicamentDAO.findAll()) {
                    libelleComboBox.addItem(med.getNom());
                }
                libelleComboBox.setSelectedIndex(-1);
            } else {
                libelleComboBox.removeAllItems();
                for (Medicament med : medicamentDAO.findAll()) {
                    if (med.getCategorie().getLibelle().toLowerCase().equals(cBoxCat.getSelectedItem())) {
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
                for (Medicament med : medicamentDAO.findAll()) {
                    if (med.getNom().equals(libelleComboBox.getSelectedItem())) {
                        cBoxCat.setSelectedItem(med.getCategorie().toString().toLowerCase());
                    }
                }
            } else {
                for (Medicament m : medicamentDAO.findAll()) {
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
            Panier p = new Panier(0,listMedAchat);

            String regexIDOrd = "[0-9]";
            Ordonnance ord = null;
            try {
                for (Client client : clientDAO.findAll()) {
                    if (cBoxPrenom.getSelectedItem() == null) {
                        if (client.getPersonne().getNom().equals(cBoxNom.getSelectedItem())) {
                            c = client;
                        }
                    } else if (client.getPersonne().getNom().equals(cBoxNom.getSelectedItem())
                            && client.getPersonne().getPrenom().equals(cBoxPrenom.getSelectedItem())) {
                        c = client;
                    }
                }
                if (ordonnanceRadioButton.isSelected()) {
                    if (nOrdonannceTextField.getText().isEmpty()){
                        throw new NullPointerException("Numéro Ordonnance nécéssaire");
                    }
                    if (Pattern.matches(regexIDOrd,nOrdonannceTextField.getText())) {
                        for (Ordonnance ordonnance: ordonnanceDAO.findAll()){
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
                    Achat achat = new Achat(0,c,p
                            , sommeTot[0], classMetier.Util.Date.newDate(),ord );

                    achatDAO.create(achat);
                    //listAchat.add(achat);
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

        //Recherche Mutuelle
        RechercheMutuelle();
        triMutuelle();

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
            historiqueMutuelleButton.setVisible(false);
            CBBoxMutuelle.setVisible(false);

            DefaultTableModel x = (DefaultTableModel) labelTable.getModel();
            x.setRowCount(0);

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Date");
            model.addColumn("Client");
            model.addColumn("ID ordonnance");
            model.addColumn("Liste medicament");
            model.addColumn("Prix");

                for (Achat achat : achatDAO.findAll()) {
                    String a = achat.getClient().getPersonne().getNom() + " " + achat.getClient().getPersonne().getPrenom();
                    String b = "";
                    if (achat.getPanier().getResumePanier()!=null) {
                        for (Medicament medicament : achat.getPanier().getResumePanier()) {
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
            historiqueMutuelleButton.setVisible(false);
            CBBoxMutuelle.setVisible(false);
            rechercheComboBox.removeAllItems();


            DefaultTableModel x = (DefaultTableModel) labelTable.getModel();
            x.setRowCount(0);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Medecin");
            model.addColumn("Client");
            model.addColumn("ID ordonnance");
            model.addColumn("Date");
            model.addColumn("Medicament");


            for (Medecin medecin : medecinDAO.findAll()) {
                rechercheComboBox.addItem(medecin.getPersonne().getNom());
            }
            rechercheComboBox.setSelectedIndex(-1);


            for (Ordonnance ordonnance : ordonnanceDAO.findAll()) {
                String a = ordonnance.getClient().getPersonne().getNom() + " " + ordonnance.getClient().getPersonne().getPrenom();
                model.addRow(new Object[]{ordonnance.getMedecin().getPersonne().getNom(),
                        a, ordonnance.getId(),ordonnance.getDate(),
                        ordonnance.getCompose().getListMedToString()});
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

            for (Medecin medecin : medecinDAO.findAll()) {
                if (medecin.getPersonne().getNom().equals(rechercheComboBox.getSelectedItem())) {
                    for (Ordonnance ordonnance : ordonnanceDAO.findAll()) {
                        if (ordonnance.getMedecin().getPersonne().getNom().equals(medecin.getPersonne().getNom())) {
                            String a = ordonnance.getClient().getPersonne().getNom() + " " + ordonnance.getClient().getPersonne().getPrenom();
                            model.addRow(new Object[]{ordonnance.getMedecin().getPersonne().getNom(),
                                    a, ordonnance.getId(),ordonnance.getDate(), ordonnance.getCompose().getListMedToString()});
                        }
                    }
                }
            }
            labelTable.setModel(model);
            labelTable.setAutoCreateRowSorter(true);
            labelTable.setDefaultEditor(Object.class, null);
        });
    }

    private void RechercheMutuelle(){
        historiqueMutuelleButton.addActionListener(e -> {

            historiqueDAchatButton.setVisible(false);
            historiqueOrdonnanceButton.setVisible(false);
            historiqueMutuelleButton.setVisible(false);
            CBBoxMutuelle.setVisible(true);

            CBBoxMutuelle.removeAllItems();
            for (Mutuelle mutuelle:mutuelleDAO.findAll()){
                CBBoxMutuelle.addItem(mutuelle.getNom());
            }

            DefaultTableModel x = (DefaultTableModel) labelTable.getModel();
            x.setRowCount(0);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Mutuelle");
            model.addColumn("Client");
            model.addColumn("Medecin traitant");

            for (Client client : clientDAO.findAll()) {
                model.addRow(new Object[]{client.getMutuelle().getNom(), (client.getPersonne().getNom() + " " + client.getPersonne().getPrenom()),
                        ("Dr." + client.getMedecin().getPersonne().getNom())});
            }
            labelTable.setModel(model);
            labelTable.setAutoCreateRowSorter(true);
            labelTable.setDefaultEditor(Object.class, null);
        });

    }

    private void triMutuelle(){


        CBBoxMutuelle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel x = (DefaultTableModel) labelTable.getModel();
                x.setRowCount(0);
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Mutuelle");
                model.addColumn("Client");
                model.addColumn("Medecin traitant");

                for (Client client : clientDAO.findAll()) {
                    if (client.getMutuelle().getNom().equals(CBBoxMutuelle.getSelectedItem())) {

                        x.addRow(new Object[]{client.getMutuelle().getNom(), (client.getPersonne().getNom() + " " + client.getPersonne().getPrenom()),

                                ("Dr." + client.getMedecin().getPersonne().getNom())});

                    }
                }
            }
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
                    } else if (textFieldRecherche.getText().isEmpty()) {
                        lblErreurRecherche.setVisible(false);
                        recherche = "all";
                    } else {
                        throw new IllegalArgumentException("Date incorrecte");
                    }

                    DefaultTableModel x = (DefaultTableModel) labelTable.getModel();
                    x.setRowCount(0);
                    DefaultTableModel model = new DefaultTableModel();

                    model.addColumn("Date");
                    model.addColumn("Client");
                    model.addColumn("ID ordonnance");
                    model.addColumn("Prix");


                    if (recherche.equals("all")) {

                        for (classMetier.Util.Achat achat : achatDAO.findAll()) {
                                String a = achat.getClient().getPersonne().getNom() + " " + achat.getClient().getPersonne().getPrenom();
                                if (achat.getOrdonnance() != null) {
                                    model.addRow(new Object[]{achat.getDate(), a, achat.getOrdonnance().getId(), achat.getPrix()});
                                } else {
                                    model.addRow(new Object[]{achat.getDate(), a, "", achat.getPrix()});
                                }
                        }

                    } else {
                        for (classMetier.Util.Achat achat : achatDAO.findAll()) {
                            if (recherche.equals(achat.getDate())) {
                                String a = achat.getClient().getPersonne().getNom() + " " + achat.getClient().getPersonne().getPrenom();
                                if (achat.getOrdonnance() != null) {
                                    model.addRow(new Object[]{achat.getDate(), a, achat.getOrdonnance().getId(), achat.getPrix()});
                                } else {
                                    model.addRow(new Object[]{achat.getDate(), a, "", achat.getPrix()});
                                }
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

    private void triStock(){

        txtFieldRchMed.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                DefaultTableModel x = (DefaultTableModel) TabMedic.getModel();
                x.setRowCount(0);
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Libelle");
                model.addColumn("Prix");
                model.addColumn("Categorie");
                model.addColumn("Quantite en stock");
                model.addColumn("DateMES");

                String test=txtFieldRchMed.getText();
                for (Medicament med : medicamentDAO.findAll()) {
                    if (Objects.equals(txtFieldRchMed.getText(), "")){
                        model.addRow(new Object[]{med.getNom(),med.getPrix(),med.getCategorie().getLibelle().toLowerCase(),med.getQuantite(),med.getDateMES()});
                    }
                    if (med.getNom().toLowerCase().equals(test) || med.getCategorie().getLibelle().toLowerCase().equals(test)){
                        model.addRow(new Object[]{med.getNom(),med.getPrix(),med.getCategorie().getLibelle().toLowerCase(),med.getQuantite(),med.getDateMES()});
                    }
                }


                TabMedic.setAutoCreateRowSorter(true);
                TabMedic.setDefaultEditor(Object.class, null);
                TabMedic.setModel(model);

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
                                for (Client client : clientDAO.findAll()) {
                                    if ((client.getPersonne().getNom() + " " + client.getPersonne().getPrenom()).equals(target.getValueAt(row, column))) {
                                        NomTextField.setText(client.getPersonne().getNom());
                                        PrenomTextField.setText(client.getPersonne().getPrenom());
                                        numeroTextField.setText(client.getPersonne().getTel());
                                        rueTextField.setText(client.getPersonne().getAdresse().getRue());
                                        codePostalTextField.setText(client.getPersonne().getAdresse().getCodePostal());
                                        villeTextField.setText(client.getPersonne().getAdresse().getVille());
                                        dateDeNaissanceTextField.setText(client.getDateNaiss());
                                        mutuelleTextField.setText(client.getMutuelle().getNom());
                                        numeroDeSecuriteSocialeTextField.setText(client.getNumSecu());
                                        medecinTraitantTextField.setText(client.getMedecin().getPersonne().getNom());
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


                                    String name=null;
                                    String date = null;

                                    for (Ordonnance ordonnance : ordonnanceDAO.findAll()) {
                                        if (ordonnance.getId() ==
                                                Integer.parseInt(target.getValueAt(row, column).toString())) {
                                            lblDate.setText(ordonnance.getDate());
                                            nomMedecinTextField.setText(ordonnance.getMedecin().getPersonne().getNom());
                                            nomDuPatientTextField.setText(ordonnance.getClient().getPersonne().getNom());
                                            prenomTextField.setText(ordonnance.getClient().getPersonne().getPrenom());
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


                                            StringBuilder listMed= new StringBuilder();
                                            name=ordonnance.getClient().getPersonne().getNom()+" "+ordonnance.getClient().getPersonne().getPrenom();
                                            date = ordonnance.getDate().replace("/","-");
                                            String titre = "Ordonnance du " + date +" "+name;
                                            String medecin = ordonnance.getMedecin().getPersonne().getNom()+" "+ordonnance.getMedecin().getPersonne().getPrenom();

                                            for (Medicament med : ordonnance.getCompose().getListMedic()) {
                                                model.addRow(new Object[]{med.getCategorie().getLibelle(), med.getNom(), med.getDateMES(), med.getPrix()});
                                                listMed.append(med.getNom()).append("\n");
                                            }

                                            try {
                                                createPdf(titre,listMed.toString(),name,date,medecin);
                                            } catch (FileNotFoundException ex) {
                                                throw new RuntimeException(ex);
                                            } catch (DocumentException ex) {
                                                throw new RuntimeException(ex);
                                            }

                                            tableMed.setModel(model);


                                        }
                                    }

                                    afficherPdf(name,date);

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
                    for (Client client : clientDAO.findAll()) {
                        if (client.getPersonne().getNom().equals(nomComboBox.getSelectedItem())) {

                            prenomComboBox.addItem(client.getPersonne().getPrenom());
                            c = client;
                        }
                    }
                    // si un seul prenom associé au nom alors affiche par default les données
                    if (prenomComboBox.getItemCount() == 1 && c != null) {

                        NomTextField.setText(c.getPersonne().getNom());
                        PrenomTextField.setText(c.getPersonne().getPrenom());
                        lblTel.setVisible(true);
                        telTextField.setVisible(true);
                        telTextField.setText(c.getPersonne().getTel());
                        lblMail.setVisible(true);
                        mailTextField.setText(c.getPersonne().getMail());
                        mailTextField.setVisible(true);
                        numeroTextField.setText(c.getPersonne().getAdresse().getNumero()+"");
                        rueTextField.setText(c.getPersonne().getAdresse().getRue());
                        codePostalTextField.setText(c.getPersonne().getAdresse().getCodePostal());
                        villeTextField.setText(c.getPersonne().getAdresse().getVille());
                        dateDeNaissanceTextField.setText(c.getDateNaiss());
                        mutuelleTextField.setText(c.getMutuelle().getNom());
                        numeroDeSecuriteSocialeTextField.setText(c.getNumSecu());
                        medecinTraitantTextField.setText(c.getMedecin().getPersonne().getNom());
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

                for (Client client : clientDAO.findAll()) {
                    if (client.getPersonne().getNom().equals(nomComboBox.getSelectedItem())
                            && client.getPersonne().getPrenom().equals(prenomComboBox.getSelectedItem())) {

                        modifierButton.setVisible(true);

                        NomTextField.setText(client.getPersonne().getNom());
                        PrenomTextField.setText(client.getPersonne().getPrenom());
                        telTextField.setText(client.getPersonne().getTel());
                        mailTextField.setText(client.getPersonne().getMail());
                        numeroTextField.setText(client.getPersonne().getAdresse().getNumero()+"");
                        rueTextField.setText(client.getPersonne().getAdresse().getRue());
                        codePostalTextField.setText(client.getPersonne().getAdresse().getCodePostal());
                        villeTextField.setText(client.getPersonne().getAdresse().getVille());
                        dateDeNaissanceTextField.setText(client.getDateNaiss());
                        mutuelleTextField.setText(client.getMutuelle().getNom());
                        numeroDeSecuriteSocialeTextField.setText(client.getNumSecu());
                        medecinTraitantTextField.setText(client.getMedecin().getPersonne().getNom());
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

                    for (Client c : clientDAO.findAll()){
                        if (c.getPersonne().getNom().equals(nomComboBox.getSelectedItem())&&
                                c.getPersonne().getPrenom().equals(prenomComboBox.getSelectedItem())){

                            boolean y=true;

                            try {
                                if (telTextField.getText().matches(Regex.getRegexTel())) {
                                    c.getPersonne().setTel(telTextField.getText());
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
                                    c.getPersonne().setMail(mailTextField.getText());
                                } else {
                                    throw new IllegalArgumentException("Le mail est incorrect");
                                }
                            } catch (Exception exception) {
                                errorlbl.setVisible(true);
                                errorlbl.setText(exception.getMessage());
                                    y=false;
                            }


                            Adresse add = null;
                            int id = 0;
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

                                for (Adresse adresse: adresseDAO.findAll()){
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
                                c.getPersonne().setAdresse(add);
                            }
                            else {
                                try {
                                Adresse newAdresse = new Adresse(id,Integer.parseInt(numero), rue, cp, ville);
                                c.getPersonne().setAdresse(newAdresse);
                                }
                                catch (Exception exception){
                                    errorlbl.setVisible(true);
                                    errorlbl.setText(exception.getMessage());
                                    y=false;
                                }
                            }


                            try {
                                if (y) {
                                    //update dans base de données

                                    Adresse adresse = adresseDAO.find(c.getPersonne().getAdresse().getID());

                                    if( adresse == null){
                                        adresseDAO.create(adresse);
                                    }

                                    personneDAO.update(c.getPersonne());
                                    clientDAO.update(c);


                                    // rend les champs non modifiable une fois modification terminé
                                    JOptionPane.showMessageDialog(null,"Mise a jour des informations");
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

    private void afficherPdf(String name,String date){

        btnOpenPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    openPdf(name,date);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }


}