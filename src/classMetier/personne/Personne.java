package classMetier.personne;

import classMetier.Util.Adresse;

public abstract class Personne {
    private String nom;
    private String prenom;
    private String mail;
    private String tel;
    private Adresse adresse;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Personne(String nom, String prenom, String mail, String tel, Adresse adresse) {
        setNom(nom);
        setPrenom(prenom);
        setMail(mail);
        setTel(tel);
        setAdresse(adresse);
    }
}
