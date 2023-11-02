package classMetier.personne;

import classMetier.Util.Adresse;

public class Pharmacien extends Personne{
    public Pharmacien(int id,String nom, String prenom, String mail, String tel, Adresse adresse) {
        super(id,nom, prenom, mail, tel, adresse);
    }
}
