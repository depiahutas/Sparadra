package classMetier.personne;

import classMetier.Util.Adresse;
import classMetier.Util.Specialite;

public class Specialiste extends Medecin{
    private Specialite specialite;

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Specialiste(String nom, String prenom, String mail, String tel, Adresse adresse, int numAgr, Specialite specialite) {
        super(nom, prenom, mail, tel, adresse, numAgr);
        setSpecialite(specialite);
    }
}
