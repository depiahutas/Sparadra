package classMetier.sante;

import classMetier.Util.Adresse;

public class Mutuelle {
    private Adresse adresse;
    private String nom;
    private String tel;
    private String mail;
    private int departement;
    private int txPECR;

    public Mutuelle(Adresse adresse, String nom, String tel, String mail, int departement, int txPECR) {
        this.adresse = adresse;
        this.nom = nom;
        this.tel = tel;
        this.mail = mail;
        this.departement = departement;
        this.txPECR = txPECR;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getDepartement() {
        return departement;
    }

    public void setDepartement(int departement) {
        this.departement = departement;
    }

    public int getTxPECR() {
        return txPECR;
    }

    public void setTxPECR(int txPECR) {
        this.txPECR = txPECR;
    }
}
